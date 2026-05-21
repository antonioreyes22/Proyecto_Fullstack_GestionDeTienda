package com.example.tda.demo.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tda.demo.modelos.Carrito;
import com.example.tda.demo.modelos.DetalleCarrito;
import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.servicios.CarritoService;
import com.example.tda.demo.servicios.UsuarioService;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {

	private final CarritoService carritoService;
	private final UsuarioService usuarioService;

	public CarritoController(CarritoService carritoService, UsuarioService usuarioService) 
	{
		this.carritoService = carritoService;
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/{id}/crear")
	public Carrito crearCarrito(@PathVariable Long id) 
	{
		Usuario usuario = usuarioService.getById(id);
		return carritoService.crearCarrito(usuario);
	}
	
	@PostMapping("/{id}/guardar")
	public DetalleCarrito guardarProducto(@RequestBody DetalleCarrito detalle) 
	{
		return carritoService.guardarProducto(detalle.getDetalleCarritoId().getId_carrito(), 
				detalle.getDetalleCarritoId().getId_producto(), detalle.getCantidad());
	}
	
	@PostMapping("/{id}/delete")
	public DetalleCarrito deleteProducto(@RequestBody DetalleCarrito detalle) 
	{
		return carritoService.guardarProducto(detalle.getDetalleCarritoId().getId_carrito(), 
				detalle.getDetalleCarritoId().getId_producto(), detalle.getCantidad());
	}
	
}
