package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Productor;
import com.comercial.acat.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> list(){
		return productoRepository.findAll();  //debuelve todos los productos de la tabla
	}
	
	public Optional<Producto> getOne(int idproducto){
		return productoRepository.findById(idproducto); //devuelve un producto filtrado por id
	}
	
	public Optional<Producto> getOne(String nombreproducto){
		return productoRepository.findByNombreproducto(nombreproducto); //devuelve los productos por nombre
	}
		
	public Optional<Producto> getByCategoria(String categoriaproducto){
		return productoRepository.findByCategoriaproducto(categoriaproducto); //devuelve los productos por categoria
	}
	
	public void save (Producto producto) {
		productoRepository.save(producto);
	}
	
	public void delete (int idproducto) {
		productoRepository.findById(idproducto);  //elimina un producto por su Id
	}
	
	public boolean existsById(int idproducto) {
		return productoRepository.existsById(idproducto); //devuelve true si existe un producto buscado por id
	}
	
	public boolean existsByNombre(String nombreproducto) {
		return productoRepository.existsByNombreproducto(nombreproducto); //devuelve true si existe un producto buscado por nombre
	}
	
	

}
