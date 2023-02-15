package com.backend.ernesto.service;

import com.backend.ernesto.model.Experiencia;
import com.backend.ernesto.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public IExperienciaRepository expRepo;

    @Override
    public List<Experiencia> listarExperiencia() {
        return this.expRepo.findAll();
    }

    @Override
    public Experiencia crearExperiencia(Experiencia experiencia) {
        return this.expRepo.save(experiencia);
    }

    @Override
    public Experiencia actualizarExperiencia(Experiencia experiencia) {
        return this.expRepo.save(experiencia);
    }

    @Override
    public Optional<Experiencia> buscarExperiencia(Long id) {
        return this.expRepo.findById(id);
    }

    @Override
    public void eliminarExperiencia(Long id) {
        this.expRepo.deleteById(id);
    }
    
}
