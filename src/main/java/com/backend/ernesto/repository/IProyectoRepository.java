package com.backend.ernesto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ernesto.model.Proyecto;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{

}
