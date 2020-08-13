package com.comercial.acat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.acat.entity.Carrito;

public interface CarritoRepository extends JpaRepository <Carrito, Integer>{

	Optional<Carrito>findByNombreproducto(String nombreproducto);
	boolean existsByNombreproducto(String nombreproducto);
	
	List<Carrito> findByCategoriaproducto(String categoriaproducto);
	boolean existsByCategoriaproducto(String categoriaproducto);
	
	List<Carrito> findByEstadoproducto(String estadoproducto);
	boolean existsByEstadoproducto(String estadoproducto);
	
	/*List<Producto> findByIdproductor(Productor idproductor);
	boolean existsByIdproductor(Productor idproductor);*/ // mostrar los productos de un productor 
	
	
	
}
