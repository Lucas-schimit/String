package com.generation.BlogPessoal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.BlogPessoal.model.Usuario;
import com.generation.BlogPessoal.model.UsuarioLogin;
import com.generation.BlogPessoal.service.UsuarioService;
import com.generation.BlogPessoal.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(oje -> ResponseEntity.ok(oje))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
		Optional<Usuario> user = usuarioService.atualizarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	

}
