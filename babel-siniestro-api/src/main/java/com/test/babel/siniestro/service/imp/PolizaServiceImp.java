package com.test.babel.siniestro.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.babel.siniestro.dao.PolizaDao;
import com.test.babel.siniestro.entity.Poliza;
import com.test.babel.siniestro.service.PolizaService;

@Service
public class PolizaServiceImp implements PolizaService {

	Logger logger = LoggerFactory.getLogger(PolizaServiceImp.class);
	@Autowired
	private PolizaDao polizaDao;

	@Override
	public List<Poliza> findAllByIdPersona(Long idPersona) {
		logger.info("findAllByIdPersona");
		return polizaDao.findAllByIdPersona(idPersona);
	}

	@Override
	public Optional<Poliza> findPolizaById(Long idPoliza) {
		logger.info("findPolizaById");
		return polizaDao.findById(idPoliza);
	}

	@Override
	public void deletePoliza(Long idPoliza) {
		logger.info("deletePoliza");
		var pol = polizaDao.findById(idPoliza);
		if (!pol.isEmpty())
			polizaDao.delete(pol.get());
	}

	@Override
	public Poliza savePoliza(Poliza poliza) {
		logger.info("savePoliza");
		return polizaDao.save(poliza);
	}

}
