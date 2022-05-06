package com.generation.gammers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.generation.gammers.model.ProdutosMod;
import com.generation.gammers.repository.ProdutosRp;

@RestController
@RequestMapping("produtosmod")
@CrossOrigin
public class ProdutosCont {

	@Autowired
	public ProdutosRp reposit;
	
	@GetMapping
	public ResponseEntity<List<ProdutosMod>> getAll () {
		return ResponseEntity.ok(reposit.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutosMod> GetById(@PathVariable Long id) {
		return reposit.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	ResponseEntity<List<ProdutosMod>> GetByNome(@PathVariable String nome ) {
		return ResponseEntity.ok(reposit.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutosMod> post (@Valid @RequestBody ProdutosMod produt){
		return ResponseEntity.status(HttpStatus.CREATED).body(reposit.save(produt));
	}
	
	@PutMapping
	public ResponseEntity<ProdutosMod> put(@Valid @RequestBody ProdutosMod produt){
		return ResponseEntity.status(HttpStatus.OK).body(reposit.save(produt));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		reposit.deleteById(id);
	}
}
