package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Trabajo;
import com.upc.model.repository.TrabajoRepository;
import com.upc.service.TrabajoService;

@Service
public class TrabajoServiceImpl implements TrabajoService{

	@Autowired
	private TrabajoRepository dao;
	
	@Override
	public Trabajo registrar(Trabajo t) {
		return dao.save(t);
	}

	@Override
	public Trabajo modificar(Trabajo t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Trabajo> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Trabajo> listar() {
		return dao.findAll();
	}

}
