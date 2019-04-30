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
import com.upc.model.entities.Portafolio;
import com.upc.service.PortafolioService;

@RestController
@RequestMapping("/portafolios")
public class PortafolioController {

	@Autowired
	private PortafolioService portafolioService;

	@GetMapping
	public ResponseEntity<List<Portafolio>> listar() {
		List<Portafolio> portafolios = new ArrayList<>();
		portafolios = portafolioService.listar();
		return new ResponseEntity<List<Portafolio>>(portafolios, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Portafolio> listarId(@PathVariable("id") Integer id) {
		Optional<Portafolio> portafolio = portafolioService.listId(id);
		if (!portafolio.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Portafolio>(portafolio.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Portafolio> registrar(@Valid @RequestBody Portafolio portafolio) {
		Portafolio per = new Portafolio();
		per = portafolioService.registrar(portafolio);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Portafolio> actualizar(@Valid @RequestBody Portafolio portafolio){
		portafolioService.modificar(portafolio);
		return new ResponseEntity<Portafolio>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Portafolio> portafolio = portafolioService.listId(id);
		if (!portafolio.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			portafolioService.eliminar(id);
		}
	}

}
