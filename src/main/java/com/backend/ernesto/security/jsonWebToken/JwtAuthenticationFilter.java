package com.backend.ernesto.security.jsonWebToken;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.ernesto.security.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*Intercepta todas las invocaciones al servidor.
 *	Comprobamos existencia del token.
 *	  - Si existe, lo desencripta y valida.
 *	  - Si está todo OK, se añaden las configuraciones necesarias al contexto de Spring
 *		para autorizar la petición */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired private JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		if ((requestTokenHeader != null) && (requestTokenHeader.startsWith("Bearer "))) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = this.jwtUtils.extractUsername(jwtToken);
				
			} catch (ExpiredJwtException expiredJwt) {
				System.out.println("El token expiró.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Token inválido, no empieza con Bearer string");
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
			
			if (this.jwtUtils.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			} else {
				System.out.println("El token no es valido.");
			}
			
			filterChain.doFilter(request, response);
		}
		
	}
	
}
