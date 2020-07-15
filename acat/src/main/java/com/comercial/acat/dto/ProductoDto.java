package com.comercial.acat.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {
	@NotBlank
	private String nombreproducto;
	@Min(0)
	private int pesoproducto;
	@Min(0)
	private int precioproducto;
	@NotBlank
	private String estadoproducto;
	@NotBlank
	private String categoriaproducto;
	
	public ProductoDto() {
		//super();
	}

	public ProductoDto(@NotBlank String nombreproducto, @Min(0) int pesoproducto, @Min(0) int precioproducto,
			@NotBlank String estadoproducto, @NotBlank String categoriaproducto) {
		super();
		this.nombreproducto = nombreproducto;
		this.pesoproducto = pesoproducto;
		this.precioproducto = precioproducto;
		this.estadoproducto = estadoproducto;
		this.categoriaproducto = categoriaproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public int getPesoproducto() {
		return pesoproducto;
	}

	public void setPesoproducto(int pesoproducto) {
		this.pesoproducto = pesoproducto;
	}

	public int getPrecioproducto() {
		return precioproducto;
	}

	public void setPrecioproducto(int precioproducto) {
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

	