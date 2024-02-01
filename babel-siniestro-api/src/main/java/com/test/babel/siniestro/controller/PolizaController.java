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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.babel.siniestro.entity.Poliza;
import com.test.babel.siniestro.service.PolizaService;

@RestController
@RequestMapping("/poliza")
public class PolizaController {
	Logger logger = LoggerFactory.getLogger(PolizaController.class);

	@Autowired
	private PolizaService polizaService;

	@GetMapping("/persona/{idPersona}")
	public ResponseEntity<List<Poliza>> getPolizaByPersonas(@PathVariable Long idPersona) {
		return ResponseEntity.ok(polizaService.findAllByIdPersona(idPersona));
	}

	@GetMapping("/id/{idPoliza}")
	public ResponseEntity<Poliza> getPoliza(@PathVariable Long idPoliza) {
		return ResponseEntity.ok(polizaService.findPolizaById(idPoliza));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Poliza> savePoliza(@RequestBody Poliza poliza){
		Poliza pol = polizaService.savePoliza(poliza);
		return ResponseEntity.status(HttpStatus.CREATED).body(pol);
	}
	
	@DeleteMapping("/delete/{idPoliza}")
	public ResponseEntity<Boolean> deletePoliza(@PathVariable Long idPoliza){
		boolean delted = polizaService.deletePoliza(idPoliza);
		return ResponseEntity.ok(delted);
	}

}
