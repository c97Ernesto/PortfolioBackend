package com.backend.ernesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.backend.ernesto.security.model.*;
import java.util.*;
import com.backend.ernesto.security.service.UsuarioService;



@SpringBootApplication // utilización del framework de springboot
public class ErnestoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(ErnestoApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
//			Usuario usuario = new Usuario();
//			usuario.setUsername("admin");
//			usuario.setPassword(bCryptPasswordEncoder().encode("admin"));
//			usuario.setEmail("admin@gmail.com");
//
//			Rol rol = new Rol();
//			rol.setRolId(1L);
//			rol.setRolNombre("ADMIN");
//
//			Set<UsuarioRol> usuariosRoles = new HashSet<>();
//			UsuarioRol usuarioRol = new UsuarioRol();
//			usuarioRol.setRol(rol);
//			usuarioRol.setUsuario(usuario);
//			usuariosRoles.add(usuarioRol);
//
//			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuariosRoles);
//			System.out.println(usuarioGuardado.getUsername());

	}
}
