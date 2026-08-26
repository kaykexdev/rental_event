package com.senai.br.rentalEventos.service;

import com.senai.br.rentalEventos.dto.MovimentacaoRequest;
import com.senai.br.rentalEventos.models.Equipamento;
import com.senai.br.rentalEventos.models.Movimentacao;
import com.senai.br.rentalEventos.models.Usuario;
import com.senai.br.rentalEventos.repository.EquipamentoRepository;
import com.senai.br.rentalEventos.repository.MovimentacaoRepository;
import com.senai.br.rentalEventos.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EquipamentoRepository equipamentoRepository;

    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository,
            UsuarioRepository usuarioRepository,
            EquipamentoRepository equipamentoRepository) {

        this.movimentacaoRepository = movimentacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Movimentacao cadastrarMovimentacao(
            MovimentacaoRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        Equipamento equipamento = equipamentoRepository.findById(
                request.getEquipamentoId()
        ).orElseThrow(() ->
                new RuntimeException("Equipamento não encontrado"));

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setTipoMovimentacao(
                request.getTipoMovimentacao()
        );

        movimentacao.setDataMovimentacao(
                request.getDataMovimentacao()
        );

        movimentacao.setQuantidadeMovimentacao(
                request.getQuantidadeMovimentacao()
        );

        movimentacao.setUsuarioId(usuario);
        movimentacao.setEquipamentoId(equipamento);

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
            MovimentacaoRequest request) {

        Movimentacao movimentacao = buscarPorId(id);

        Usuario usuario = usuarioRepository.findById(
                request.getUsuarioId()
        ).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));

        Equipamento equipamento = equipamentoRepository.findById(
                request.getEquipamentoId()
        ).orElseThrow(() ->
                new RuntimeException("Equipamento não encontrado"));

        movimentacao.setTipoMovimentacao(
                request.getTipoMovimentacao()
        );

        movimentacao.setDataMovimentacao(
                request.getDataMovimentacao()
        );

        movimentacao.setQuantidadeMovimentacao(
                request.getQuantidadeMovimentacao()
        );

        movimentacao.setUsuarioId(usuario);
        movimentacao.setEquipamentoId(equipamento);

        return movimentacaoRepository.save(movimentacao);
    }

    public void deletarMovimentacao(Long id) {

        Movimentacao movimentacao = buscarPorId(id);

        movimentacaoRepository.delete(movimentacao);
    }
}