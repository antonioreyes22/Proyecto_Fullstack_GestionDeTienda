package com.example.tda.demo.servicios;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;	
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) 
	{
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public Usuario save(Usuario usuario) 
	{
		if(usuario.getRole() == null) 
			usuario.setRole("USER");
		
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public List<Usuario> findAll()
	{
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario getById(Long id) 
	{		
		return usuarioRepository.findById(id).get();
	}
	
	@Override
	public Usuario getByName(String name) 
	{
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario: usuarios) 
		{
			if(usuario.getNombre().equals(name))
				return usuario;
		}
		
		return null;
	}
	
	@Override
	public Usuario getByEmail(String email) 
	{
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario: usuarios)
			if(usuario.getEmail().equals(email))
				return usuario;
		
		return null;
	}
	
	
	@Override
	public void deleteById(Long id) 
	{
		usuarioRepository.deleteById(id);
	}
	
	@Override
	public void deleteByName(String name) 
	{
		List<Usuario> usuarios = usuarioRepository.findAll();
		boolean eliminado = false;
		
		for(Usuario usuario: usuarios)
			if(usuario.getNombre().equals(name)) 
			{
				usuarioRepository.delete(usuario);
				eliminado = true;
			}
		
		if(!eliminado)
			throw new RuntimeException("Usuario no encontrado");
	}
	
	@Override
	public Usuario UpdateUser(Long id, String newName, String newEmail) 
	{
		Usuario usuario = getById(id);
		
		if (newName != null && !newName.trim().isEmpty())
			usuario.setNombre(newName);
		
		if (newEmail != null && !newEmail.trim().isEmpty())
			usuario.setEmail(newEmail);
		
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario getUser() 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		System.out.println("USERNAME: " + username);
		
		return getByName(username);
	}
	

}
