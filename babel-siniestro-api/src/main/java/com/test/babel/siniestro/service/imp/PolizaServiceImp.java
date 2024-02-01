package com.test.babel.siniestro.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.babel.siniestro.dao.PersonaDao;
import com.test.babel.siniestro.dao.PolizaDao;
import com.test.babel.siniestro.entity.Persona;
import com.test.babel.siniestro.entity.Poliza;
import com.test.babel.siniestro.exceptions.ResourceNotFoundException;
import com.test.babel.siniestro.service.PolizaService;

@Service
public class PolizaServiceImp implements PolizaService {

	Logger logger = LoggerFactory.getLogger(PolizaServiceImp.class);

	@Autowired
	private PolizaDao polizaDao;

	@Autowired
	private PersonaDao personaDao;

	@Override
	public List<Poliza> findAllByIdPersona(Long idPersona) {
		logger.info("findAllByIdPersona");
		List<Poliza> polizas = polizaDao.findAllByIdPersona(idPersona);
		if (polizas.isEmpty())
			throw new ResourceNotFoundException();
		return polizas;
	}

	@Override
	public Poliza findPolizaById(Long idPoliza) {
		logger.info("findPolizaById");
		return polizaDao.findById(idPoliza).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public boolean deletePoliza(Long idPoliza) {
		logger.info("deletePoliza");
		var pol = polizaDao.findById(idPoliza);
		if (!pol.isEmpty()) {
			polizaDao.delete(pol.get());
			return true;
		}
		return false;
	}

	@Override
	public Poliza savePoliza(Poliza poliza) {
		logger.info("savePoliza");

		Optional<Persona> per = personaDao.findById(poliza.getIdPersona().getIdPersona());
		if (per.isEmpty())
			throw new ResourceNotFoundException();

		poliza.setIdPersona(per.get());
		return polizaDao.save(poliza);
	}

}
