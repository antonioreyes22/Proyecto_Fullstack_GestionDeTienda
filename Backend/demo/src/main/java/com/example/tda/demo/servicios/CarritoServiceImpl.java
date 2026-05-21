package com.example.tda.demo.servicios;

import org.springframework.stereotype.Service;

import com.example.tda.demo.modelos.Carrito;
import com.example.tda.demo.modelos.DetalleCarrito;
import com.example.tda.demo.modelos.DetalleCarritoId;
import com.example.tda.demo.modelos.Producto;
import com.example.tda.demo.modelos.Usuario;
import com.example.tda.demo.repositorios.CarritoRepository;
import com.example.tda.demo.repositorios.DetalleCarritoRepository;

@Service
public class CarritoServiceImpl implements CarritoService{

	private final CarritoRepository carritoRepository;
	private final DetalleCarritoRepository detalleRepository;
	
	public CarritoServiceImpl(CarritoRepository carritoRepository, DetalleCarritoRepository detalleRepository) 
	{
		this.carritoRepository = carritoRepository;
		this.detalleRepository = detalleRepository;
	}
	
	@Override
	public Carrito crearCarrito(Usuario usuario) 
	{
		return carritoRepository.save(new Carrito(usuario));
	}
	
	@Override
	public DetalleCarrito guardarProducto(Long carritoId, Long productoId, int cantidad) 
	{
		DetalleCarrito detalle = new DetalleCarrito(new DetalleCarritoId(carritoId, productoId), cantidad);
		
		return detalleRepository.save(detalle);
	}	
	
	@Override
	public DetalleCarrito deleteProducto(Long carritoId, Long productoId, int cantidad) 
	{
		if(cantidad > 0)
			return guardarProducto(carritoId, productoId, cantidad);
		else 
		{
			DetalleCarritoId detalle = new DetalleCarritoId(carritoId, productoId);
			detalleRepository.deleteById(detalle);
			return null;
		}
	}
}
