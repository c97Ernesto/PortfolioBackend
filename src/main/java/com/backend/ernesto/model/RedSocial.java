package com.backend.ernesto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RedSocial {
	
//  ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String url;
	
	private String icono;

	
//  CONTRUCTORS
	public RedSocial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RedSocial(String nombre, String url, String icono) {
		super();
	
		this.nombre = nombre;
		this.url = url;
		this.icono = icono;
	}
	
//    GETTER AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
	
}
