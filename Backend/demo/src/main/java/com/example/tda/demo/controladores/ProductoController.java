package com.example.tda.demo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tda.demo.modelos.Producto;
import com.example.tda.demo.servicios.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) 
	{
		this.productoService = productoService;
	}
	
	@PostMapping("/guardar")
	public Producto guardarProducto(@RequestBody Producto producto) 
	{
		return productoService.save(producto);
	}
	
	@GetMapping
	public List<Producto> findAll()
	{
		return productoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Producto findById(@PathVariable Long id) 
	{
		return productoService.findById(id);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Producto getByName(@PathVariable String name) 
	{
		return productoService.getByName(name);
	}
	
	@PostMapping("/eliminar/{id}")
	public void deleteById(@PathVariable Long id) 
	{
		productoService.deleteById(id);
	}
}
