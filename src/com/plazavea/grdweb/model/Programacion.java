package com.plazavea.grdweb.model;

import java.util.List;

public class Programacion {

	public static final String ESTADO_PENDIENTE = "P";
	
	public static final String ESTADO_APROBADO = "A";
	
	public static final String ESTADO_RECHAZADO = "R";
	
	private Integer id;
	
	private String fechainicio;
	
	private String fechafin;
	
	private String estado;
	
	private String estadoAsString;
	
	private Campana campana;
	
	private Usuario usuario;

	private List<DetalleProgramacion> detalles;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleProgramacion> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleProgramacion> detalles) {
		this.detalles = detalles;
	}

	public String getEstadoAsString() {
		if(ESTADO_PENDIENTE.equals(this.estado))
			this.estadoAsString = "PENDIENTE";
		else if(ESTADO_APROBADO.equals(this.estado))
			this.estadoAsString = "APROBADO";
		else if(ESTADO_RECHAZADO.equals(this.estado))
			this.estadoAsString = "RECHAZADO";
		return estadoAsString;
	}
	
	@Override
	public String toString() {
		return "Programacion [id=" + id + ", fechainicio=" + fechainicio
				+ ", fechafin=" + fechafin + ", estado=" + estado
				+ ", campana=" + campana + ", usuario=" + usuario + "]";
	}
	
}
