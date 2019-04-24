package com.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upc.model.entities.TrabajoArea;

@Repository
public interface TrabajoAreaRepository
	extends JpaRepository<TrabajoArea, Integer>{
	//Transaction 
	@Modifying
	//DML:insert, update o delete
	@Query(value="INSERT INTO trabajo_areas(trabajo_id,area_id) "
			+ "VALUES(:trabajoId,:areaId) ",nativeQuery=true)
	Integer registrar (@Param("trabajoId") Integer trabajoId,
	@Param("areaId") Integer areaId);
}
