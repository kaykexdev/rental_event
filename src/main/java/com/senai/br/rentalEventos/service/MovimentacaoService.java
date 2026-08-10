package com.senai.br.rentalEventos.service;

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

    public Movimentacao cadastrarMovimentacao(
            Movimentacao movimentacao) {

        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listarMovimentacoes() {

        return movimentacaoRepository.findAll();
    }

    public Movimentacao buscarPorId(Long id) {

        return movimentacaoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movimentação não encontrada"));
    }

    public Movimentacao atualizarMovimentacao(
            Long id,
            Movimentacao movimentacao) {

        Movimentacao movimentacaoExistente = buscarPorId(id);

        movimentacaoExistente.setTipoMovimentacao(
                movimentacao.getTipoMovimentacao()
        );

        movimentacaoExistente.setDataMovimentacao(
                movimentacao.getDataMovimentacao()
        );

        movimentacaoExistente.setQuantidadeMovimentacao(
                movimentacao.getQuantidadeMovimentacao()
        );

        movimentacaoExistente.setUsuarioId(
                movimentacao.getUsuarioId()
        );

        movimentacaoExistente.setEquipamentoId(
                movimentacao.getEquipamentoId()
        );

        return movimentacaoRepository.save(movimentacaoExistente);
    }

    public void deletarMovimentacao(Long id) {

        Movimentacao movimentacao = buscarPorId(id);

        movimentacaoRepository.delete(movimentacao);
    }
}