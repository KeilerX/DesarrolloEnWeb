package com.upc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upc.exception.ModeloNotFoundException;
import com.upc.model.entities.Persona;
import com.upc.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> personas = new ArrayList<>();
		personas = personaService.listar();
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id) {
		Optional<Persona> persona = personaService.listId(id);
		if (!persona.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Persona>(persona.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona) {
		Persona per = new Persona();
		per = personaService.registrar(persona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> actualizar(@Valid @RequestBody Persona persona){
		personaService.modificar(persona);
		return new ResponseEntity<Persona>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Persona> persona = personaService.listId(id);
		if (!persona.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			personaService.eliminar(id);
		}
	}

}
