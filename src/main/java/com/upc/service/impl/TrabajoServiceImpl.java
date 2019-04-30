package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upc.dto.TrabajoAreaDTO;
import com.upc.model.entities.Trabajo;
import com.upc.model.repository.TrabajoAreaRepository;
import com.upc.model.repository.TrabajoRepository;
import com.upc.service.TrabajoService;

@Service
public class TrabajoServiceImpl implements TrabajoService{

	@Autowired
	private TrabajoRepository dao;
	
	@Autowired
	private TrabajoAreaRepository trabajoareaRepository;
	
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
	
	@Transactional
	@Override
	public Trabajo registrar(TrabajoAreaDTO trabajoDTO) {
		dao.save(trabajoDTO.getTrabajo());
		trabajoDTO.getLstArea()
					.forEach(area->
					trabajoareaRepository.registrar
						(trabajoDTO.getTrabajo().getId(), 
								area.getId()));
		
		return trabajoDTO.getTrabajo();
	}

}
