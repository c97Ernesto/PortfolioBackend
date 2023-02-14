package com.backend.ernesto.repository;

import com.backend.ernesto.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducacionRepository extends JpaRepository<Educacion, Long>{
    
}
