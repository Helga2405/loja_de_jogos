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


import com.generation.gammers.model.CategoriaMod;
import com.generation.gammers.repository.CategoriaRp;



@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaCont {

	@Autowired
	public CategoriaRp reposit;
	
	@GetMapping
	public ResponseEntity<List<CategoriaMod>> getAll(){
		return ResponseEntity.ok(reposit.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaMod> getById(@PathVariable Long id){
		return reposit.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaMod>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(reposit.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaMod> post (@Valid @RequestBody CategoriaMod categor){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(reposit.save(categor));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaMod> put (@Valid @RequestBody CategoriaMod categor){
		return ResponseEntity.ok(reposit.save(categor));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		reposit.deleteById(id);
	}
	
}
