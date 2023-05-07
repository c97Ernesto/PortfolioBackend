package com.backend.ernesto.controller;

import com.backend.ernesto.dto.PersonaDto;
import com.backend.ernesto.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;
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
@RequestMapping ("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
        
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<PersonaDto>> listarPersonas() {
        List<PersonaDto> personas = this.personaService.listarPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> obternerPorId(@PathVariable("id") Long id) {
    	return new ResponseEntity<>(this.personaService.obtenerPersonaPorId(id), HttpStatus.OK);
    	
    }
    
    @PostMapping ("/agregar")
    public ResponseEntity<PersonaDto> agregarPersona(@Valid @RequestBody PersonaDto p) {
    	PersonaDto personaDto = this.personaService.crearPersona(p);
        return new ResponseEntity<>(personaDto, HttpStatus.CREATED);
    }
    
    
    @PutMapping ("/actualizar/{id}") 
    public ResponseEntity<PersonaDto> actualizarPersona(@PathVariable(name = "id") Long id,
    		@Valid @RequestBody PersonaDto personaDto) {
    	PersonaDto p = this.personaService.actualizarPersona(personaDto, id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long id) {
        this.personaService.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada correctamente",HttpStatus.OK);
    }

    
}
