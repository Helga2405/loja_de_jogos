package com.generation.gammers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_produtos")
public class ProdutosMod {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String nome;
	
	
	public String jogos;
	
	
	@ManyToOne
	@JsonIgnoreProperties("ProdutosMod")
	public CategoriaMod categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("ProdutosMod")
	public UsuarioG usuario;
	
	

	

	
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

	public String getJogos() {
		return jogos;
	}

	public void setJogos(String jogos) {
		this.jogos = jogos;
	}
	
	public CategoriaMod getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaMod categoria) {
		this.categoria = categoria;
	}
	public UsuarioG getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioG usuario) {
		this.usuario = usuario;
	}

	
	
	
}
