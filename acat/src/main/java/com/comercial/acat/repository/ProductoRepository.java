package com.comercial.acat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Productor;


public interface ProductoRepository extends JpaRepository <Producto, Integer>{


	Optional<Producto>findByNombreproducto(String nombreproducto);
	boolean existsByNombreproducto(String nombreproducto);
	
	List<Producto> findByCategoriaproducto(String categoriaproducto);
	boolean existsByCategoriaproducto(String categoriaproducto);
	
	List<Producto> findByEstadoproducto(String estadoproducto);
	boolean existsByEstadoproducto(String estadoproducto);
	/*List<Producto> findByIdproductor(Productor idproductor);
	boolean existsByIdproductor(Productor idproductor);*/ //era para mostrar los productos de un productor pero nell
	
	

}
