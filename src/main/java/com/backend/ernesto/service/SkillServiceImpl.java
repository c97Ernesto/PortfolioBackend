package com.backend.ernesto.service;

import com.backend.ernesto.dto.SkillDto;
import com.backend.ernesto.model.Skill;
import com.backend.ernesto.repository.ISkillRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService{
    
    @Autowired
    private ISkillRepository skillRepo;

//  @Autowired
//	private ModelMapper modelMapper;
    
    @Override
    public List<SkillDto> listarSkill() {
        return this.skillRepo.findAll().stream()
        		.map(experiencia -> this.mapearAdto(experiencia))
        		.collect(Collectors.toList());
    }

    @Override
    public SkillDto crearSkill(SkillDto skillDto) {
    	// Convertimos de DTO a entidad para guardar en BD
    	Skill skill= this.skillRepo.save(this.mapearAentidad(skillDto));
        return this.mapearAdto(skill);
    }

    @Override
    public SkillDto actualizarSkill(SkillDto skillDto, Long id) {
    	Skill skill = this.skillRepo.findById(id)
    			.orElseThrow();
    	
    	skill.setNombre(skillDto.getNombre());
    	skill.setPorcentaje(skillDto.getPorcentaje());
    	
    	this.skillRepo.save(skill);
    	
    	return this.mapearAdto(skill);
    }

//    @Override
//    public Optional<EducacionDto> buscarEducacion(Long id) {
//        return this.educacionRepo.findById(id);
//    }

    @Override
    public void eliminarSkill(Long id) {
    	Skill skill = this.skillRepo.findById(id).orElseThrow();
        this.skillRepo.delete(skill);
    }
    
	// Convierte de Entidad a Dto
	private SkillDto mapearAdto(Skill skill) {
		SkillDto skillDto = new SkillDto();
		
		skillDto.setId(skill.getId());
		skillDto.setNombre(skill.getNombre());
		skillDto.setPorcentaje(skill.getPorcentaje());
		
		return skillDto;
		
//		PersonaDto personaDto = this.modelMapper.map(persona, PersonaDto.class);
//
//		return personaDto;
	}
	
	// Convierte de DTO a Entidad
	private Skill mapearAentidad(SkillDto skillDto) {
		Skill skill = new Skill();
		
		skill.setNombre(skillDto.getNombre());
		skill.setPorcentaje(skillDto.getPorcentaje());
		
		return skill;
		
//		Skill skill = this.modelMapper.map(skillDto, Skill.class);
//
//		return skill;
	}
    
}
