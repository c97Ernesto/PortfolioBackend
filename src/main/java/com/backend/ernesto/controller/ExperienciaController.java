package com.backend.ernesto.controller;

import com.backend.ernesto.model.Experiencia;
import com.backend.ernesto.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired
    public ExperienciaService expService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> listarExperiencias() {
        List<Experiencia> experiencias = this.expService.listarExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestBody Experiencia exp) {
        Experiencia newExp = this.expService.crearExperiencia(exp);
        return new ResponseEntity<>(newExp, HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<Experiencia> actualizarExperiencia(@RequestBody Experiencia exp) {
        Experiencia experiencia = this.expService.actualizarExperiencia(exp);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id) {
        this.expService.eliminarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
