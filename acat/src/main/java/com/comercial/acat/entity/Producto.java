package com.comercial.acat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")

public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;
	private String nombreproducto;
	private float pesoproducto;
	private float precioproducto;
	private String estadoproducto;
	private String categoriaproducto;
	
	public Producto() {
		//super();
	}

	public Producto(String nombreproducto, float pesoproducto, float precioproducto, String estadoproducto,
			String categoriaproducto) {
		super();
		this.nombreproducto = nombreproducto;
		this.pesoproducto = pesoproducto;
		this.precioproducto = precioproducto;
		this.estadoproducto = estadoproducto;
		this.categoriaproducto = categoriaproducto;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public float getPesoproducto() {
		return pesoproducto;
	}

	public void setPesoproducto(float pesoproducto) {
		this.pesoproducto = pesoproducto;
	}

	public float getPrecioproducto() {
		return precioproducto;
	}

	public void setPrecioproducto(float precioproducto) {
		this.precioproducto = precioproducto;
	}

	public String getEstadoproducto() {
		return estadoproducto;
	}

	public void setEstadoproducto(String estadoproducto) {
		this.estadoproducto = estadoproducto;
	}

	public String getCategoriaproducto() {
		return categoriaproducto;
	}

	public void setCategoriaproducto(String categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}
	
	
	

}