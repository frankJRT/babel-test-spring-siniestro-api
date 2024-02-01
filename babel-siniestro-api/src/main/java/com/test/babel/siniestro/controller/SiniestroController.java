package com.test.babel.siniestro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.babel.siniestro.entity.Siniestro;
import com.test.babel.siniestro.service.SiniestroService;

@RestController
@RequestMapping("siniestro")
public class SiniestroController {

	Logger logger = LoggerFactory.getLogger(SiniestroController.class);

	@Autowired
	private SiniestroService siniestroService;

	@GetMapping("/poliza/{idPoliza}")
	public ResponseEntity<List<Siniestro>> getSiniestroByPoliza(@PathVariable Long idPoliza) {
		return ResponseEntity.ok(siniestroService.findAllByIdPoliza(idPoliza));
	}

	@GetMapping("/id/{idSiniestro}")
	public ResponseEntity<Siniestro> getSiniestroById(@PathVariable Long idSiniestro) {
		return ResponseEntity.ok(siniestroService.findSiniestroById(idSiniestro));
	}

	@PostMapping("/save")
	public ResponseEntity<Siniestro> saveSiniestro(@RequestBody Siniestro siniestro) {
		Siniestro sin = siniestroService.saveSiniestro(siniestro);
		return ResponseEntity.status(HttpStatus.CREATED).body(sin);
	}

	@PutMapping("/save")
	public ResponseEntity<Siniestro> updateSiniestro(@RequestBody Siniestro siniestro) {
		Siniestro sin = siniestroService.updateSiniestro(siniestro);
		return ResponseEntity.status(HttpStatus.CREATED).body(sin);
	}

	@DeleteMapping("/delete/{idSiniestro}")
	public ResponseEntity<Boolean> deleteSiniestro(@PathVariable Long idSiniestro) {
		boolean delt = siniestroService.deleteSiniesro(idSiniestro);
		return ResponseEntity.ok(delt);
	}

}
