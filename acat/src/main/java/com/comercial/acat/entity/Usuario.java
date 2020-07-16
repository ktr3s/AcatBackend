package com.comercial.acat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuario;
	private String nombreusuario;
	private String apellidousuario;
	private String emailusuario;
	private String claveusuario;
	private String telefonousuario;
	private String direccionusuario;
	
	public Usuario() {
		//super();
	}

	public Usuario(String nombreusuario, String apellidousuario, String emailusuario, String claveusuario,
			String telefonousuario, String direccionusuario) {
	    //super();
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.emailusuario = emailusuario;
		this.claveusuario = claveusuario;
		this.telefonousuario = telefonousuario;
		this.direccionusuario = direccionusuario;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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
