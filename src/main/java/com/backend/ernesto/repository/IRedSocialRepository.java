package com.backend.ernesto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ernesto.model.RedSocial;

@Repository
public interface IRedSocialRepository extends JpaRepository<RedSocial, Long>{
	
}
