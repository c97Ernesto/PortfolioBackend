package com.backend.ernesto.repository;

import com.backend.ernesto.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillRepository extends JpaRepository<Skill, Long>{
    
}
