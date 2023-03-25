package com.backend.ernesto.service;

import com.backend.ernesto.model.Educacion;
import java.util.List;
import java.util.Optional;

public interface EducacionService {
    
    public List<Educacion> listarEducacion();
    
    public Educacion crearEducacion(Educacion educacion);
    
    public Educacion actualizarEducacion(Educacion educacion);
    
    public Optional<Educacion> buscarEducacion(Long id);
    
    public void eliminarEducacion(Long id);   
}
