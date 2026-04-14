package com.example.tda.demo.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.servicios.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	public AuthController(UsuarioService usuarioService, PasswordEncoder passwordEncoder,
			JwtService jwtService) 
	{
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDTO) 
	{
		Usuario usuario = usuarioService.getByName(loginDTO.getUsername());
		
		if(usuario == null || !passwordEncoder.matches(loginDTO.getPassword(), usuario.getPassword())) 
		{
			throw new BadCredentialsException("Credenciales incorrectas");
		}
		
		return jwtService.generateAccessToken(usuario);
	}
}
