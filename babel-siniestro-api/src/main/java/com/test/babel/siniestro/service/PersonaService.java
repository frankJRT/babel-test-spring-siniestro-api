package com.test.babel.siniestro.service;

import java.util.List;
import java.util.Optional;

import com.test.babel.siniestro.entity.Persona;

public interface PersonaService {
	
	List<Persona> getAllPersonas();

	List<Persona> findByRfc(String rfc);
	
	Optional<Persona> findPersonaById(Long idPersona);

	void deletePersona(Long idPersona);

	Persona savePersona(Persona persona);
}
