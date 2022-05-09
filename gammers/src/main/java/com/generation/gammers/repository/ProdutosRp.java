package com.generation.gammers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gammers.model.ProdutosMod;

@Repository
public interface ProdutosRp extends JpaRepository<ProdutosMod, Long> {
public List<ProdutosMod> findAllByNomeContainingIgnoreCase(String nome);
}
