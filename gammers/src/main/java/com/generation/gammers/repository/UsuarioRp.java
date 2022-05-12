package com.generation.gammers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gammers.model.UsuarioG;


@Repository
public interface UsuarioRp extends JpaRepository<UsuarioG, Long> {
    public Optional<UsuarioG> findByUsuario(String usuario);
}



