package com.backend.ernesto.dto;


public class RedSocialDto {
	
//  ATTRIBUTES

	private Long id;
	
	private String nombre;
	
	private String url;
	
	private String icono;

	
//  CONTRUCTORS
	public RedSocialDto() {
		super();
		// TODO Auto-generated constructor stub
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
