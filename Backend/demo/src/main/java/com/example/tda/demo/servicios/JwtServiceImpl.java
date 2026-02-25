package com.example.tda.demo.servicios;

import java.util.function.Function;

import com.example.tda.demo.modelos.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtServiceImpl implements JwtService{

	private String secret = "springboot";
	
}
