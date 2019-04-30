package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Trabajador;

@Repository
public interface TrabajadorRepository 
 	extends JpaRepository<Trabajador, Integer>{

}