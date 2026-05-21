package com.example.tda.demo.servicios;

import com.example.tda.demo.modelos.Carrito;
import com.example.tda.demo.modelos.DetalleCarrito;
import com.example.tda.demo.modelos.Producto;
import com.example.tda.demo.modelos.Usuario;

public interface CarritoService {

	public Carrito crearCarrito(Usuario usuario);
	public DetalleCarrito guardarProducto(Long carritoId, Long productoId, int cantidad);
	public DetalleCarrito deleteProducto(Long carritoId, Long productoId, int cantidad);
}
