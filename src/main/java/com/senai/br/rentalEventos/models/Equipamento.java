package com.senai.br.rentalEventos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipamento")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "potencia")
    private String potencia;
    @Column(name = "material")
    private String material;
    @Column(name = "peso")
    private String peso;
    @Column(name = "dimensoes")
    private String dimensoes;
    @Column(name = "cor")
    private String cor;
    @Column(name = "quantidade")
    private int quantidade;
}
