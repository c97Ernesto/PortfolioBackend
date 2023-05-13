package com.backend.ernesto.service;

import java.util.List;

import com.backend.ernesto.dto.ProyectoDto;

public interface ProyectoService {
	
	public List<ProyectoDto> listarProyectos();
	
	public ProyectoDto crearProyecto(ProyectoDto proyecto);
	
	public ProyectoDto actualizarProyecto(ProyectoDto proyecto, Long id);
	
//  public Optional<ProyectoDto> buscarProyecto(Long id);
	
	public void eliminarProyecto(Long id);

}
