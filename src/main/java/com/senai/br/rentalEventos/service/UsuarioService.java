package com.senai.br.rentalEventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.br.rentalEventos.models.Usuario;
import com.senai.br.rentalEventos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {

        Usuario usuarioExistente = buscarPorId(id);

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setDataNascimento(usuario.getDataNascimento());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {

        Usuario usuario = buscarPorId(id);

        usuarioRepository.delete(usuario);
    }

}