package com.backend.ernesto.service;

import com.backend.ernesto.dto.PersonaDto;
import java.util.List;



public interface PersonaService {
    
    public List<PersonaDto> listarPersonas();
    
    public PersonaDto crearPersona(PersonaDto persona);
    
    public PersonaDto actualizarPersona(PersonaDto persona, Long id);
    
//    public Optional<PersonaDto> buscarPersona(Long id);
    
    public void eliminarPersona(Long id);
}
