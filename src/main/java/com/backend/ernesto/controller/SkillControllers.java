package com.backend.ernesto.controller;

import com.backend.ernesto.dto.SkillDto;
import com.backend.ernesto.service.SkillService;

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
@RequestMapping("/skill")
@CrossOrigin
public class SkillControllers {
    
    @Autowired
    public SkillService skillService;
    
        
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<SkillDto>> listarSkills() {
        List<SkillDto> skills = this.skillService.listarSkill();
        //Pasamos los empleados en el cuerpo, y además el código de estado http 200
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @PostMapping ("/agregar")
    public ResponseEntity<SkillDto> agregarSkill(@Valid @RequestBody SkillDto s) {
        SkillDto persona = this.skillService.crearSkill(s);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }
    
    @PutMapping ("/actualizar/{id}") 
    public ResponseEntity<SkillDto> actualizarSkill(@PathVariable(name = "id") Long id, 
    		@Valid @RequestBody SkillDto skill) {
        SkillDto s = this.skillService.actualizarSkill(skill, id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarSkill(@PathVariable Long id) {
        this.skillService.eliminarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
