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
import com.upc.model.entities.Perfil;
import com.upc.service.PerfilService;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	@GetMapping
	public ResponseEntity<List<Perfil>> listar() {
		List<Perfil> perfiles = new ArrayList<>();
		perfiles = perfilService.listar();
		return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Perfil> listarId(@PathVariable("id") Integer id) {
		Optional<Perfil> perfil = perfilService.listId(id);
		if (!perfil.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Perfil> registrar(@Valid @RequestBody Perfil usuario) {
		Perfil per = new Perfil();
		per = perfilService.registrar(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Perfil> actualizar(@Valid @RequestBody Perfil perfil){
		perfilService.modificar(perfil);
		return new ResponseEntity<Perfil>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Perfil> perfil = perfilService.listId(id);
		if (!perfil.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			perfilService.eliminar(id);
		}
	}

}
