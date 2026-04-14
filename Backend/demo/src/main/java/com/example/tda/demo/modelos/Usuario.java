package com.example.tda.demo.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String password;
	private String role;
	
	// Constructor
	
	public Usuario() {}
	
	public Usuario(String nombre, String email, String password, String role) 
	{	
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getId() 
	{
		return this.id;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setRole(String role) 
	{
		this.role = role;
	}
	
	public String getRole() 
	{
		return role;
	}
}


