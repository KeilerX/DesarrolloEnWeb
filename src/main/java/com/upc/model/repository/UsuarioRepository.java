package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Usuario;

@Repository
public interface UsuarioRepository 
 	extends JpaRepository<Usuario, Integer>{

}