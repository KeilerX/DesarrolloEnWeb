package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Trabajador;
import com.upc.model.repository.TrabajadorRepository;
import com.upc.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService{

	@Autowired
	private TrabajadorRepository dao;
	
	@Override
	public Trabajador registrar(Trabajador t) {
		return dao.save(t);
	}

	@Override
	public Trabajador modificar(Trabajador t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Trabajador> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Trabajador> listar() {
		return dao.findAll();
	}

}
