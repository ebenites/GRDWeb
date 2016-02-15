package com.plazavea.grdweb.model;

public class Campana{

	private Integer id;
	
	private String nombre;
	
	private String fechainicio;
	
	private String fechafin;
	
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Campana [id=" + id + ", nombre=" + nombre + ", fechainicio="
				+ fechainicio + ", fechafin=" + fechafin + ", estado=" + estado
				+ "]";
	}
	
}
