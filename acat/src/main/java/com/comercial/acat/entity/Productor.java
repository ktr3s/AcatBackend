package com.comercial.acat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Productor() {
		
	}

	public Productor(String nombreproductor, String apellidoproductor, String emailproductor, String claveproductor,
			String telefonoproductor) {
		
		this.nombreproductor = nombreproductor;
		this.apellidoproductor = apellidoproductor;
		this.emailproductor = emailproductor;
		this.claveproductor = claveproductor;
		this.telefonoproductor = telefonoproductor;
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

	
	
	
	
}
