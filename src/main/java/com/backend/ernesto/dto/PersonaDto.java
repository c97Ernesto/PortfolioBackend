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
	
    private String descripcion;
    
    private String imagenUrl;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
    
    
	
}
