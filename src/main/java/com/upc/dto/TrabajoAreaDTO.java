package com.upc.dto;

import java.util.List;

import com.upc.model.entities.Trabajo;
import com.upc.model.entities.Area;

public class TrabajoAreaDTO {
	
	private Trabajo trabajo;
	private List<Area> lstArea;
	
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	public List<Area> getLstArea() {
		return lstArea;
	}
	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}
}
