package com.example.tda.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tda.demo.modelos.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

