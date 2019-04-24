package com.upc.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TrabajoAreaPK.class)
@Table(name = "trabajo_areas")
public class TrabajoArea {
	
	@Id
	private Trabajo trabajo;
	
	@Id
	private Area area;

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
}
