package com.backend.ernesto.service;

import com.backend.ernesto.dto.EducacionDto;
import java.util.List;

public interface EducacionService {
    
    public List<EducacionDto> listarEducacion();
    
    public EducacionDto crearEducacion(EducacionDto educacion);
    
    public EducacionDto actualizarEducacion(EducacionDto educacion, Long id);
    
//    public Optional<EducacionDto> buscarEducacion(Long id);
    
    public void eliminarEducacion(Long id);   
}
