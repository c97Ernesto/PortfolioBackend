package com.backend.ernesto.service;

import com.backend.ernesto.dto.ExperienciaDto;
import com.backend.ernesto.model.Experiencia;
import com.backend.ernesto.repository.IExperienciaRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaServiceImpl implements ExperienciaService{
    
    @Autowired
    private IExperienciaRepository experienciaRepo;

//  @Autowired
//	private ModelMapper modelMapper;
    
    @Override
    public List<ExperienciaDto> listarExperiencia() {
        return this.experienciaRepo.findAll().stream()
        		.map(experiencia -> this.mapearAdto(experiencia))
        		.collect(Collectors.toList());
    }

    @Override
    public ExperienciaDto crearExperiencia(ExperienciaDto experienciaDto) {
    	// Convertimos de DTO a entidad para guardar en BD
    	Experiencia experiencia= this.experienciaRepo.save(this.mapearAentidad(experienciaDto));
        return this.mapearAdto(experiencia);
    }

    @Override
    public ExperienciaDto actualizarExperiencia(ExperienciaDto experienciaDto, Long id) {
    	Experiencia experiencia = this.experienciaRepo.findById(id)
    			.orElseThrow();
    	
    	experiencia.setDescripcion(experienciaDto.getDescripcion());
    	experiencia.setNombre(experienciaDto.getNombre());
    	experiencia.setFechaInicio(experienciaDto.getFechaInicio());
		experiencia.setFechaFin(experienciaDto.getFechaFin());
		experiencia.setLogo(experienciaDto.getLogo());
    	
    	this.experienciaRepo.save(experiencia);
    	
    	return this.mapearAdto(experiencia);
    }

//    @Override
//    public Optional<EducacionDto> buscarEducacion(Long id) {
//        return this.educacionRepo.findById(id);
//    }

    @Override
    public void eliminarExperiencia(Long id) {
    	Experiencia experiencia= this.experienciaRepo.findById(id).orElseThrow();
        this.experienciaRepo.delete(experiencia);
    }
    
	// Convierte de Entidad a Dto
	private ExperienciaDto mapearAdto(Experiencia experiencia) {
		ExperienciaDto experienciaDto = new ExperienciaDto();
		
		experienciaDto.setId(experiencia.getId());
		experienciaDto.setNombre(experiencia.getNombre());
		experienciaDto.setDescripcion(experiencia.getDescripcion());
		experienciaDto.setFechaInicio(experiencia.getFechaInicio());
		experienciaDto.setFechaFin(experiencia.getFechaFin());
		experienciaDto.setLogo(experiencia.getLogo());
		
		
		return experienciaDto;
		
//		PersonaDto personaDto = this.modelMapper.map(persona, PersonaDto.class);
//
//		return personaDto;
	}
	
	// Convierte de DTO a Entidad
	private Experiencia mapearAentidad(ExperienciaDto experienciaDto) {
		Experiencia experiencia= new Experiencia();
		
		experiencia.setNombre(experienciaDto.getNombre());
		experiencia.setDescripcion(experienciaDto.getDescripcion());
		experiencia.setFechaInicio(experienciaDto.getFechaInicio());
		experiencia.setFechaFin(experienciaDto.getFechaFin());
		experiencia.setLogo(experienciaDto.getLogo());
		
		return experiencia;
		
//		Experiencia experiencia = this.modelMapper.map(experienciaDto, Experiencia.class);
//
//		return experiencia;
	}
    
}
