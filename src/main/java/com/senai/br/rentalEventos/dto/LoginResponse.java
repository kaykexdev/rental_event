package com.senai.br.rentalEventos.dto;

public record LoginResponse(

    String token,
    String tipo,
    Long expiraEmSegundos

) {}

