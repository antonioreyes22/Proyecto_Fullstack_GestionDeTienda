package com.example.tda.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tda.demo.modelos.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>{

}
