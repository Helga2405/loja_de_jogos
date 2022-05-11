package com.generation.gammers.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_usuarios")
public class UsuarioG {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	
	@NotNull
	@Email(message = "O usuário deve ser um email valido ex:maria@email.com")

	private String usuario;
	
	@NotNull
	private String senha;
	
	private String foto;
	
	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")

	private List<ProdutosMod> produtos;

	

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	public List<ProdutosMod> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosMod> produtos) {
		this.produtos = produtos;
	}

	

}