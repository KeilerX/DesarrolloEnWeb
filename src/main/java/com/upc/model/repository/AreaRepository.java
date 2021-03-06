package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.Area;

@Repository
public interface AreaRepository 
 	extends JpaRepository<Area, Integer>{

}
