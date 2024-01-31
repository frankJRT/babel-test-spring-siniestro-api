package com.test.babel.siniestro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.babel.siniestro.entity.Poliza;

public interface PolizaDao extends JpaRepository<Poliza, Long>{

	@Query("from Poliza pol where pol.idPersona.idPersona = ?1")
	List<Poliza> findAllByIdPersona(Long idPersona);
}
