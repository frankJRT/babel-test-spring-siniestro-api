package com.test.babel.siniestro.service;

import java.util.List;

import com.test.babel.siniestro.entity.Poliza;

public interface PolizaService {
	
	List<Poliza> findAllByIdPersona(Long idPersona);

	Poliza findPolizaById(Long idPoliza);

	boolean deletePoliza(Long idPoliza);

	Poliza savePoliza(Poliza poliza);
}
