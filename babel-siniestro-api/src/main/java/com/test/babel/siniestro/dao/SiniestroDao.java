package com.test.babel.siniestro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.babel.siniestro.entity.Siniestro;

public interface SiniestroDao extends JpaRepository<Siniestro, Long>{

	@Query("from Siniestro sin where sin.idPoliza.idPoliza = ?1")
	List<Siniestro> findAllByIdPoliza(Long idPoliza);
}
