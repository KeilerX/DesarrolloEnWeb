package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Portafolio;

@Repository
public interface PortafolioRepository
 	extends JpaRepository<Portafolio, Integer>{

}