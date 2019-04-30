package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Contratador;
import com.upc.model.repository.ContratadorRepository;
import com.upc.service.ContratadorService;

@Service
public class ContratadorServiceImpl implements ContratadorService{

	@Autowired
	private ContratadorRepository dao;
	
	@Override
	public Contratador registrar(Contratador t) {
		return dao.save(t);
	}

	@Override
	public Contratador modificar(Contratador t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Contratador> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Contratador> listar() {
		return dao.findAll();
	}

}
