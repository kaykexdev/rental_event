package com.senai.br.rentalEventos.service;
import com.senai.br.rentalEventos.models.Equipamento;
import com.senai.br.rentalEventos.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento cadastrarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }

    public Equipamento atualizarEquipamento(
            Long id,
            Equipamento equipamento) {

        Equipamento equipamentoExistente = buscarPorId(id);

        equipamentoExistente.setMarca(equipamento.getMarca());
        equipamentoExistente.setModelo(equipamento.getModelo());
        equipamentoExistente.setCategoria(equipamento.getCategoria());
        equipamentoExistente.setPotencia(equipamento.getPotencia());
        equipamentoExistente.setMaterial(equipamento.getMaterial());
        equipamentoExistente.setPeso(equipamento.getPeso());
        equipamentoExistente.setDimensoes(equipamento.getDimensoes());
        equipamentoExistente.setCor(equipamento.getCor());
        equipamentoExistente.setQuantidade(equipamento.getQuantidade());

        return equipamentoRepository.save(equipamentoExistente);
    }

    public void deletarEquipamento(Long id) {

        Equipamento equipamento = buscarPorId(id);

        equipamentoRepository.delete(equipamento);
    }
}