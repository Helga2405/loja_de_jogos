package com.generation.gammers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gammers.model.ProdutosMod;

public interface ProdutosRp extends JpaRepository<ProdutosMod, Long> {
public List<ProdutosMod> findAllByNomeContainingIgnoreCase(String nome);
}
