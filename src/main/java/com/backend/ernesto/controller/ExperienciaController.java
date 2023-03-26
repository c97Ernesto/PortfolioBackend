package com.backend.ernesto.controller;

import com.backend.ernesto.dto.ExperienciaDto;
import com.backend.ernesto.service.ExperienciaService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
    public ExperienciaService expService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<ExperienciaDto>> listarExperiencias() {
        List<ExperienciaDto> experiencias = this.expService.listarExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<ExperienciaDto> agregarExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        ExperienciaDto newExp = this.expService.crearExperiencia(experienciaDto);
        return new ResponseEntity<>(newExp, HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ExperienciaDto> actualizarExperiencia(@PathVariable(name = "id") Long id,
    		@Valid @RequestBody ExperienciaDto experienciaDto) {
        ExperienciaDto experiencia = this.expService.actualizarExperiencia(experienciaDto, id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id) {
        this.expService.eliminarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
