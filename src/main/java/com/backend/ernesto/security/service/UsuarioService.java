package com.backend.ernesto.security.service;

import java.util.Set;

import com.backend.ernesto.security.model.Usuario;
import com.backend.ernesto.security.model.UsuarioRol;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
