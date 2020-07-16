package com.comercial.acat.dto;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {

	@NotBlank
	private String nombreusuario;
	@NotBlank
	private String apellidousuario;
	@NotBlank
	private String emailusuario;
	@NotBlank
	private String claveusuario;
	@NotBlank
	private String telefonousuario;
	@NotBlank
	private String direccionusuario;
	
	public UsuarioDto() {
		//super();
	}

	public UsuarioDto(@NotBlank String nombreusuario, @NotBlank String apellidousuario, @NotBlank String emailusuario,
			@NotBlank String claveusuario, @NotBlank String telefonousuario, @NotBlank String direccionusuario) {
		super();
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.emailusuario = emailusuario;
		this.claveusuario = claveusuario;
		this.telefonousuario = telefonousuario;
		this.direccionusuario = direccionusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getApellidousuario() {
		return apellidousuario;
	}

	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getClaveusuario() {
		return claveusuario;
	}

	public void setClaveusuario(String claveusuario) {
		this.claveusuario = claveusuario;
	}

	public String getTelefonousuario() {
		return telefonousuario;
	}

	public void setTelefonousuario(String telefonousuario) {
		this.telefonousuario = telefonousuario;
	}

	public String getDireccionusuario() {
		return direccionusuario;
	}

	public void setDireccionusuario(String direccionusuario) {
		this.direccionusuario = direccionusuario;
	}
	
	
	
	
	
	
	
}
