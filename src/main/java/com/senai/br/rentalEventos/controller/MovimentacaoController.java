package com.senai.br.rentalEventos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.senai.br.rentalEventos.models.Movimentacao;
import com.senai.br.rentalEventos.service.MovimentacaoService;

public class MovimentacaoController {
    
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping
    public Movimentacao cadastrarMovimentacao(
            @RequestBody Movimentacao movimentacao) {

        return movimentacaoService.cadastrarMovimentacao(movimentacao);
    }

    @GetMapping("/listar")
    public List<Movimentacao> listarMovimentacoes() {

        return movimentacaoService.listarMovimentacoes();
    }

    @GetMapping("/listarId/{id}")
    public Movimentacao buscarPorId(@PathVariable Long id) {

        return movimentacaoService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Movimentacao atualizar(
            @PathVariable Long id,
            @RequestBody Movimentacao movimentacao) {

        return movimentacaoService.atualizarMovimentacao(id, movimentacao);
    }

    @DeleteMapping("/deletar/{id}")
    public Movimentacao deletar(@PathVariable Long id) {

        movimentacaoService.deletarMovimentacao(id);

        return null;
    }

}
