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
import com.upc.model.entities.Oferta;
import com.upc.service.OfertaService;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {

	@Autowired
	private OfertaService ofertaService;

	@GetMapping
	public ResponseEntity<List<Oferta>> listar() {
		List<Oferta> ofertas = new ArrayList<>();
		ofertas = ofertaService.listar();
		return new ResponseEntity<List<Oferta>>(ofertas, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Oferta> listarId(@PathVariable("id") Integer id) {
		Optional<Oferta> oferta = ofertaService.listId(id);
		if (!oferta.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Oferta>(oferta.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Oferta> registrar(@Valid @RequestBody Oferta oferta) {
		Oferta ofe = new Oferta();
		ofe = ofertaService.registrar(oferta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ofe.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Oferta> actualizar(@Valid @RequestBody Oferta oferta){
		ofertaService.modificar(oferta);
		return new ResponseEntity<Oferta>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Oferta> oferta = ofertaService.listId(id);
		if (!oferta.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			ofertaService.eliminar(id);
		}
	}
}
