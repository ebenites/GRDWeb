package com.plazavea.grdweb.model;

public class Caja {

	private Integer id;
	
	private String numero;
	
	private String estado;
	
	private Tienda tienda;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return "CAJA " + numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Caja [id=" + id + ", numero=" + numero + ", estado=" + estado
				+ ", tienda=" + tienda + "]";
	}
	
}
