package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Trabajo;

@Repository
public interface TrabajoRepository 
 	extends JpaRepository<Trabajo, Integer>{

}