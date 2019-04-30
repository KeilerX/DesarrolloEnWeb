package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Contratador;

@Repository
public interface ContratadorRepository
 	extends JpaRepository<Contratador, Integer>{

}