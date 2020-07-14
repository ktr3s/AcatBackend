package com.comercial.acat.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comercial.acat.entity.Productor;


@Repository
public interface ProductorRepository extends JpaRepository<Productor, Integer> {

		/*Optional<Productor>findByIdproductor(int idproductor);
		boolean existsByIdproductor(int idproductor);*/
	
		Optional<Productor>findByNombreproductor(String nombreproductor);
		boolean existsByNombreproductor(String nombreproductor);
		
		Optional<Productor>findByEmailproductor(String emailproductor);
		boolean existsByEmailproductor(String emailproductor);
}
