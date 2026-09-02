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

import com.senai.br.rentalEventos.models.Equipamento;
import com.senai.br.rentalEventos.service.EquipamentoService;


@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    
    private final EquipamentoService equipamentoService;
    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }


    @PostMapping("/cadastro")
    public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }

    @GetMapping("/listar")
    public List<Equipamento> listarEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/listarId/{id}")
    public Equipamento buscarPorId(@PathVariable Long id) {
        return equipamentoService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Equipamento atualizar(
            @PathVariable Long id,
            @RequestBody Equipamento equipamento) {

        return equipamentoService.atualizarEquipamento(id, equipamento);
    }

    @DeleteMapping("/deletar/{id}")
    public Equipamento deletar(@PathVariable Long id) {

        equipamentoService.deletarEquipamento(id);

        return null;
    }
}

