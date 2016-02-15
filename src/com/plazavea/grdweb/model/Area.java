package com.plazavea.grdweb.model;

public class Area {

	private Integer id;
	
	private String nombre;
	
	private String tipo;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
}
