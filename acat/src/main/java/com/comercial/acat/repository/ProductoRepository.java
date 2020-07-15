package com.comercial.acat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.acat.entity.Producto;


public interface ProductoRepository extends JpaRepository <Producto, Integer>{


	Optional<Producto>findByNombreproducto(String nombreproducto);
	boolean existsByNombreproducto(String nombreproducto);
	
	Optional<Producto>findByCategoriaproducto(String categoriaproducto);
	boolean existsByCategoriaproducto(String categoriaproducto);
	

}
