package com.test.babel.siniestro.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.babel.siniestro.dao.PersonaDao;
import com.test.babel.siniestro.entity.Persona;
import com.test.babel.siniestro.service.PersonaService;

@Service
public class PersonaServiceImp implements PersonaService {

	Logger logger = LoggerFactory.getLogger(PersonaServiceImp.class);

	@Autowired
	private PersonaDao personaDao;

	@Override
	public List<Persona> getAllPersonas() {
		logger.info("getAllPersonas");
		return personaDao.findAll();
	}

	@Override
	public List<Persona> findByRfc(String rfc) {
		logger.info("findByRfc");
		return personaDao.findByRfc(rfc);
	}

	@Override
	public Optional<Persona> findPersonaById(Long idPersona) {
		logger.info("findPersonaById");
		return personaDao.findById(idPersona);
	}

	@Override
	public void deletePersona(Long idPersona) {
		logger.info("deletePersona");
		var per = personaDao.findById(idPersona);
		if (!per.isEmpty())
			personaDao.delete(per.get());
	}

	@Override
	public Persona savePersona(Persona persona) {
		logger.info("savePersona");
		return personaDao.save(persona);
	}

}
