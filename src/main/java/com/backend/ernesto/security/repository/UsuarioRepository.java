package com.backend.ernesto.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ernesto.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
}
