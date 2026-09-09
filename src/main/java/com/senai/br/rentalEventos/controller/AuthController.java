package com.senai.br.rentalEventos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.rentalEventos.dto.CadastroRequest;
import com.senai.br.rentalEventos.dto.LoginRequest;
import com.senai.br.rentalEventos.dto.LoginResponse;
import com.senai.br.rentalEventos.dto.UsuarioResponse;
import com.senai.br.rentalEventos.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(
            @Valid @RequestBody CadastroRequest request) {
        return authService.cadastrar(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}