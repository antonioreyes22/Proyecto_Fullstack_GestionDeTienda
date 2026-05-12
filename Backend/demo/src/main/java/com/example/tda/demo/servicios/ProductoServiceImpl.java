package com.example.tda.demo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tda.demo.modelos.Producto;
import com.example.tda.demo.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) 
	{
		this.productoRepository = productoRepository;
	}
	
	@Override
	public Producto save(Producto producto)
	{
		return productoRepository.save(producto);
	}
	
	@Override
	public List<Producto> findAll()
	{
		return productoRepository.findAll();
	}
	
	@Override
	public Producto findById(Long id) 
	{
		return productoRepository.findById(id).get();
	}
	
	@Override
	public Producto getByName(String name) 
	{
		List<Producto> productos = findAll();
		
		for(Producto producto: productos)
			if(producto.getNombre().equals(name))
				return producto;
		
		return null;
	}
	
	@Override
	public void deleteById(Long id) 
	{
		productoRepository.deleteById(id);
	}
}
