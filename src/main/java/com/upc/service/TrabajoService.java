package com.upc.service;

import com.upc.dto.TrabajoAreaDTO;
import com.upc.model.entities.Trabajo;

public interface TrabajoService extends CrudService<Trabajo> {
	
	Trabajo registrar(TrabajoAreaDTO trabajoareaDTO);
}

