package com.test.babel.siniestro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.babel.siniestro.entity.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{
	
	List<Persona> findByRfc(String rfc);
}
