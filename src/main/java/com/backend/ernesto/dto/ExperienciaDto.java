package com.backend.ernesto.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

public class ExperienciaDto {
//  ATTRIBUTES
    private Long id;
    
	@NotEmpty
    private String nombre;
    
    private String descripcion;
    
    private LocalDate fechaInicio;
    
    private LocalDate fechaFin;
    
    private String logo;
    
//    CONSTRUCTORS
    public ExperienciaDto() {
    	super();
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
    
}
