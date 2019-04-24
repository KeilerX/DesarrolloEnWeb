package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Perfil;

@Repository
public interface PerfilRepository 
 	extends JpaRepository<Perfil, Integer>{

}