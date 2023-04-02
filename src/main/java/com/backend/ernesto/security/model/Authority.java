package com.backend.ernesto.security.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}

	//Obtenemos rol
	@Override
	public String getAuthority() {
		return this.authority;
	}
	
}
