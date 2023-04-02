package com.backend.ernesto.security.jsonWebToken;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    private String SECRET_KEY = "examportal";
    
    /*extraemos y devolvemos el nombre de usuario (subject) codificado en el token JWT.*/
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /*extraemos y devolvemos la fecha de expiración del token JWT.*/
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

/*
Jwts.builder(): crea un objeto JwtBuilder para la construcción del token JWT.
setClaims(claims): establece las reclamaciones (claims) para incluir en el token, que son un conjunto de pares clave-valor que contienen información sobre el usuario autenticado.
setSubject(subject): establece el sujeto (subject) del token, que es el usuario autenticado para el que se está creando el token.
setIssuedAt(new Date(System.currentTimeMillis())): establece la fecha y hora de emisión del token, que se establece en el momento en que se crea el token.
setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)): establece la fecha y hora de expiración del token, que se establece en 10 horas después de la fecha y hora de emisión.
signWith(SignatureAlgorithm.HS256, SECRET_KEY): establece el algoritmo de firma utilizado para firmar el token y la clave secreta utilizada para la firma.
compact(): construye y devuelve la cadena de caracteres del token JWT firmado.
*/
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
