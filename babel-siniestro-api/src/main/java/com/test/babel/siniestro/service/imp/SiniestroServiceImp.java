package com.test.babel.siniestro.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.babel.siniestro.dao.PolizaDao;
import com.test.babel.siniestro.dao.SiniestroDao;
import com.test.babel.siniestro.entity.Poliza;
import com.test.babel.siniestro.entity.Siniestro;
import com.test.babel.siniestro.exceptions.ResourceNotFoundException;
import com.test.babel.siniestro.service.SiniestroService;

@Service
public class SiniestroServiceImp implements SiniestroService {

	Logger logger = LoggerFactory.getLogger(SiniestroServiceImp.class);

	@Autowired
	private SiniestroDao siniestroDao;

	@Autowired
	private PolizaDao polizaDao;

	@Override
	public List<Siniestro> findAllByIdPoliza(Long idPoliza) {
		logger.info("findAllByIdPoliza");
		List<Siniestro> siniestros = siniestroDao.findAllByIdPoliza(idPoliza);
		if (siniestros.isEmpty())
			throw new ResourceNotFoundException();
		return siniestros;
	}

	@Override
	public Siniestro findSiniestroById(Long idSiniestro) {
		logger.info("findSiniestroById");
		return siniestroDao.findById(idSiniestro).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public boolean deleteSiniesro(Long idSiniestro) {
		logger.info("deleteSiniesro");
		var sin = siniestroDao.findById(idSiniestro);
		if (!sin.isEmpty()) {
			siniestroDao.delete(sin.get());
			return true;
		}
		return false;
	}

	@Override
	public Siniestro saveSiniestro(Siniestro siniestro) {
		logger.info("saveSiniestro");
		Optional<Poliza> pol = polizaDao.findById(siniestro.getIdPoliza().getIdPoliza());
		if (pol.isEmpty())
			throw new ResourceNotFoundException();
		siniestro.setIdPoliza(pol.get());
		siniestro.setFechaHoraSiniestro(new Date());
		return siniestroDao.save(siniestro);
	}

	@Override
	public Siniestro updateSiniestro(Siniestro siniestro) {

		var stro = siniestroDao.findById(siniestro.getIdSiniestro()).map(sin -> {
			sin.setAsistenciaMedica(siniestro.getAsistenciaMedica());
			sin.setAsistenciaVial(siniestro.getAsistenciaVial());
			sin.setConductor(siniestro.getConductor());
			sin.setDireccion(siniestro.getDireccion());
			//sin.setFechaHoraSiniestro(siniestro.getFechaHoraSiniestro());
			sin.setMarca(siniestro.getMarca());
			sin.setModelo(siniestro.getModelo());
			sin.setPlaca(siniestro.getPlaca());
			return sin;
		}).orElseThrow(() -> new ResourceNotFoundException());
		
		return siniestroDao.save(stro);
	}

}
