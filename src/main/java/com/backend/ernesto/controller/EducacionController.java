package com.backend.ernesto.controller;

import com.backend.ernesto.model.Educacion;
import com.backend.ernesto.service.IEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    private final IEducacionService educacionService;

    public EducacionController(IEducacionService educacionService) {
        this.educacionService = educacionService;
    }
    
        
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<Educacion>> listarEducacion() {
        List<Educacion> lista = this.educacionService.listarEducacion();
        //Pasamos los empleados en el cuerpo, y además el código de estado http 200
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @PostMapping ("/agregar")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion edu) {
        Educacion newEdu = this.educacionService.crearEducacion(edu);
        return new ResponseEntity<>(newEdu, HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable Long id) {
        this.educacionService.eliminarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/actualizar") 
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody Educacion edu) {
        Educacion newEdu = this.educacionService.actualizarEducacion(edu);
        return new ResponseEntity<>(newEdu, HttpStatus.OK);
    }
}
