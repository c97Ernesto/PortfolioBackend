package com.backend.ernesto.controller;

import com.backend.ernesto.service.IPersonaService;
import com.backend.ernesto.model.Persona;
import java.util.List;
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
@RequestMapping ("/persona")
public class PersonaController {
    
    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }
    
        
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<Persona>> listarPersonas() {
        List<Persona> personas = this.personaService.listarPersonas();
        //Pasamos los empleados en el cuerpo, y además el código de estado http 200
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
    
    
    @PostMapping ("/agregar")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona p) {
        Persona persona = this.personaService.crearPersona(p);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id) {
        this.personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/actualizar") 
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) {
        Persona p = this.personaService.actualizarPersona(persona);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    
}
