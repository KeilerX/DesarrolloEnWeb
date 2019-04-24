package com.upc.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TrabajoAreaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "trabajo_id", nullable = false)
	private Trabajo trabajo;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;
}
