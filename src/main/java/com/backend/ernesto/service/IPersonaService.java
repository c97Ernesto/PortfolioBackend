package com.backend.ernesto.service;

import com.portfolio.SpringBoot.model.Persona;
import java.util.List;
import java.util.Optional;



public interface IPersonaService {
    
    public void crear(Persona persona);
    
    public void eliminar(Long id);
    
    public void modificar(Persona persona);
    
    public Optional<Persona> buscar(Long id);
    
    public List<Persona> listar();
    
}
