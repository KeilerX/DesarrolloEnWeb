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
import com.upc.model.entities.Trabajador;
import com.upc.service.TrabajadorService;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	private TrabajadorService trabajadorService;

	@GetMapping
	public ResponseEntity<List<Trabajador>> listar() {
		List<Trabajador> trabajadores = new ArrayList<>();
		trabajadores = trabajadorService.listar();
		return new ResponseEntity<List<Trabajador>>(trabajadores, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabajador> listarId(@PathVariable("id") Integer id) {
		Optional<Trabajador> trabajador = trabajadorService.listId(id);
		if (!trabajador.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Trabajador>(trabajador.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Trabajador> registrar(@Valid @RequestBody Trabajador trabajador) {
		Trabajador tra = new Trabajador();
		tra = trabajadorService.registrar(trabajador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tra.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Trabajador> actualizar(@Valid @RequestBody Trabajador trabajador){
		trabajadorService.modificar(trabajador);
		return new ResponseEntity<Trabajador>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Trabajador> trabajador = trabajadorService.listId(id);
		if (!trabajador.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			trabajadorService.eliminar(id);
		}
	}

}
