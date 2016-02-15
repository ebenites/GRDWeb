package com.plazavea.grdweb.model;

public class TiendaArea {

	private Tienda tienda;
	
	private Area area;

	private Integer capacidad;
	
	public TiendaArea(Tienda tienda, Area area) {
		super();
		this.tienda = tienda;
		this.area = area;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "TiendaArea [tienda=" + tienda + ", area=" + area
				+ ", capacidad=" + capacidad + "]";
	}
	
}
