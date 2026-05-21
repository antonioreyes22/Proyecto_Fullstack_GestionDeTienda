package com.example.tda.demo.modelos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_carrito")
public class DetalleCarrito {

	@EmbeddedId
	private DetalleCarritoId detalleCarritoId;
	
	private int cantidad;
		
	public DetalleCarrito() {}

	public DetalleCarrito(DetalleCarritoId detalleCarritoId, int cantidad) {
		super();
		this.detalleCarritoId = detalleCarritoId;
		this.cantidad = cantidad;
	}

	public DetalleCarritoId getDetalleCarritoId() {
		return detalleCarritoId;
	}

	public void setDetalleCarritoId(DetalleCarritoId detalleCarritoId) {
		this.detalleCarritoId = detalleCarritoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
