package com.backend.ernesto.service;

import com.backend.ernesto.model.Educacion;
import com.backend.ernesto.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public IEducacionRepository educacionRepo;

    @Override
    public List<Educacion> listarEducacion() {
        return this.educacionRepo.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educacion) {
        return this.educacionRepo.save(educacion);
    }

    @Override
    public Educacion actualizarEducacion(Educacion educacion) {
        return this.educacionRepo.save(educacion);
    }

    @Override
    public Optional<Educacion> buscarEducacion(Long id) {
        return this.educacionRepo.findById(id);
    }

    @Override
    public void eliminarEducacion(Long id) {
        this.educacionRepo.deleteById(id);
    }
    
}
