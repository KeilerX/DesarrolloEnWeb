package com.upc.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ofertas")
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@Size(min = 15, max =1000, message = "la propuesta debe tener minimo 15 caracteres y maximo 1000")
	@Column(name = "propuesta", nullable = false, length = 1000)
	private String propuesta;
	
	@Column(name = "oferta", nullable = false)
	private Float oferta;
	
	@Column(name = "plazo", nullable = false)
	private Integer plazo;
	
	@ManyToOne
	@JoinColumn(name = "trabajo_id", nullable = false)
	private Trabajo trabajo;
	
	@ManyToOne
	@JoinColumn(name = "trabajador_id", nullable = false)
	private Trabajador trabajador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}

	public Float getOferta() {
		return oferta;
	}

	public void setOferta(Float oferta) {
		this.oferta = oferta;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
}
