package com.example.tda.demo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tda.demo.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query(
	value = "SELECT * FROM productos WHERE tipo='CAMISETA'",
	nativeQuery = true
	)
	List<Producto> findAllCamisetas();
	
	@Query(
	value = "SELECT * FROM productos WHERE tipo='CHAQUETA'",
	nativeQuery = true
	)
	List<Producto> findAllChaquetas();
}
