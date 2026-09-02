package com.senai.br.rentalEventos.dto;


public class CadastroRequest {

    @NotBlack String nome,
    @NotBlack String email,
    @NotBlack @Size(min = 8) String senha,
    LocalDateTime dataNascimento,



}