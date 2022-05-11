package com.generation.gammers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRp extends JpaRepository<UsuarioRp, Long> {
	public Optional<UsuarioRp> findByUsuario(String usuario);
}


