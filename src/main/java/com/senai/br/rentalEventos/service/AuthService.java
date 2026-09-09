package com.senai.br.rentalEventos.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.br.rentalEventos.dto.CadastroRequest;
import com.senai.br.rentalEventos.dto.LoginRequest;
import com.senai.br.rentalEventos.dto.LoginResponse;
import com.senai.br.rentalEventos.dto.UsuarioResponse;
import com.senai.br.rentalEventos.models.Usuario;
import com.senai.br.rentalEventos.repository.UsuarioRepository;
import com.senai.br.rentalEventos.security.TokenService;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }
    public UsuarioResponse cadastrar(CadastroRequest request) {
    String email = request.email().trim().toLowerCase();

    if (usuarioRepository.existsByEmailIgnoreCase(email)) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Email já cadastrado");
    }

    if (usuarioRepository.existsByCpf(request.cpf())) {
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, "CPF já cadastrado");
    }

    Usuario usuario = Usuario.builder()
            .nome(request.nome())
            .email(email)
            .cpf(request.cpf())
            .senha(passwordEncoder.encode(request.senha()))
            .dataNascimento(request.dataNascimento())
            .build();

    Usuario salvo = usuarioRepository.save(usuario);
    return new UsuarioResponse(
            salvo.getId(), salvo.getNome(), salvo.getEmail());
}
public LoginResponse login(LoginRequest request) {
    Usuario usuario = usuarioRepository
            .findByEmailIgnoreCase(request.email().trim())
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Email ou senha inválidos"));

    if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Email ou senha inválidos");
    }

    return new LoginResponse(
            tokenService.gerarToken(usuario),
            "Bearer",
            tokenService.getExpirationSeconds());
}
}