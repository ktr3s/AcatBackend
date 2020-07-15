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
import com.comercial.acat.dto.ProductoDto;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.service.ProductoService;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Producto>> list(){
		List<Producto> list = productoService.list();
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	@GetMapping ("/detail/{idproducto}")
	public ResponseEntity<Producto> getById (@PathVariable("idproducto") int idproducto){
		if (!productoService.existsById(idproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(idproducto).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@GetMapping ("/detailname/{nombreproducto}")
	public ResponseEntity<Producto> getByNombre (@PathVariable("nombreproducto") String nombreproducto){
		if (!productoService.existsByNombre(nombreproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getOne(nombreproducto).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody ProductoDto productoDto){
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
		

		Producto producto = new Producto(productoDto.getNombreproducto(),productoDto.getPesoproducto(),productoDto.getPrecioproducto(),productoDto.getEstadoproducto(),productoDto.getCategoriaproducto());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Productor agregado con exito"),HttpStatus.OK);
	
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
		
		Producto producto = productoService.getOne(idproducto).get();
		producto.setNombreproducto(productoDto.getNombreproducto());
		producto.setPesoproducto(productoDto.getPesoproducto());
		producto.setPrecioproducto(productoDto.getPrecioproducto());
		producto.setEstadoproducto(productoDto.getEstadoproducto());
		producto.setCategoriaproducto(productoDto.getCategoriaproducto());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Datos del productor modificados con exito"),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{idproducto}")
	public ResponseEntity<?> delete (@PathVariable ("idproducto") int idproducto){
		if (!productoService.existsById(idproducto))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
		productoService.delete(idproducto);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}
	
}
