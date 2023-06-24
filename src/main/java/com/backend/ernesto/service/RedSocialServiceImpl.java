package com.backend.ernesto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ernesto.dto.RedSocialDto;
import com.backend.ernesto.model.RedSocial;
import com.backend.ernesto.repository.IRedSocialRepository;

@Service
public class RedSocialServiceImpl implements RedSocialService{
	@Autowired //nos permite hace inyección de dependencias entre una clase y otra
    private IRedSocialRepository redSocialRepository;
    
//    @Autowired
//	private ModelMapper modelMapper;

    @Override
    public List<RedSocialDto> listar() {
        return this.redSocialRepository.findAll().stream()
        		.map(redSocial -> this.mapearAdto(redSocial))
        		.collect(Collectors.toList()); 
    }
    
    @Override
    public RedSocialDto crearRedSocial(RedSocialDto redSocialDto) {
    	// Convertimos de DTO a entidad para guardar en BD
    	RedSocial redSocial = this.redSocialRepository.save(this.mapearAentidad(redSocialDto));

    	return this.mapearAdto(redSocial);
    }
    
    @Override
    public RedSocialDto actualizarRedSocial(RedSocialDto redSocialDto, Long id) {
        RedSocial redSocial = this.redSocialRepository.findById(id)
        		.orElseThrow();
        
        redSocial.setNombre(redSocialDto.getNombre());
        redSocial.setUrl(redSocialDto.getUrl());
		redSocial.setIcono(redSocialDto.getIcono());
        
        this.redSocialRepository.save(redSocial);
        
        return this.mapearAdto(redSocial);
    }

//    @Override
//    public Optional<RedSocialDto> buscarRedSocial(Long id) {
//        return this.mapearAdto(this.redSocialRepository.findById(id));
//    }
    
    @Override
    public void eliminarRedSocial(Long id) {
        RedSocial redSocial = this.redSocialRepository.findById(id).orElseThrow();
        this.redSocialRepository.delete(redSocial);
    }
    
	// Convierte de DTO a Entidad
	private RedSocial mapearAentidad(RedSocialDto redSocialDto) {
		RedSocial redSocial = new RedSocial();
		redSocial.setNombre(redSocialDto.getNombre());
		redSocial.setUrl(redSocialDto.getUrl());
		redSocial.setIcono(redSocialDto.getIcono());
		
		return redSocial;
		
//		RedSocial redSocial = this.modelMapper.map(redSocialDto, RedSocial.class);
//
//		return redSocial;
	}
	
	// Convierte de Entidad a Dto
	private RedSocialDto mapearAdto(RedSocial redSocial) {
		RedSocialDto redSocialDto = new RedSocialDto();
		
		redSocialDto.setId(redSocial.getId());
		redSocialDto.setNombre(redSocial.getNombre());
		redSocialDto.setUrl(redSocial.getUrl());
		redSocialDto.setIcono(redSocial.getIcono());
		
		return redSocialDto;
		
//		RedSocialDto redSocialDto = this.modelMapper.map(redSocial, RedSocialDto.class);
//
//		return redSocialDto;
	}

	@Override
	public RedSocialDto obtenerRedSocial(Long id) {
		RedSocial redSocial = this.redSocialRepository.findById(id).
				orElseThrow();
		return this.mapearAdto(redSocial);
	}

}
