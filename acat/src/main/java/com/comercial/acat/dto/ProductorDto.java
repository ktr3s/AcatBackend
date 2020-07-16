package com.comercial.acat.dto;

import javax.validation.constraints.NotBlank;

public class ProductorDto {
	
	@NotBlank
	private String nombreproductor;
	@NotBlank
	private String apellidoproductor;
	@NotBlank
	private String emailproductor;
	@NotBlank
	private String claveproductor;
	@NotBlank
	private String telefonoproductor;
	
	public ProductorDto() {
		
	}

	public ProductorDto(String nombreproductor, String apellidoproductor, String emailproductor, String claveproductor,
			String telefonoproductor) {
		
		this.nombreproductor = nombreproductor;
		this.apellidoproductor = apellidoproductor;
		this.emailproductor = emailproductor;
		this.claveproductor = claveproductor;
		this.telefonoproductor = telefonoproductor;
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
