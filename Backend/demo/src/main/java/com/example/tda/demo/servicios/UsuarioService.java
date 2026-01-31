package com.example.tda.demo.servicios;

import java.util.List;

import com.example.tda.demo.modelos.Usuario;

public interface UsuarioService {

	public Usuario save(Usuario usuario);
	public List<Usuario> findAll();
	public Usuario getById(Long id);
	public Usuario getByName(String name);
	public Usuario getByEmail(String email);
	public void deleteById(Long id);
	public void deleteByName(String name);
}
