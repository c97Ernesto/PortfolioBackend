package com.backend.ernesto.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonaDto {

    private Long id;
    
	@NotEmpty
	@Size(min = 2, message = "El nombre debería tener al menos dos caracteres")
    private String nombre;
	
	@NotEmpty
	@Size(min = 2, message = "El apellido debería tener al menos dos caracteres")
    private String apellido;
	
	private String titulo;

	private String sobreMi;

	private String telefono;

	private String email;

	private String imgPerfilUrl;

	private String imgFondo;

//  CONTRUCTORS
    public PersonaDto() {
		super();  
  	}
    
//  GETTER AND SETTERS
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
