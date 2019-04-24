package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Oferta;
import com.upc.model.repository.OfertaRepository;
import com.upc.service.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService{

	@Autowired
	private OfertaRepository dao;
	
	@Override
	public Oferta registrar(Oferta t) {
		return dao.save(t);
	}

	@Override
	public Oferta modificar(Oferta t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Oferta> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Oferta> listar() {
		return dao.findAll();
	}

}
