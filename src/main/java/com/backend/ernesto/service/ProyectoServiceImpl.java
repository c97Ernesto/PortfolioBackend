package com.backend.ernesto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.ernesto.dto.ProyectoDto;
import com.backend.ernesto.model.Proyecto;
import com.backend.ernesto.repository.IProyectoRepository;

public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private IProyectoRepository proyectoRepository;
	
//  @Autowired
//	private ModelMapper modelMapper;
    
    @Override
    public List<ProyectoDto> listarProyectos() {
        return this.proyectoRepository.findAll().stream()
        		.map(proyecto -> this.mapearAdto(proyecto))
        		.collect(Collectors.toList());
    }

    @Override
    public ProyectoDto crearProyecto(ProyectoDto proyectoDto) {
    	// Convertimos de DTO a entidad para guardar en BD
    	Proyecto proyecto= this.proyectoRepository.save(this.mapearAentidad(proyectoDto));
        return this.mapearAdto(proyecto);
    }

    @Override
    public ProyectoDto actualizarProyecto(ProyectoDto proyectoDto, Long id) {
    	Proyecto proyecto = this.proyectoRepository.findById(id)
    			.orElseThrow();
    	
    	proyecto.setDescripcion(proyectoDto.getDescripcion());
    	proyecto.setNombre(proyectoDto.getNombre());
    	
    	this.proyectoRepository.save(proyecto);
    	
    	return this.mapearAdto(proyecto);
    }

//    @Override
//    public Optional<ProyectoDto> buscarProyecto(Long id) {
//        return this.proyectoRepository.findById(id);
//    }

    @Override
    public void eliminarProyecto(Long id) {
    	Proyecto proyecto= this.proyectoRepository.findById(id).orElseThrow();
        this.proyectoRepository.delete(proyecto);
    }
    
	// Convierte de Entidad a Dto
	private ProyectoDto mapearAdto(Proyecto proyecto) {
		ProyectoDto proyectoDto = new ProyectoDto();
		
		proyectoDto.setId(proyecto.getId());
		proyectoDto.setNombre(proyecto.getNombre());
		proyectoDto.setDescripcion(proyecto.getDescripcion());
		proyectoDto.setLink(proyecto.getLink());
		proyectoDto.setImagen(proyecto.getImagen());
		proyectoDto.setFechaCreacion(proyecto.getFechaCreacion());
		
		
		
		return proyectoDto;
		
//		ProyectoDto proyectoDto = this.modelMapper.map(proyecto, ProyectoDto.class);
//
//		return proyectoDto;
	}
	
	// Convierte de DTO a Entidad
	private Proyecto mapearAentidad(ProyectoDto proyectoDto) {
		Proyecto proyecto = new Proyecto();
		
		proyecto.setNombre(proyectoDto.getNombre());
		proyecto.setDescripcion(proyectoDto.getDescripcion());
		proyecto.setLink(proyectoDto.getLink());
		proyecto.setImagen(proyectoDto.getImagen());
		proyecto.setFechaCreacion(proyectoDto.getFechaCreacion());
		
		return proyecto;
		
//		Proyecto proyecto = this.modelMapper.map(proyectoDto, Proyecto.class);
//
//		return proyecto;
	}

}
