package com.upc.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "perfiles")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombres")
	private String nombre;

	@Column(name = "apellidos")
	private String apellido;

	@Column(name = "sexo")
	private Boolean sexo;

	@Column(name = "ultima_conexion")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime ultimaConexion;

	@Column(name = "fecha_nacimiento")
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaNacimiento;

	@Size(min = 8, message = "Dirección debe tener minimo 8 caracteres")
	@Column(name = "direccion", nullable = false, length = 300)
	private String direccion;

	@Size(min = 7, message = "Telefono debe tener minimo 7 caracteres")
	@Column(name = "telefono", nullable = false, length = 20)
	private String telefono;

	@Size(min = 8, message = "Correo debe tener minimo 8 caracteres")
	@Column(name = "correo", nullable = false, length = 200)
	private String correo;

	@Column(name = "calificacion")
	private Integer calificacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(LocalDateTime ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
