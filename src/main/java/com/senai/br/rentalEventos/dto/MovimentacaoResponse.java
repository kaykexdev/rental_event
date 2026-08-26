package com.senai.br.rentalEventos.dto;

import java.time.LocalDateTime;

public class MovimentacaoResponse {

    private Long id;
    private String tipoMovimentacao;
    private LocalDateTime dataMovimentacao;
    private Integer quantidadeMovimentacao;

    private Long usuarioId;
    private Long equipamentoId;
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
    public Integer getQuantidadeMovimentacao() {
        return quantidadeMovimentacao;
    }
    public void setQuantidadeMovimentacao(Integer quantidadeMovimentacao) {
        this.quantidadeMovimentacao = quantidadeMovimentacao;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Long getEquipamentoId() {
        return equipamentoId;
    }
    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    

}