package com.test.babel.siniestro.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.babel.siniestro.dao.SiniestroDao;
import com.test.babel.siniestro.entity.Siniestro;
import com.test.babel.siniestro.service.SiniestroService;

public class SiniestroServiceImp implements SiniestroService {

	Logger logger = LoggerFactory.getLogger(SiniestroServiceImp.class);

	@Autowired
	private SiniestroDao siniestroDao;

	@Override
	public List<Siniestro> findAllByIdPoliza(Long idPoliza) {
		logger.info("findAllByIdPoliza");
		return siniestroDao.findAllByIdPoliza(idPoliza);
	}

	@Override
	public Optional<Siniestro> findSiniestroById(Long idSiniestro) {
		logger.info("findSiniestroById");
		return siniestroDao.findById(idSiniestro);
	}

	@Override
	public void deleteSiniesro(Long idSiniestro) {
		logger.info("deleteSiniesro");
		var sin = siniestroDao.findById(idSiniestro);
		if (!sin.isEmpty())
			siniestroDao.delete(sin.get());
	}

	@Override
	public Siniestro saveSiniestro(Siniestro siniestro) {
		logger.info("saveSiniestro");
		return siniestroDao.save(siniestro);
	}

}
