package com.backend.ernesto.controller;

import com.backend.ernesto.service.IPersonaService;
import com.portfolio.SpringBoot.model.Persona;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    IPersonaService personaService;
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona persona) {
        this.personaService.crear(persona);
    }
    
    @GetMapping ("/list/persona")
    public List<Persona> listarPersonas() {
        return this.personaService.listar();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        this.personaService.eliminar(id);
    }
    
    @PutMapping ("/update/persona") 
    public void modificarPersona(@RequestBody Persona persona) {
        this.personaService.modificar(persona);
    }
    
}
