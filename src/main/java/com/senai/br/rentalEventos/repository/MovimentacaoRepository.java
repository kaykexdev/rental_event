package com.senai.br.rentalEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.br.rentalEventos.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
}
