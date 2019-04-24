package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Perfil;
import com.upc.model.repository.PerfilRepository;
import com.upc.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository dao;
	
	@Override
	public Perfil registrar(Perfil t) {
		return dao.save(t);
	}

	@Override
	public Perfil modificar(Perfil t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Perfil> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Perfil> listar() {
		return dao.findAll();
	}

}
