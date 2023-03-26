package com.backend.ernesto.service;

import com.backend.ernesto.dto.SkillDto;
import java.util.List;

public interface SkillService {
    
    public List<SkillDto> listarSkill();
    
    public SkillDto crearSkill(SkillDto skill);
    
    public SkillDto actualizarSkill(SkillDto skill, Long id);
    
//    public Optional<SkillDto> buscarSkill(Long id);
    
    public void eliminarSkill(Long id);   
}
