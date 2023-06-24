package com.backend.ernesto.service;

import java.util.List;

import com.backend.ernesto.dto.RedSocialDto;



public interface RedSocialService {
	
	public List<RedSocialDto> listar();
	
	public RedSocialDto crearRedSocial(RedSocialDto redSocial);
	
	public RedSocialDto actualizarRedSocial(RedSocialDto redSocial, Long id);
	
	public void eliminarRedSocial(Long id);
	
	public RedSocialDto obtenerRedSocial(Long id);
}
