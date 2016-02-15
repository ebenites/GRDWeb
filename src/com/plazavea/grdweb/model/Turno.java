package com.plazavea.grdweb.model;

public class Turno {

	private Integer id;
	
	private String nombre;
	
	private String horainicio;
	
	private String horafin;

	private String descripcion;
	
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

	public String getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getDescripcion(){
		this.descripcion = this.nombre + " [" + this.horainicio + "-" + this.horafin + "]";
		return this.descripcion;
	}
	
	@Override
	public String toString() {
		return "Turno [id=" + id + ", nombre=" + nombre + ", horainicio="
				+ horainicio + ", horafin=" + horafin + "]";
	}
	
}
