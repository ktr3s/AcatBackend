package com.comercial.acat.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
///////////////////////////
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
///////////////////////////
import com.comercial.acat.dto.Mensaje;
import com.comercial.acat.dto.ProductoDto;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Productor;
import com.comercial.acat.exceptions.RecordNotFoundException;
import com.comercial.acat.service.PictureService;
import com.comercial.acat.service.ProductoService;
import com.comercial.acat.service.ProductorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	ProductorService productorService;
	
	@Autowired
	PictureService picService; /////////////
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Producto>> list(){
		List<Producto> list = productoService.list();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@GetMapping ("/listar/{categoria}")
	public ResponseEntity<List<Producto>> getByCategoria(@PathVariable("categoria") String categoria){
		List<Producto> producto = productoService.getByCategoria(categoria);
		return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);   //*******lista productos de una categoria seleccionada
	}
	
	@GetMapping ("/listar/estado/{estadoproducto}")
	public ResponseEntity<List<Producto>> getByEstado(@PathVariable("estadoproducto") String estadoproducto){
		List<Producto> producto = productoService.getByEstado(estadoproducto);
		return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);   //*******lista productos de estado seleccionada
	}
	
	
	@GetMapping ("/detail/{idproducto}")
	public ResponseEntity<Producto> getById (@PathVariable("idproducto") int idproducto){
		if (!productoService.existsById(idproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(idproducto).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	/*@GetMapping ("/productosproductor/{idproductor}")
	public ResponseEntity<List<Producto>> getByIdproductor (@PathVariable("idproductor") Productor idproductor){
		List<Producto> producto = productoService.getByIdproductor(idproductor);
		return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);     //***********************
	}*/
	
	@GetMapping ("/detailname/{nombreproducto}")
	public ResponseEntity<Producto> getByNombre (@PathVariable("nombreproducto") String nombreproducto){
		if (!productoService.existsByNombre(nombreproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(nombreproducto).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping("/create/{idproductor}")
	public ResponseEntity<?> create (/*@PathVariable ("idproductor") int idproductor,*/@RequestBody ProductoDto productoDto){
		
		/*if (!productorService.existsById(idproductor))
			return new ResponseEntity(new Mensaje("El ID del productor no existe"), HttpStatus.NOT_FOUND);*/
		
		if(StringUtils.isBlank(productoDto.getNombreproducto()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(productoDto.getPesoproducto()<0)
			return new ResponseEntity(new Mensaje("El Peso debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		
		if(productoDto.getPrecioproducto()<0)
			return new ResponseEntity(new Mensaje("El Precio debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getEstadoproducto()))
			return new ResponseEntity(new Mensaje("El Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getCategoriaproducto()))
			return new ResponseEntity(new Mensaje("La categoria es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getDescripcionproducto()))
			return new ResponseEntity(new Mensaje("La categoria es obligatoria"), HttpStatus.BAD_REQUEST);
		
	
		Producto producto = new Producto(
				productoDto.getNombreproducto(),
				productoDto.getPesoproducto(),
				productoDto.getPrecioproducto(),
				productoDto.getEstadoproducto(),
				productoDto.getCategoriaproducto(),
				productoDto.getDescripcionproducto());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Producto agregado con exito"),HttpStatus.OK);
	
	}
	
	
	@PutMapping("/update/{idproducto}")
	public ResponseEntity<?> update (@PathVariable ("idproducto") int idproducto, @RequestBody ProductoDto productoDto){
		
		if (!productoService.existsById(idproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		
		if(StringUtils.isBlank(productoDto.getNombreproducto()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(productoDto.getPesoproducto()<0)
			return new ResponseEntity(new Mensaje("El peso debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		
		if(productoDto.getPrecioproducto()<0)
			return new ResponseEntity(new Mensaje("El precio debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getEstadoproducto()))
			return new ResponseEntity(new Mensaje("El estado es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getCategoriaproducto()))
			return new ResponseEntity(new Mensaje("La categoria es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(productoDto.getDescripcionproducto()))
			return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
		
		Producto producto = productoService.getOne(idproducto).get();
		producto.setNombreproducto(productoDto.getNombreproducto());
		producto.setPesoproducto(productoDto.getPesoproducto());
		producto.setPrecioproducto(productoDto.getPrecioproducto());
		producto.setEstadoproducto(productoDto.getEstadoproducto());
		producto.setCategoriaproducto(productoDto.getCategoriaproducto());
		producto.setDescripcionproducto(productoDto.getDescripcionproducto());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Datos del producto modificados con exito"),HttpStatus.OK);
	
	}
	
	///////////////////////////////////////////////////////////
	/*
	@PostMapping("/create")
	public ResponseEntity<Producto> createProducto(@RequestParam("producto") String s, @RequestParam("img") LinkedList<MultipartFile> file) throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		Producto producto = om.readValue(s, Producto[].class)[0];		
		
		if (!file.isEmpty()) {
			UUID idPic = UUID.randomUUID();
			picService.uploadPicture(file.get(0), idPic);
			producto.setFoto(idPic);		
		}
		productoService.createProducto(producto);
		return new ResponseEntity<Producto>(producto, new HttpHeaders(), HttpStatus.OK);
	}

	
	@PutMapping("/update")
	public ResponseEntity<Producto> updateProducto(@RequestParam("receta") String s, @RequestParam("img") LinkedList<MultipartFile> file) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		Producto producto = om.readValue(s, Producto[].class)[0];
		
	    if (!file.isEmpty()) {
	    	 picService.deletePicture(producto.getFoto());
		     UUID idPic = UUID.randomUUID();
		     picService.uploadPicture(file.get(0), idPic);
		     producto.setFoto(idPic);
	     }	
	    productoService.updateProducto(producto);		
		return new ResponseEntity<Producto>(producto, new HttpHeaders(), HttpStatus.OK);
	}	
	
	
	
	//////////////////////////////////////////////////////////
	*/
	
	@DeleteMapping("/delete/{idproducto}")
	public ResponseEntity<?> delete (@PathVariable ("idproducto") int idproducto){
		if (!productoService.existsById(idproducto))
			return new ResponseEntity(new Mensaje("No existe el producto"),HttpStatus.NOT_FOUND);
		productoService.delete (idproducto);
		return new ResponseEntity(new Mensaje("Se elimino el producto correctamente"),HttpStatus.OK);
	}
	
}
