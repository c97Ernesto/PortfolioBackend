package com.backend.ernesto.service;

import com.backend.ernesto.dto.EducacionDto;
import com.backend.ernesto.model.Educacion;
import com.backend.ernesto.repository.IEducacionRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionServiceImpl implements EducacionService{
    
    @Autowired
    private IEducacionRepository educacionRepo;

//  @Autowired
//	private ModelMapper modelMapper;
    
    @Override
    public List<EducacionDto> listarEducacion() {
        return this.educacionRepo.findAll().stream()
        		.map(educacion -> this.mapearAdto(educacion))
        		.collect(Collectors.toList());
    }

    @Override
    public EducacionDto crearEducacion(EducacionDto educacionDto) {
    	// Convertimos de DTO a entidad para guardar en BD
        Educacion educacion = this.educacionRepo.save(this.mapearAentidad(educacionDto));
        return this.mapearAdto(educacion);
    }

    @Override
    public EducacionDto actualizarEducacion(EducacionDto educacionDto, Long id) {
    	Educacion educacion = this.educacionRepo.findById(id)
    			.orElseThrow();
    	
    	educacion.setNombre(educacionDto.getNombre());
    	educacion.setDescripcion(educacionDto.getDescripcion());
    	educacion.setFechaInicio(educacionDto.getFechaInicio());
		educacion.setFechaFin(educacionDto.getFechaFin());
		educacion.setLogo(educacionDto.getLogo());
    	
    	this.educacionRepo.save(educacion);
    	
    	return this.mapearAdto(educacion);
    }

//    @Override
//    public Optional<EducacionDto> buscarEducacion(Long id) {
//        return this.educacionRepo.findById(id);
//    }

    @Override
    public void eliminarEducacion(Long id) {
    	Educacion educacion = this.educacionRepo.findById(id).orElseThrow();
        this.educacionRepo.delete(educacion);
    }
    
	// Convierte de Entidad a Dto
	private EducacionDto mapearAdto(Educacion educacion) {
		EducacionDto educacionDto = new EducacionDto();
		
		educacionDto.setId(educacion.getId());
		educacionDto.setNombre(educacion.getNombre());
		educacionDto.setDescripcion(educacion.getDescripcion());
		educacionDto.setFechaInicio(educacion.getFechaInicio());
		educacionDto.setFechaFin(educacion.getFechaFin());
		educacionDto.setLogo(educacion.getLogo());
		
		
		return educacionDto;
		
//		PersonaDto personaDto = this.modelMapper.map(persona, PersonaDto.class);
//
//		return personaDto;
	}
	
	// Convierte de DTO a Entidad
	private Educacion mapearAentidad(EducacionDto educacionDto) {
		Educacion educacion = new Educacion();
		
		educacion.setNombre(educacionDto.getNombre());
		educacion.setDescripcion(educacionDto.getDescripcion());
		educacion.setFechaInicio(educacionDto.getFechaInicio());
		educacion.setFechaFin(educacionDto.getFechaFin());
		educacion.setLogo(educacionDto.getLogo());
		
		return educacion;
		
//		Persona persona = this.modelMapper.map(personaDto, Persona.class);
//
//		return persona;
	}
    
}
