package com.senai.br.rentalEventos.dto;

@Data

public class LoginRequest {

    @NotBlack String email,
    @NotBlack @Size(min = 8) String senha,

}