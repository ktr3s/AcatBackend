package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Carrito;
import com.comercial.acat.exceptions.RecordNotFoundException;
import com.comercial.acat.repository.CarritoRepository;

@Service
@Transactional
public class CarritoService {

	@Autowired
	CarritoRepository carritoRepository;
	
	public List<Carrito> list(){
		return carritoRepository.findAll();  //devuelve todos los productos de la tabla
	}
	
	
	public Optional<Carrito> getOne(int idproducto){
		return carritoRepository.findById(idproducto); //devuelve un producto filtrado por id
	}
	
	/*public Optional<Producto> getByIdproductor(int idproductor){
		return productoRepository.findById(idproductor); //devuelve los productos de un productor****************************
	}*/
	
	/*public List<Producto> getByIdproductor(Productor idproductor){
		return productoRepository.findByIdproductor(idproductor);  //
	}*///era para mostrar los productos de un productor pero nell
	
	public Optional<Carrito> getOne(String nombreproducto){
		return carritoRepository.findByNombreproducto(nombreproducto); //devuelve los productos por nombre
	}
		
	/*public Optional<Producto> getByCategoria(String categoriaproducto){
		return productoRepository.findByCategoriaproducto(categoriaproducto); //devuelve los productos por categoria
	}*/
	
	public List<Carrito> getByCategoria(String categoriaproducto){
		return carritoRepository.findByCategoriaproducto(categoriaproducto);  //devuelve todos los productos de la tabla por categoria
	}
	
	
	
	public List<Carrito> getByEstado(String estadoproducto){
		return carritoRepository.findByEstadoproducto(estadoproducto);  //devuelve todos los productos de la tabla por estado
	}
	
	public void save (Carrito carrito) {//crea una entidad producto
		carritoRepository.save(carrito);
	}
	
	public void delete (int idproducto) {
		carritoRepository.deleteById(idproducto);  //elimina un producto por su ID
	}
	
	public boolean existsById(int idproducto) {
		return carritoRepository.existsById(idproducto); //devuelve true si existe un producto buscado por id
	}
	
	public boolean existsByNombre(String nombreproducto) {
		return carritoRepository.existsByNombreproducto(nombreproducto); //devuelve true si existe un producto buscado por nombre
	}
	
	
}
