package com.generation.gammers.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name= "tb_categoria")
public class CategoriaMod {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String nome;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL )
	@JsonIgnoreProperties("categoria")
	public List<ProdutosMod> produtosmod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutosMod> getProdutosmod() {
		return produtosmod;
	}

	public void setProdutosmod(List<ProdutosMod> produtosmod) {
		this.produtosmod = produtosmod;
	}
	
}
