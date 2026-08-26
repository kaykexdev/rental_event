package com.senai.br.rentalEventos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.br.rentalEventos.dto.MovimentacaoRequest;
import com.senai.br.rentalEventos.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping("/cadastro")
    public MovimentacaoRequest cadastrarMovimentacao(
            @RequestBody MovimentacaoRequest movimentacao) {

        return movimentacaoService.cadastrarMovimentacao(movimentacao);
    }

    @GetMapping("/listar")
    public List<MovimentacaoRequest> listarMovimentacoes() {

        return movimentacaoService.listarMovimentacoes();
    }

    @GetMapping("/listarId/{id}")
    public MovimentacaoRequest buscarPorId(@PathVariable Long id) {

        return movimentacaoService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public MovimentacaoRequest atualizar(
            @PathVariable Long id,
            @RequestBody MovimentacaoRequest movimentacao) {

        return movimentacaoService.atualizarMovimentacao(id, movimentacao);
    }

    @DeleteMapping("/deletar/{id}")
    public MovimentacaoRequest deletar(@PathVariable Long id) {

        movimentacaoService.deletarMovimentacao(id);

        return null;
    }

}
