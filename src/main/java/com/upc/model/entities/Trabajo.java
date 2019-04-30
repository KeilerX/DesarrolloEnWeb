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
@Table(name = "trabajos")
public class Trabajo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@Size(min = 5, max = 50, message = "el asunto debe tener minimo 5 caracteres y maximo 50")
	@Column(name = "asunto", nullable = false, length = 50)
	private String asunto;
	
	@Size(min = 15, max =3000, message = "la descripción debe tener minimo 15 caracteres y maximo 3000")
	@Column(name = "descripcion", nullable = false, length = 3000)
	private String descripcion;

	@Column(name = "presupuesto", nullable = false)
	private Float presupuesto;
	
	@ManyToOne
	@JoinColumn(name = "contratador_id", nullable = false)
	private Contratador contratador;

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

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Contratador getContratador() {
		return contratador;
	}

	public void setContratador(Contratador contratador) {
		this.contratador = contratador;
	}
}
