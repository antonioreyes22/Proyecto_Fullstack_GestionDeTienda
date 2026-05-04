package com.example.tda.demo.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	
	public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) 
	{
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) 
	{	
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioService.save(usuario);
    }
	
	@GetMapping
	public List<Usuario> findAll()
	{
		return usuarioService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Usuario getById(@PathVariable Long id) 
	{
		return usuarioService.getById(id);
	}
	
	@GetMapping("/nombre/{name}")
	public Usuario getByName(@PathVariable String name)
	{
		return usuarioService.getByName(name);
	}
	
	@GetMapping("/email/{correo}")
	public Usuario getByEmail(@PathVariable String correo) 
	{
		return usuarioService.getByEmail(correo);
	}
	
	@PostMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Long id) 
	{
		usuarioService.deleteById(id);
	}
	
	@PostMapping("/eliminar/nombre/{name}")
	public void deleteByName(@PathVariable String name) 
	{
		usuarioService.deleteByName(name);
	}
	
	@PostMapping("/modificar/id/{id}")
	public Usuario UpdateUser(@PathVariable Long id, @RequestBody Map<String, String> datos) 
	{
		return usuarioService.UpdateUser(id, datos.get("newName"), datos.get("newEmail"));
	}
	
	@GetMapping("/me")
	public Usuario getUser() 
	{
		return usuarioService.getUser();
	}
}
