package com.backend.ernesto.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.backend.ernesto.security.jsonWebToken.JwtUtils;
import com.backend.ernesto.security.model.JwtRequest;
import com.backend.ernesto.security.model.JwtResponse;
import com.backend.ernesto.security.model.Usuario;
import com.backend.ernesto.security.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired AuthenticationManager authenticationManager;
	
	@Autowired UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			this.autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Usuario no encontrado");
		}
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.createToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void autenticar(String username, String password) throws Exception{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException disabledException) {
			throw new Exception("USUARIO DESHABILITADO" + disabledException.getMessage());
			
		} catch (BadCredentialsException badCredentialsException ) {
			throw new Exception("CREDENCIALES INVÁLIDAS" + badCredentialsException.getMessage());
		}
	}
	
	@GetMapping("/actual-usuario")
	public Usuario obtenerUsuarioActual(Principal principal) {
		return (Usuario) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
}
