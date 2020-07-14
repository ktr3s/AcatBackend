package com.comercial.acat.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.acat.dto.Mensaje;
import com.comercial.acat.dto.ProductorDto;
import com.comercial.acat.entity.Productor;
import com.comercial.acat.service.ProductorService;

@RestController
@RequestMapping("/productor")
@CrossOrigin(origins = "http://localhost:4200")
	
public class ProductorController {
	
	@Autowired
	ProductorService productorService;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Productor>> list(){
		List<Productor> list = productorService.list();
		return new ResponseEntity<List<Productor>>(list, HttpStatus.OK);
	}
	
	@GetMapping ("/detail/{idproductor}")
	public ResponseEntity<Productor> getById (@PathVariable("idproductor") int idproductor){
		if (!productorService.existsById(idproductor))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Productor productor = productorService.getOne(idproductor).get();
		return new ResponseEntity<Productor>(productor, HttpStatus.OK);
	}
	
	@GetMapping ("/detailname/{nombreprodcutor}")
	public ResponseEntity<Productor> getByNombre (@PathVariable("nombreproductor") String nombreproductor){
		if (!productorService.existsByNombre(nombreproductor))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Productor productor = productorService.getOne(nombreproductor).get();
		return new ResponseEntity<Productor>(productor, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody ProductorDto productorDto){
		if(StringUtils.isBlank(productorDto.getNombreproductor()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getApellidoproductor()))
			return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getEmailproductor()))
			return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getClaveproductor()))
			return new ResponseEntity(new Mensaje("La clave es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getTelefonoproductor()))
			return new ResponseEntity(new Mensaje("El Telefono es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(productorService.existsByEmail(productorDto.getEmailproductor()))
			return new ResponseEntity(new Mensaje("Usted ya tiene una cuenta con ese correo"), HttpStatus.BAD_REQUEST);
		
		Productor productor = new Productor(productorDto.getNombreproductor(),productorDto.getApellidoproductor(),productorDto.getEmailproductor(),productorDto.getClaveproductor(),productorDto.getTelefonoproductor());
		productorService.save(productor);
		return new ResponseEntity(new Mensaje("Productor agregado con exito"),HttpStatus.OK);
	
	}
	
	
	@PutMapping("/update/{idproductor}")
	public ResponseEntity<?> update (@PathVariable ("idproductor") int idproductor, @RequestBody ProductorDto productorDto){
		
		if (!productorService.existsById(idproductor))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		if(productorService.existsByEmail(productorDto.getEmailproductor()) && productorService.getByEmail(productorDto.getEmailproductor()).get().getIdproductor() != idproductor )
			return new ResponseEntity(new Mensaje("Usted ya tiene una cuenta con ese correo"), HttpStatus.BAD_REQUEST);
		
		
		if(StringUtils.isBlank(productorDto.getNombreproductor()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getApellidoproductor()))
			return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getEmailproductor()))
			return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getClaveproductor()))
			return new ResponseEntity(new Mensaje("La clave es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productorDto.getTelefonoproductor()))
			return new ResponseEntity(new Mensaje("El Telefono es obligatorio"), HttpStatus.BAD_REQUEST);
		
		Productor productor = productorService.getOne(idproductor).get();
		productor.setNombreproductor(productorDto.getNombreproductor());
		productor.setApellidoproductor(productorDto.getApellidoproductor());
		productor.setEmailproductor(productorDto.getEmailproductor());
		productor.setClaveproductor(productorDto.getClaveproductor());
		productor.setTelefonoproductor(productorDto.getTelefonoproductor());
		productorService.save(productor);
		return new ResponseEntity(new Mensaje("Datos del productor modificados con exito"),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{idproductor}")
	public ResponseEntity<?> delete (@PathVariable ("idproductor") int idproductor){
		if (!productorService.existsById(idproductor))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
		productorService.delete(idproductor);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}
	
}
