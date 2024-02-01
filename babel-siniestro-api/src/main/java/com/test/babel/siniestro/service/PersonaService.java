package com.test.babel.siniestro.service;

import java.util.List;

import com.test.babel.siniestro.entity.Persona;

public interface PersonaService {
	
	List<Persona> getAllPersonas();

	List<Persona> findByRfc(String rfc);
	
	Persona findPersonaById(Long idPersona);

	boolean deletePersona(Long idPersona);

	Persona savePersona(Persona persona);
}
