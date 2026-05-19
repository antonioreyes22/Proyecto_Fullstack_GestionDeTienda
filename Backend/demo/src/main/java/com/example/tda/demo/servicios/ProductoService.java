package com.example.tda.demo.servicios;

import java.util.List;

import com.example.tda.demo.modelos.Producto;

public interface ProductoService {

	public Producto save(Producto producto);
	public List<Producto> findAll();
	public Producto findById(Long id);
	public Producto getByName(String name);
	public void deleteById(Long id);
	public List<Producto> findAllCamisetas();
	public List<Producto> findAllChaquetas();
}
