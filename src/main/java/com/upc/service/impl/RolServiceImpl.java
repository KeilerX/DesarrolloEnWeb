package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Rol;
import com.upc.model.repository.RolRepository;
import com.upc.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository dao;
	
	@Override
	public Rol registrar(Rol t) {
		return dao.save(t);
	}

	@Override
	public Rol modificar(Rol t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Rol> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Rol> listar() {
		return dao.findAll();
	}

}
