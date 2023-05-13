package com.backend.ernesto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
//    ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellido;

	private String titulo;

	private String sobreMi;

	private String telefono;

	private String email;

	private String imgPerfilUrl;

	private String imgFondo;

//    CONTRUCTORS
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Persona(String nombre, String apellido, String titulo, String sobreMi, String telefono, String email,
			String imgPerfilUrl, String imgFondo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.titulo = titulo;
		this.sobreMi = sobreMi;
		this.telefono = telefono;
		this.email = email;
		this.imgPerfilUrl = imgPerfilUrl;
		this.imgFondo = imgFondo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSobreMi() {
		return sobreMi;
	}

	public void setSobreMi(String sobreMi) {
		this.sobreMi = sobreMi;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgPerfilUrl() {
		return imgPerfilUrl;
	}

	public void setImgPerfilUrl(String imgPerfilUrl) {
		this.imgPerfilUrl = imgPerfilUrl;
	}

	public String getImgFondo() {
		return imgFondo;
	}

	public void setImgFondo(String imgFondo) {
		this.imgFondo = imgFondo;
	}
}
