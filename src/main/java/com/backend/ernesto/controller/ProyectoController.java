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

import com.backend.ernesto.dto.ProyectoDto;
import com.backend.ernesto.service.ProyectoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProyectoDto>> listarProyectos() {
		List<ProyectoDto> proyectos = this.proyectoService.listarProyectos();
		return new ResponseEntity<>(proyectos, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<ProyectoDto> agregarProyecto(@Valid @RequestBody ProyectoDto proyectoDto) {
		ProyectoDto proyecto = this.proyectoService.crearProyecto(proyectoDto);
		return new ResponseEntity<>(proyecto, HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<ProyectoDto> actualizarProyecto(@PathVariable Long id, 
			@Valid @RequestBody ProyectoDto proyectoDto) {
		ProyectoDto proyecto = this.proyectoService.actualizarProyecto(proyectoDto, id);
		return new ResponseEntity<ProyectoDto>(proyecto, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarProyecto(@PathVariable Long id) {
		this.proyectoService.eliminarProyecto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
