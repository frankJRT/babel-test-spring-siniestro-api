package com.test.babel.siniestro.service;

import java.util.List;
import java.util.Optional;

import com.test.babel.siniestro.entity.Siniestro;



public interface SiniestroService {
	
	List<Siniestro> findAllByIdPoliza(Long idPoliza);

	Optional<Siniestro> findSiniestroById(Long idSiniestro);

	void deleteSiniesro(Long idSiniestro);

	Siniestro saveSiniestro(Siniestro siniestro);
}
