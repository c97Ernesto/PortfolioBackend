package com.backend.ernesto.controller;

import com.backend.ernesto.dto.EducacionDto;
import com.backend.ernesto.service.EducacionService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/educacion")
@CrossOrigin
public class EducacionController {
    
    private EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
            
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<EducacionDto>> listarEducacion() {
        List<EducacionDto> estudios = this.educacionService.listarEducacion();
        //Pasamos los empleados en el cuerpo, y además el código de estado http 200
        return new ResponseEntity<>(estudios, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/agregar")
    public ResponseEntity<EducacionDto> agregarEducacion(@Valid @RequestBody EducacionDto educacionDto) {
        EducacionDto newEdu = this.educacionService.crearEducacion(educacionDto);
        return new ResponseEntity<>(newEdu, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/actualizar/{id}") 
    public ResponseEntity<EducacionDto> actualizarEducacion(@PathVariable(name = "id") Long id, 
    		@Valid @RequestBody EducacionDto educacionDto) {
        EducacionDto newEdu = this.educacionService.actualizarEducacion(educacionDto, id);
        return new ResponseEntity<>(newEdu, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable Long id) {
        this.educacionService.eliminarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
