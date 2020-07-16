package com.comercial.acat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comercial.acat.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	Optional<Usuario>findByEmailusuario(String emailusuario);
	boolean existsByEmailusuario(String emailusuario);

}
