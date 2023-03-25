package com.backend.ernesto.service;

import com.backend.ernesto.model.Persona;
import java.util.List;
import java.util.Optional;



public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public Persona crearPersona(Persona persona);
    
    public Persona actualizarPersona(Persona persona);
    
    public Optional<Persona> buscarPersona(Long id);
    
    public void eliminarPersona(Long id);
}
