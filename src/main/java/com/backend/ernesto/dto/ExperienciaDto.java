package com.backend.ernesto.dto;

import jakarta.validation.constraints.NotEmpty;

public class ExperienciaDto {
//  ATTRIBUTES
    private Long id;
    
	@NotEmpty
    private String nombre;
    
    private String descripcion;
    
//    CONSTRUCTORS
    public ExperienciaDto() {
    	super();
    }
    
    public ExperienciaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
