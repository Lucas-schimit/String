package com.generation.BlogPessoal.repository;

import java.lang.StackWalker.Option;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.BlogPessoal.model.Usuario;
import com.sun.el.stream.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usario> findByUsuario(String Usuario);

}
