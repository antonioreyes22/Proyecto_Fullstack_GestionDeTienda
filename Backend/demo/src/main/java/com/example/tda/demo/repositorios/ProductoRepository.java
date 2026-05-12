package com.example.tda.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tda.demo.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
}
