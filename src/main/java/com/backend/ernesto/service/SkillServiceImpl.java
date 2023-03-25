package com.backend.ernesto.service;

import com.backend.ernesto.model.Skill;
import com.backend.ernesto.repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService{
    
    @Autowired
    public ISkillRepository skillRepo;

    @Override
    public List<Skill> listarSkill() {
        return  this.skillRepo.findAll();
    }

    @Override
    public Skill crearSkill(Skill skill) {
        return this.skillRepo.save(skill);
    }

    @Override
    public Skill actualizarSkill(Skill skill) {
        return this.skillRepo.save(skill);
    }

    @Override
    public Optional<Skill> buscarSkill(Long id) {
        return this.skillRepo.findById(id);
    }

    @Override
    public void eliminarSkill(Long id) {
        this.skillRepo.deleteById(id);
    }
    

    
}
