package com.backend.ernesto.service;

import com.backend.ernesto.repository.IPersonaRepository;
import com.backend.ernesto.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired //nos permite hace inyección de dependencias entre una clase y otra
    public IPersonaRepository personaRepo;

    @Override
    public List<Persona> listarPersonas() {
        return this.personaRepo.findAll(); //ejecuto método de JpaRepository
    }
    
    @Override
    public Persona crearPersona(Persona persona) {
        return this.personaRepo.save(persona); //ejecuto método de JpaRepository
    }
    
    @Override
    public Persona actualizarPersona(Persona persona) {
        return this.personaRepo.save(persona);
    }

    @Override
    public Optional<Persona> buscarPersona(Long id) {
        return this.personaRepo.findById(id);
    }
    
    @Override
    public void eliminarPersona(Long id) {
        this.personaRepo.deleteById(id);
    }
    
}
