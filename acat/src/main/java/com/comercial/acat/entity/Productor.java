package com.comercial.acat.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productor")
public class Productor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproductor;
	private String nombreproductor;
	private String apellidoproductor;
	private String emailproductor;
	private String claveproductor;
	private String telefonoproductor;
	
	
	//Asociacion con la tabla producto 
	/*@OneToMany(mappedBy="productor", fetch = FetchType.EAGER)
	private Set<Producto> productos = new HashSet<>();*/
	
	public Productor() {
		
	}

	public Productor(String nombreproductor, String apellidoproductor, String emailproductor, String claveproductor,
			String telefonoproductor /*, Set<Producto> productos*/) {
		super();
		this.nombreproductor = nombreproductor;
		this.apellidoproductor = apellidoproductor;
		this.emailproductor = emailproductor;
		this.claveproductor = claveproductor;
		this.telefonoproductor = telefonoproductor;
		//this.productos = productos;
	}

	public int getIdproductor() {
		return idproductor;
	}

	public void setIdproductor(int idproductor) {
		this.idproductor = idproductor;
	}

	public String getNombreproductor() {
		return nombreproductor;
	}

	public void setNombreproductor(String nombreproductor) {
		this.nombreproductor = nombreproductor;
	}

	public String getApellidoproductor() {
		return apellidoproductor;
	}

	public void setApellidoproductor(String apellidoproductor) {
		this.apellidoproductor = apellidoproductor;
	}

	public String getEmailproductor() {
		return emailproductor;
	}

	public void setEmailproductor(String emailproductor) {
		this.emailproductor = emailproductor;
	}

	public String getClaveproductor() {
		return claveproductor;
	}

	public void setClaveproductor(String claveproductor) {
		this.claveproductor = claveproductor;
	}

	public String getTelefonoproductor() {
		return telefonoproductor;
	}

	public void setTelefonoproductor(String telefonoproductor) {
		this.telefonoproductor = telefonoproductor;
	}

	/*public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}*/

	
	
	
	
	
}
