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
import com.upc.model.entities.Rol;
import com.upc.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private RolService RolService;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> roles = new ArrayList<>();
		roles = RolService.listar();
		return new ResponseEntity<List<Rol>>(roles,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Rol> listarId(@PathVariable("id") Integer id) {
		Optional<Rol> rol = RolService.listId(id);
		if(!rol.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Rol>(rol.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> registrar(@Valid @RequestBody Rol Rol) {
		Rol r = new Rol();
		r = RolService.registrar(Rol);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(r.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Rol> actualizar(@Valid @RequestBody Rol rol){
		RolService.modificar(rol);
		return new ResponseEntity<Rol>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Rol> rol = RolService.listId(id);
		if (!rol.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			RolService.eliminar(id);
		}
	}
}
