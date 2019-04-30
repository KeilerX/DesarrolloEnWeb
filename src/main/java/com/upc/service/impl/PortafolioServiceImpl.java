package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Portafolio;
import com.upc.model.repository.PortafolioRepository;
import com.upc.service.PortafolioService;

@Service
public class PortafolioServiceImpl implements PortafolioService{

	@Autowired
	private PortafolioRepository dao;
	
	@Override
	public Portafolio registrar(Portafolio t) {
		return dao.save(t);
	}

	@Override
	public Portafolio modificar(Portafolio t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Portafolio> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Portafolio> listar() {
		return dao.findAll();
	}

}
