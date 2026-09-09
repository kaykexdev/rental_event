package com.senai.br.rentalEventos.dto;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroRequest(

    @NotBlank String nome,
    @NotBlank String email,
    @NotBlank String cpf,
    @NotBlank @Size(min = 8) String senha,
    LocalDateTime dataNascimento

) {}