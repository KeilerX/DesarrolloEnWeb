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
	
	@ManyToOne
	@JoinColumn(name = "perfil_id", nullable = false)
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "trabajo_id", nullable = false)
	private Trabajo trabajo_id;

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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Trabajo getTrabajo_id() {
		return trabajo_id;
	}

	public void setTrabajo_id(Trabajo trabajo_id) {
		this.trabajo_id = trabajo_id;
	}
	
}
