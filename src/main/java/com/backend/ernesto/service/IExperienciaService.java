package com.backend.ernesto.service;


import com.backend.ernesto.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
     
    public List<Experiencia> listarExperiencia();
    
    public Experiencia crearExperiencia(Experiencia experiencia);
    
    public Experiencia actualizarExperiencia(Experiencia experiencia);
    
    public Optional<Experiencia> buscarExperiencia(Long id);
    
    public void eliminarExperiencia(Long id);   
}
