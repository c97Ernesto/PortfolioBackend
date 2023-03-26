package com.backend.ernesto.service;

import com.backend.ernesto.dto.ExperienciaDto;
import java.util.List;

public interface ExperienciaService {
    
    public List<ExperienciaDto> listarExperiencia();
    
    public ExperienciaDto crearExperiencia(ExperienciaDto experiencia);
    
    public ExperienciaDto actualizarExperiencia(ExperienciaDto experiencia, Long id);
    
//    public Optional<ExperienciaDto> buscarExperiencia(Long id);
    
    public void eliminarExperiencia(Long id);   
}
