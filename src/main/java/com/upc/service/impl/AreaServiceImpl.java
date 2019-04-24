package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Area;
import com.upc.model.repository.AreaRepository;
import com.upc.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository dao;
	
	@Override
	public Area registrar(Area t) {
		return dao.save(t);
	}

	@Override
	public Area modificar(Area t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Area> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Area> listar() {
		return dao.findAll();
	}

}
