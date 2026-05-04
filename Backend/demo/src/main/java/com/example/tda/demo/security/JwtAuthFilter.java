package com.example.tda.demo.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.servicios.UsuarioService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final UsuarioService usuarioService;
	
	public JwtAuthFilter(JwtService jwtService, UsuarioService usuarioService) 
	{
		this.jwtService = jwtService;
		this.usuarioService = usuarioService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)
									throws ServletException, IOException
	{
		String header = request.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")) 
		{
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = header.substring(7);
		System.out.println("ESTE ES EL TOKEN: " + token);
		
		try 
		{
			Long userId = jwtService.getUserIdFromAccessToken(token);
			Usuario usuario = usuarioService.getById(userId);
			Claims claims = jwtService.getAllClaims(token);
			String role = claims.get("role", String.class);
			
			UsernamePasswordAuthenticationToken auth =
					new UsernamePasswordAuthenticationToken(usuario.getNombre(), null, List.of(new SimpleGrantedAuthority("ROLE_" + role)));
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			System.out.println(SecurityContextHolder.getContext().getAuthentication());
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("ALGO SALIO MAL");
			SecurityContextHolder.clearContext();
		}
		
		filterChain.doFilter(request, response);
	}
}
