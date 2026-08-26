package com.senai.br.rentalEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.br.rentalEventos.dto.MovimentacaoRequest;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoRequest, Long> {
    
}
