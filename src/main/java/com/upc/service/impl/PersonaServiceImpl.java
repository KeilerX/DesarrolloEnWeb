package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Persona;
import com.upc.model.repository.PersonaRepository;
import com.upc.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository dao;
	
	@Override
	public Persona registrar(Persona t) {
		return dao.save(t);
	}

	@Override
	public Persona modificar(Persona t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Persona> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Persona> listar() {
		return dao.findAll();
	}

}
