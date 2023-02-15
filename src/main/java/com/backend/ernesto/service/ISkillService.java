package com.backend.ernesto.service;

import com.backend.ernesto.model.Skill;
import java.util.List;
import java.util.Optional;

public interface ISkillService {
    
    public List<Skill> listarSkill();
    
    public Skill crearSkill(Skill skill);
    
    public Skill actualizarSkill(Skill skill);
    
    public Optional<Skill> buscarSkill(Long id);
    
    public void eliminarSkill(Long id);  
}
