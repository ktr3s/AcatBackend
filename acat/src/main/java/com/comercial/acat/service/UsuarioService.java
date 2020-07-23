package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Productor;
import com.comercial.acat.entity.Usuario;
import com.comercial.acat.repository.UsuarioRepository;

@Service
@Transactional

public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> list(){
		return usuarioRepository.findAll();  //debuelve todos los productores de la tabla
	}
	
	public Optional<Usuario> getByEmail(String emailusuario){
		return usuarioRepository.findByEmailusuario(emailusuario); //devuelve los usuarios por nombre
	}
	
	public void save (Usuario usuario) {//crea una entidad usuario
		usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> getOne(int idusuario){
		return usuarioRepository.findById(idusuario); //devuelve un usuario filtrado por id
	}
	
	public boolean existsByEmail(String emailusuario) {
		return usuarioRepository.existsByEmailusuario(emailusuario); //devuelve true si ya existe ese correo
	}
	
	public boolean existsById(int idusuario) {
		return usuarioRepository.existsById(idusuario); //devuelve true si existe un usuario buscado por id
	}
	public void delete (int idusuario) {
		usuarioRepository.deleteById(idusuario);  //elimina un productor por su Id
	}
	
}
