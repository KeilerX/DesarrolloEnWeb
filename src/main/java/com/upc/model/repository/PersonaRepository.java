package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Persona;

@Repository
public interface PersonaRepository 
 	extends JpaRepository<Persona, Integer>{

}