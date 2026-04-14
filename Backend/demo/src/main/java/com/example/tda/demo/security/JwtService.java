package com.example.tda.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.example.tda.demo.modelos.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secretKey}")
	private String jwtSecretKey;
	
	private SecretKey getSecretKey() 
	{
		return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
	}
	
	public String generateAccessToken(Usuario usuario) 
	{
		return Jwts.builder()
				.subject(usuario.getId().toString())
				.claim("type", "access")
				.claim("name", usuario.getNombre())
				.claim("role", usuario.getRole())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000*60*15))
				.signWith(getSecretKey())
				.compact();			
	}
	
	public Long getUserIdFromAccessToken(String token) 
	{
		Claims claims = Jwts.parser()
				.verifyWith(getSecretKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
		
		String type = claims.get("type", String.class);
		
		if(type == null || !type.equals("access")) 
		{
			throw new BadCredentialsException("Not an access token");
		}
		
		return Long.valueOf(claims.getSubject());
	}
	
	public Claims getAllClaims(String token) {
	    return Jwts.parser()
	            .verifyWith(getSecretKey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();
	}
}
