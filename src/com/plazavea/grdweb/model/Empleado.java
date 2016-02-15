package com.plazavea.grdweb.model;

public class Empleado {

	private Integer id;
	
	private String nombres;
	
	private String apellidos;
	
	private String direccion;
	
	private String telefono;
	
	private String estado;
	
	private TiendaArea tiendaArea;

	private String nombreCompleto;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TiendaArea getTiendaArea() {
		return tiendaArea;
	}

	public void setTiendaArea(TiendaArea tiendaArea) {
		this.tiendaArea = tiendaArea;
	}

	public String getNombreCompleto(){
		this.nombreCompleto = this.nombres + " " + this.apellidos;
		return this.nombreCompleto;
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", telefono="
				+ telefono + ", estado=" + estado + ", tiendaArea="
				+ tiendaArea + "]";
	}
	
}
