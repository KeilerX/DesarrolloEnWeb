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

import com.upc.dto.TrabajoAreaDTO;
import com.upc.exception.ModeloNotFoundException;
import com.upc.model.entities.Trabajo;
import com.upc.service.TrabajoService;

@RestController
@RequestMapping("/trabajos")
public class TrabajoController {

	@Autowired
	private TrabajoService trabajoService;

	@GetMapping
	public ResponseEntity<List<Trabajo>> listar() {
		List<Trabajo> trabajos = new ArrayList<>();
		trabajos = trabajoService.listar();
		return new ResponseEntity<List<Trabajo>>(trabajos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Trabajo> listarId(@PathVariable("id") Integer id) {
		Optional<Trabajo> trabajo = trabajoService.listId(id);
		if (!trabajo.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Trabajo>(trabajo.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Trabajo> registrar(@Valid @RequestBody TrabajoAreaDTO trabajo) {
		Trabajo tra = new Trabajo();
		tra = trabajoService.registrar(trabajo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tra.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Trabajo> actualizar(@Valid @RequestBody Trabajo trabajo){
		trabajoService.modificar(trabajo);
		return new ResponseEntity<Trabajo>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Trabajo> trabajo = trabajoService.listId(id);
		if (!trabajo.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			trabajoService.eliminar(id);
		}
	}
}
