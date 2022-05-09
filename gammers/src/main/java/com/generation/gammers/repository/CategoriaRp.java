package com.generation.gammers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gammers.model.CategoriaMod;

@Repository
public interface CategoriaRp extends JpaRepository<CategoriaMod, Long> {
public List<CategoriaMod> findAllByNomeContainingIgnoreCase(String nome);
}
