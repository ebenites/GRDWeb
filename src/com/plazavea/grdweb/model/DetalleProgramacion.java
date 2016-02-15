package com.plazavea.grdweb.model;

public class DetalleProgramacion {

	private Programacion programacion;
	
	private Integer item;
	
	private TiendaArea area;
	
	private Personal personal;
	
	private Turno turno;
	
	private Caja caja;
	
	private String fechaAsignacion;

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Programacion getProgramacion() {
		return programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

	public TiendaArea getArea() {
		return area;
	}

	public void setArea(TiendaArea area) {
		this.area = area;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	@Override
	public String toString() {
		return "DetalleProgramacion [item=" + item + ", programacion="
				+ programacion + ", area=" + area + ", personal=" + personal
				+ ", turno=" + turno + ", caja=" + caja + ", fechaAsignacion="
				+ fechaAsignacion + "]";
	}
	
}
