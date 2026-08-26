package com.senai.br.rentalEventos.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo_movimentacao")
    private String tipoMovimentacao;
    @Column(name = "data_movimentacao")
    private LocalDateTime dataMovimentacao;
    @Column(name = "quantidadeMovimentacao")
    private int quantidadeMovimentacao;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamentoId;

    public Movimentacao() {
    }

    public Movimentacao(Long id, String tipoMovimentacao, LocalDateTime dataMovimentacao, int quantidadeMovimentacao,
            Usuario usuarioId, Equipamento equipamentoId) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidadeMovimentacao = quantidadeMovimentacao;
        this.usuarioId = usuarioId;
        this.equipamentoId = equipamentoId;
    }


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

    public int getQuantidadeMovimentacao() {
        return quantidadeMovimentacao;
    }

    public void setQuantidadeMovimentacao(int quantidadeMovimentacao) {
        this.quantidadeMovimentacao = quantidadeMovimentacao;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Equipamento getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Equipamento equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

}
