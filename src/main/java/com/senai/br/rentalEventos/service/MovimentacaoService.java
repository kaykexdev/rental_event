package com.senai.br.rentalEventos.service;

import com.senai.br.rentalEventos.dto.MovimentacaoRequest;
import com.senai.br.rentalEventos.models.Movimentacao;
import com.senai.br.rentalEventos.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository) {

        this.movimentacaoRepository = movimentacaoRepository;
    }

    public MovimentacaoRequest cadastrarMovimentacao(
            MovimentacaoRequest request) {

        return movimentacaoRepository.save(request);
    }

    public List<MovimentacaoRequest> listarMovimentacoes() {

        return movimentacaoRepository.findAll();
    }

    public MovimentacaoRequest buscarPorId(Long id) {

        return movimentacaoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movimentação não encontrada"));
    }

    public MovimentacaoRequest atualizarMovimentacao(
            Long id,
            MovimentacaoRequest request) {

        MovimentacaoRequest movimentacaoRequestExistente = buscarPorId(id);

        movimentacaoRequestExistente.setTipoMovimentacao(
                request.getTipoMovimentacao()
        );

        movimentacaoRequestExistente.setDataMovimentacao(
                request.getDataMovimentacao()
        );

        movimentacaoRequestExistente.setQuantidadeMovimentacao(
                request.getQuantidadeMovimentacao()
        );

        movimentacaoRequestExistente.setUsuarioId(
                request.getUsuarioId()
        );

        movimentacaoRequestExistente.setEquipamentoId(
                request.getEquipamentoId()
        );

        return movimentacaoRepository.save(movimentacaoRequestExistente);
    }

    public void deletarMovimentacao(Long id) {

        MovimentacaoRequest request = buscarPorId(id);

        movimentacaoRepository.delete(request);
    }
}