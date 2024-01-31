package com.test.babel.siniestro.service;

import java.util.List;
import java.util.Optional;

import com.test.babel.siniestro.entity.Poliza;

public interface PolizaService {
	
	List<Poliza> findAllByIdPersona(Long idPersona);

	Optional<Poliza> findPolizaById(Long idPoliza);

	void deletePoliza(Long idPoliza);

	Poliza savePoliza(Poliza poliza);
}
