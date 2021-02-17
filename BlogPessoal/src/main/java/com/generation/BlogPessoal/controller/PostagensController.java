package com.generation.BlogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.BlogPessoal.model.Postagens;
import com.generation.BlogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/ponstagens")
@CrossOrigin("*")
public class PostagensController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	
	public ResponseEntity<List<Postagens>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Postagens> GetById(@PathVariable long id){
    	return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/titulo/{titulo}")
    
    public ResponseEntity <List<Postagens>> GetByTitulo(@PathVariable String titulo){
    	
    	return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }
    
    
}
