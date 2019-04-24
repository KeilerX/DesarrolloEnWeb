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
import com.upc.model.entities.Area;
import com.upc.service.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@GetMapping
	public ResponseEntity<List<Area>> listar() {
		List<Area> areas = new ArrayList<>();
		areas = areaService.listar();
		return new ResponseEntity<List<Area>>(areas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> listarId(@PathVariable("id") Integer id) {
		Optional<Area> area = areaService.listId(id);
		if(!area.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Area>(area.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Area> registrar(@Valid @RequestBody Area area) {
		Area are = new Area();
		are = areaService.registrar(area);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(are.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Area> actualizar(@Valid @RequestBody Area area){
		areaService.modificar(area);
		return new ResponseEntity<Area>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Area> area = areaService.listId(id);
		if (!area.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			areaService.eliminar(id);
		}
	}
}
