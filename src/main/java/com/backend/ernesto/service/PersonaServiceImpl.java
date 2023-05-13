package com.backend.ernesto.service;

import com.backend.ernesto.dto.PersonaDto;
import com.backend.ernesto.model.Persona;
import com.backend.ernesto.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired //nos permite hace inyección de dependencias entre una clase y otra
    private IPersonaRepository personaRepo;
    
//    @Autowired
//	private ModelMapper modelMapper;

    @Override
    public List<PersonaDto> listarPersonas() {
        return this.personaRepo.findAll().stream()
        		.map(persona -> this.mapearAdto(persona))
        		.collect(Collectors.toList()); 
    }
    
    @Override
    public PersonaDto crearPersona(PersonaDto personaDto) {
    	// Convertimos de DTO a entidad para guardar en BD
    	Persona persona = this.personaRepo.save(this.mapearAentidad(personaDto));

    	return this.mapearAdto(persona);
    }
    
    @Override
    public PersonaDto actualizarPersona(PersonaDto personaDto, Long id) {
        Persona persona = this.personaRepo.findById(id)
        		.orElseThrow();
        persona.setApellido(personaDto.getApellido());
        persona.setNombre(personaDto.getNombre());
        persona.setEmail(personaDto.getEmail());
		persona.setImgFondo(personaDto.getImgFondo());
		persona.setImgPerfilUrl(personaDto.getImgPerfilUrl());
		persona.setSobreMi(personaDto.getSobreMi());
		persona.setTelefono(personaDto.getTelefono());
		persona.setTitulo(personaDto.getTitulo());
        
        
        this.personaRepo.save(persona);
        
        return this.mapearAdto(persona);
    }

//    @Override
//    public Optional<PersonaDto> buscarPersona(Long id) {
//        return this.mapearAdto(this.personaRepo.findById(id));
//    }
    
    @Override
    public void eliminarPersona(Long id) {
        Persona persona = this.personaRepo.findById(id).orElseThrow();
        this.personaRepo.delete(persona);
    }
    
	// Convierte de DTO a Entidad
	private Persona mapearAentidad(PersonaDto personaDto) {
		Persona persona = new Persona();
		persona.setNombre(personaDto.getNombre());
		persona.setApellido(personaDto.getApellido());
		persona.setEmail(personaDto.getEmail());
		persona.setImgFondo(personaDto.getImgFondo());
		persona.setImgPerfilUrl(personaDto.getImgPerfilUrl());
		persona.setSobreMi(personaDto.getSobreMi());
		persona.setTelefono(personaDto.getTelefono());
		persona.setTitulo(personaDto.getTitulo());
		
		return persona;
		
//		Persona persona = this.modelMapper.map(personaDto, Persona.class);
//
//		return persona;
	}
	
	// Convierte de Entidad a Dto
	private PersonaDto mapearAdto(Persona persona) {
		PersonaDto personaDto = new PersonaDto();
		
		personaDto.setId(persona.getId());
		personaDto.setNombre(persona.getNombre());
		personaDto.setApellido(persona.getApellido());
		personaDto.setEmail(persona.getEmail());
		personaDto.setImgFondo(persona.getImgFondo());
		personaDto.setImgPerfilUrl(persona.getImgPerfilUrl());
		personaDto.setSobreMi(persona.getSobreMi());
		personaDto.setTelefono(persona.getTelefono());
		personaDto.setTitulo(persona.getTitulo());
		
		return personaDto;
		
//		PersonaDto personaDto = this.modelMapper.map(persona, PersonaDto.class);
//
//		return personaDto;
	}

	@Override
	public PersonaDto obtenerPersonaPorId(Long id) {
		Persona persona = this.personaRepo.findById(id).
				orElseThrow();
		return this.mapearAdto(persona);
	}
    
}
