package com.example.tda.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoProducto tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genero")
	private GeneroProducto genero;
	
	private float precio;
	private String imagen;
	
	public Producto() {}
		
	public Producto(TipoProducto tipo, String nombre, GeneroProducto genero, float precio, String imagen) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.genero = genero;
		this.precio = precio;
		this.imagen = imagen;
	}
	
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
	
	public void setImagen(String imagen) 
	{
		this.imagen = imagen;
	}
	
	public String getImagen() 
	{
		return imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
