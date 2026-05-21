package com.example.tda.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tda.demo.modelos.DetalleCarrito;
import com.example.tda.demo.modelos.DetalleCarritoId;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, DetalleCarritoId>{

}
