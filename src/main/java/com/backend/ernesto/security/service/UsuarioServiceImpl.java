package com.backend.ernesto.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ernesto.security.model.Usuario;
import com.backend.ernesto.security.model.UsuarioRol;
import com.backend.ernesto.security.repository.RolRepository;
import com.backend.ernesto.security.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired private UsuarioRepository usuarioRepository;
	
	@Autowired private RolRepository rolRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
		
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
			
		} else {	//almaceno el usuario creado y sus roles
			for (UsuarioRol usuarioRol : usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepository.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}


}
