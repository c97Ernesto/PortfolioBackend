package com.backend.ernesto.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ernesto.security.model.Usuario;
import com.backend.ernesto.security.model.UsuarioRol;
import com.backend.ernesto.security.model.Rol;
import com.backend.ernesto.security.service.UsuarioService;

import java.util.Set;
import java.util.HashSet;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired private UsuarioService usuarioService;
	
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));	//encriptamos la contraseña
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();

		Rol rol = new Rol();
		rol.setRolId(2L);
		rol.setRolNombre("NORMAL");

		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);

		usuarioRoles.add(usuarioRol);
		return usuarioService.guardarUsuario(usuario, usuarioRoles);
	}

	@GetMapping("/{username}")
	public Usuario obtenerUsuario(@PathVariable("username") String username) {
		return usuarioService.obtenerUsuario(username);
	}

	@DeleteMapping("/{usuarioId}")
	public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.eliminarUsuario(usuarioId);
	}

}
