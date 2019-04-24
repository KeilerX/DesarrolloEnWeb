package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.model.entities.Usuario;
import com.upc.model.repository.UsuarioRepository;
import com.upc.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository dao;
	
	@Override
	public Usuario registrar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {		
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Usuario> listId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

}
