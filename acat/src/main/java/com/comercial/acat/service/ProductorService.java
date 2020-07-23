package com.comercial.acat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.comercial.acat.entity.Productor;
import com.comercial.acat.repository.ProductorRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductorService {

	@Autowired
	ProductorRepository productorRepository;
	
	public List<Productor> list(){
		return productorRepository.findAll();  //debuelve todos los productores de la tablas
	}
	
	public Optional<Productor> getOne(int idproductor){
		return productorRepository.findById(idproductor); //devuelve un productor filtrado por id
	}
	
	public Optional<Productor> getOne(String nombreproductor){
		return productorRepository.findByNombreproductor(nombreproductor); //devuelve los productores por nombre
	}
	
	public Optional<Productor> getByEmail(String emailproductor){
		return productorRepository.findByEmailproductor(emailproductor); //devuelve los productores por nombre
	}
	
	public void save (Productor productor) {
		productorRepository.save(productor); //guarda el productor
	}
	
	public void delete (int idproductor) {
		productorRepository.deleteById(idproductor);  //elimina un productor por su Id
	}
	
	public boolean existsById(int idproductor) {
		return productorRepository.existsById(idproductor); //devuelve true si existe un productor buscado por id
	}
	
	public boolean existsByNombre(String nombreproductor) {
		return productorRepository.existsByNombreproductor(nombreproductor); //devuelve true si existe un productor buscado por nombre
	}
	
	public boolean existsByEmail(String emailproductor) {
		return productorRepository.existsByEmailproductor(emailproductor); //devuelve true si ya existe ese correo
	}
	
}
