package com.senai.br.rentalEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.br.rentalEventos.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
