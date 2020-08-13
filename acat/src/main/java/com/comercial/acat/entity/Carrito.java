package com.comercial.acat.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="Carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;
	private String nombreproducto;
	@Type(type = "uuid-char")
	private UUID foto;
	private float pesoproducto;
	private float precioproducto;
	private String estadoproducto;
	private String categoriaproducto;
	private String descripcionproducto;
	
	public Carrito() {
		//super();
	}

	public Carrito(String nombreproducto, float pesoproducto, float precioproducto, String estadoproducto,
			String categoriaproducto,String descripcionproducto /*, Productor productor*/) {
		super();
		this.nombreproducto = nombreproducto;
		this.pesoproducto = pesoproducto;
		this.precioproducto = precioproducto;
		this.estadoproducto = estadoproducto;
		this.categoriaproducto = categoriaproducto;
		this.descripcionproducto = descripcionproducto;
		//this.productor = productor;
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

	/*public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}*/

	public String getDescripcionproducto() {
		return descripcionproducto;
	}

	public void setDescripcionproducto(String descripcionproducto) {
		this.descripcionproducto = descripcionproducto;
	}

	public UUID getFoto() {
		return foto;
	}

	public void setFoto(UUID foto) {
		this.foto = foto;
	}
}
