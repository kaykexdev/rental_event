package com.senai.br.rentalEventos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movimentacao")
public class Movimentacao extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo_movimentacao")
    private String tipoMovimentacao;
    @Column(name = "data_movimentacao")
    private String dataMovimentacao;
    @Column(name = "quantidade_movimentacao")
    private String quantidade_movimentacao;
    
    @OneToMany
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", insertable = false, updatable = false)
    private Equipamento equipamentoId;

    public Movimentacao() {
    }

    public Movimentacao(Long id, String tipoMovimentacao, String dataMovimentacao, String quantidade_movimentacao,
            Usuario usuarioId) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.quantidade_movimentacao = quantidade_movimentacao;
        this.usuarioId = usuarioId;
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

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getQuantidade_movimentacao() {
        return quantidade_movimentacao;
    }

    public void setQuantidade_movimentacao(String quantidade_movimentacao) {
        this.quantidade_movimentacao = quantidade_movimentacao;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }


    
}
