package com.test.babel.siniestro.service;

import java.util.List;

import com.test.babel.siniestro.entity.Siniestro;



public interface SiniestroService {
	
	List<Siniestro> findAllByIdPoliza(Long idPoliza);

	Siniestro findSiniestroById(Long idSiniestro);

	boolean deleteSiniesro(Long idSiniestro);

	Siniestro saveSiniestro(Siniestro siniestro);
	
	Siniestro updateSiniestro(Siniestro siniestro);
}
