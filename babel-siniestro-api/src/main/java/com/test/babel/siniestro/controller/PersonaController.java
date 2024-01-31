package com.test.babel.siniestro.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.babel.siniestro.entity.Persona;
import com.test.babel.siniestro.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	Logger logger = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private PersonaService personaService;

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<Persona>> findAllPersona() {
		return ResponseEntity.ok(personaService.getAllPersonas());
	}

	@GetMapping("/Rfc/{rfc}")
	public ResponseEntity<List<Persona>> getPersonas(@PathVariable String rfc) {
		return ResponseEntity.ok(personaService.findByRfc(rfc));
	}

	@GetMapping("/persona/{idPersona}")
	public ResponseEntity<Optional<Persona>> getPersonas(@PathVariable Long idPersona) {
		return ResponseEntity.ok(personaService.findPersonaById(idPersona));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
		return ResponseEntity.ok(personaService.savePersona(persona));
	}
	
//	@DeleteMapping
//	public ResponseEntity<Persona>
	
	
}
