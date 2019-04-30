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
import com.upc.model.entities.Contratador;
import com.upc.service.ContratadorService;

@RestController
@RequestMapping("/contratadores")
public class ContratadorController {

	@Autowired
	private ContratadorService contratadorService;

	@GetMapping
	public ResponseEntity<List<Contratador>> listar() {
		List<Contratador> contratadores = new ArrayList<>();
		contratadores = contratadorService.listar();
		return new ResponseEntity<List<Contratador>>(contratadores, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contratador> listarId(@PathVariable("id") Integer id) {
		Optional<Contratador> contratador = contratadorService.listId(id);
		if (!contratador.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Contratador>(contratador.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Contratador> registrar(@Valid @RequestBody Contratador contratador) {
		Contratador tra = new Contratador();
		tra = contratadorService.registrar(contratador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tra.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Contratador> actualizar(@Valid @RequestBody Contratador contratador){
		contratadorService.modificar(contratador);
		return new ResponseEntity<Contratador>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Contratador> contratador = contratadorService.listId(id);
		if (!contratador.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			contratadorService.eliminar(id);
		}
	}

}
