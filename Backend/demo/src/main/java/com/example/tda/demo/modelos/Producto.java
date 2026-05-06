package com.example.tda.demo.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private TipoProducto tipo;
	private GeneroProducto genero;
	private float precio;
	
	
	public TipoProducto getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	
	public GeneroProducto getGenero() {
		return genero;
	}
	
	public void setGenero(GeneroProducto genero) {
		this.genero = genero;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Long getId() {
		return id;
	}

}
