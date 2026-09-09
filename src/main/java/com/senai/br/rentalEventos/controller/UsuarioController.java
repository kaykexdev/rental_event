package com.senai.br.rentalEventos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.rentalEventos.models.Usuario;
import com.senai.br.rentalEventos.service.UsuarioService;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/listarId/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }
    
    @PutMapping("atualizar/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public Usuario deletar(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return null;
    }
}
