package com.generation.gammers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gammers.model.CategoriaMod;

public interface CategoriaRp extends JpaRepository<CategoriaMod, Long> {
public List<CategoriaMod> findAllByNomeContainingIgnoreCase(String nome);
}
