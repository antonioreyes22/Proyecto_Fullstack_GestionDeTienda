package com.example.tda.demo.modelos;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleCarritoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_carrito")
	private Long id_carrito;
	
	@Column(name = "id_producto")
	private Long id_producto;
	
	
	// Constructores
	
	public DetalleCarritoId() {}

	public DetalleCarritoId(Long id_carrito, Long id_producto) {
		super();
		this.id_carrito = id_carrito;
		this.id_producto = id_producto;
	}

	
	// Getters y Setters
	
	public Long getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(Long id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
}
