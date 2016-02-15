package com.plazavea.grdweb.model;

public class Personal extends Empleado {

	private Campana campana;

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}
	
	@Override
	public String toString() {
		return "Personal [campana=" + campana + ", getId()=" + getId()
				+ ", getNombres()=" + getNombres() + ", getApellidos()="
				+ getApellidos() + ", getDireccion()=" + getDireccion()
				+ ", getTelefono()=" + getTelefono() + ", getEstado()="
				+ getEstado() + ", getTienda_area()=" + getTiendaArea() + "]";
	}
	
}
