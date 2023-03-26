package com.backend.ernesto.dto;

import jakarta.validation.constraints.NotEmpty;


public class SkillDto {
	
//  ATTRIBUTES
    private Long id;
    
	@NotEmpty
    private String nombre;
    
    private int porcentaje;

//  CONSTRUCTORS
    public SkillDto() {
    }
    public SkillDto(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

//  GETTERS AND SETTERS
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

    public int getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
   
}
