package com.comercial.acat.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CarritoDto {

	@NotBlank
	private String nombreproducto;
	@Min(0)
	private float pesoproducto;
	@Min(0)
	private float precioproducto;
	@NotBlank
	private String estadoproducto;
	@NotBlank
	private String categoriaproducto;
	@NotBlank
	private String descripcionproducto;
	
	/*
	@ManyToOne
	@JoinColumn(name="idproductor")
	Productor productor;*/
	
	public CarritoDto() {
		//super();
	}

	public CarritoDto(@NotBlank String nombreproducto, @Min(0) float pesoproducto, @Min(0) float precioproducto,
			@NotBlank String estadoproducto, @NotBlank String categoriaproducto, @NotBlank String descripcionproducto /*, Productor productor*/) {
		super();
		this.nombreproducto = nombreproducto;
		this.pesoproducto = pesoproducto;
		this.precioproducto = precioproducto;
		this.estadoproducto = estadoproducto;
		this.categoriaproducto = categoriaproducto;
		this.descripcionproducto = descripcionproducto;
		//this.productor = productor;
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
/*
	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}
*/
	public String getDescripcionproducto() {
		return descripcionproducto;
	}

	public void setDescripcionproducto(String descripcionproducto) {
		this.descripcionproducto = descripcionproducto;
	}
}
