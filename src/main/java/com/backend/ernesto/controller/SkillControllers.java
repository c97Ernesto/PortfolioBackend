package com.backend.ernesto.controller;

import com.backend.ernesto.model.Skill;
import com.backend.ernesto.service.ISkillService;
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
@RequestMapping("/skill")
public class SkillControllers {
    
    @Autowired
    public ISkillService skillService;
    
        
    @GetMapping ("/listar-skills")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<Skill>> listarSkills() {
        List<Skill> skills = this.skillService.listarSkill();
        //Pasamos los empleados en el cuerpo, y además el código de estado http 200
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @PostMapping ("/agregar-skill")
    public ResponseEntity<Skill> agregarSkill(@RequestBody Skill s) {
        Skill persona = this.skillService.crearSkill(s);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/eliminar-skill/{id}")
    public ResponseEntity<?> eliminarSkill(@PathVariable Long id) {
        this.skillService.eliminarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/actualizar-skill") 
    public ResponseEntity<Skill> actualizarSkill(@RequestBody Skill skill) {
        Skill s = this.skillService.actualizarSkill(skill);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
