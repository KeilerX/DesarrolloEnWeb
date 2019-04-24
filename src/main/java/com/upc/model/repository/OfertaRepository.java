package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Oferta;

@Repository
public interface OfertaRepository 
 	extends JpaRepository<Oferta, Integer>{

}