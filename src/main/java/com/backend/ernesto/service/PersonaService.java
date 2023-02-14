package com.backend.ernesto.service;

import com.backend.ernesto.repository.IPersonaRepository;
import com.portfolio.SpringBoot.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired //nos permite hace inyección de dependencias entre una clase y otra
    public IPersonaRepository personaRepo;

    @Override
    public List<Persona> listar() {
        return this.personaRepo.findAll(); //ejecuto método de JpaRepository
    }
    
    @Override
    public void crear(Persona persona) {
        this.personaRepo.save(persona); //ejecuto método de JpaRepository
    }

    @Override
    public void eliminar(Long id) {
        this.personaRepo.deleteById(id);
    }

    @Override
    public void modificar(Persona persona) {
        this.personaRepo.save(persona);
    }

    @Override
    public Optional<Persona> buscar(Long id) {
        return this.personaRepo.findById(id);
    }
    
}
