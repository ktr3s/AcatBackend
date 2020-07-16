package com.comercial.acat.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.acat.dto.Mensaje;
import com.comercial.acat.dto.UsuarioDto;
import com.comercial.acat.entity.Usuario;
import com.comercial.acat.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {

	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Usuario>> list(){
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody UsuarioDto usuarioDto){
		if(StringUtils.isBlank(usuarioDto.getNombreusuario()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getApellidousuario()))
			return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getEmailusuario()))
			return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getClaveusuario()))
			return new ResponseEntity(new Mensaje("La clave es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getTelefonousuario()))
			return new ResponseEntity(new Mensaje("El Telefono es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getDireccionusuario()))
			return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(usuarioService.existsByEmail(usuarioDto.getEmailusuario()))
			return new ResponseEntity(new Mensaje("Usted ya tiene una cuenta con ese correo"), HttpStatus.BAD_REQUEST);
		
		Usuario usuario = new Usuario(usuarioDto.getNombreusuario(),usuarioDto.getApellidousuario(),usuarioDto.getEmailusuario(),usuarioDto.getClaveusuario(),usuarioDto.getTelefonousuario(),usuarioDto.getDireccionusuario());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario agregado con exito"),HttpStatus.OK);
	
	}
	
	
	@PutMapping("/update/{idusuario}")
	public ResponseEntity<?> update (@PathVariable ("idusuario") int idusuario, @RequestBody UsuarioDto usuarioDto){
		
		if (!usuarioService.existsById(idusuario))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		if(usuarioService.existsByEmail(usuarioDto.getEmailusuario()) && usuarioService.getByEmail(usuarioDto.getEmailusuario()).get().getIdusuario() != idusuario )
			return new ResponseEntity(new Mensaje("Usted ya tiene una cuenta con ese correo"), HttpStatus.BAD_REQUEST);
		
		
		if(StringUtils.isBlank(usuarioDto.getNombreusuario()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getApellidousuario()))
			return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getEmailusuario()))
			return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getClaveusuario()))
			return new ResponseEntity(new Mensaje("La clave es obligatoria"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getTelefonousuario()))
			return new ResponseEntity(new Mensaje("El Telefono es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(usuarioDto.getDireccionusuario()))
			return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
		
		
		Usuario usuario = usuarioService.getOne(idusuario).get();
		usuario.setNombreusuario(usuarioDto.getNombreusuario());
		usuario.setApellidousuario(usuarioDto.getApellidousuario());
		usuario.setEmailusuario(usuarioDto.getEmailusuario());
		usuario.setClaveusuario(usuarioDto.getClaveusuario());
		usuario.setTelefonousuario(usuarioDto.getTelefonousuario());
		usuario.setDireccionusuario(usuarioDto.getDireccionusuario());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Datos del usuario modificados con exito"),HttpStatus.OK);
	
	}
	
	
}
