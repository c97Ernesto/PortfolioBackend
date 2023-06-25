package com.backend.ernesto.controller;

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

import com.backend.ernesto.dto.RedSocialDto;
import com.backend.ernesto.service.RedSocialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/redSocial")
@CrossOrigin
public class RedSocialController {
	
	
    private final RedSocialService redSocialService;

    public RedSocialController(RedSocialService redSocialService) {
        this.redSocialService = redSocialService;
    }
    
        
    @GetMapping ("/listar")
    /*Devolvemos una respuesta http, y en el cuerpo de esa respuesta http, una lista.*/
    public ResponseEntity<List<RedSocialDto>> listarRedSocials() {
        List<RedSocialDto> redesSociales = this.redSocialService.listar();
        return new ResponseEntity<>(redesSociales, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RedSocialDto> obternerPorId(@PathVariable("id") Long id) {
    	return new ResponseEntity<>(this.redSocialService.obtenerRedSocial(id), HttpStatus.OK);
    	
    }
    
    @PostMapping ("/agregar")
    public ResponseEntity<RedSocialDto> agregarRedSocial(@Valid @RequestBody RedSocialDto red) {
    	RedSocialDto redSocialDto = this.redSocialService.crearRedSocial(red);
        return new ResponseEntity<>(redSocialDto, HttpStatus.CREATED);
    }
    
    
    @PutMapping ("/actualizar/{id}") 
    public ResponseEntity<RedSocialDto> actualizarRedSocial(@PathVariable(name = "id") Long id,
    		@Valid @RequestBody RedSocialDto redSocialDto) {
    	RedSocialDto red = this.redSocialService.actualizarRedSocial(redSocialDto, id);
        return new ResponseEntity<>(red, HttpStatus.OK);
    }
    
    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity<?> eliminarRedSocial(@PathVariable Long id) {
        this.redSocialService.eliminarRedSocial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
