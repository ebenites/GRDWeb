package com.plazavea.grdweb.model;

public class Usuario {

	private Integer id;
	
	private String username;
	
	private String userpass;
	
	private Empleado empleado;
	
	private String nombres;

	private Tienda tienda;
	
	private Area area;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getNombres(){
		if(this.empleado != null){
			this.nombres = this.empleado.getNombres() + " " + this.empleado.getApellidos();
		}
		return this.nombres;
	}
	
	public Tienda getTienda(){
		if(this.empleado != null && this.empleado.getTiendaArea() != null){
			this.tienda = this.empleado.getTiendaArea().getTienda();
		}
		return this.tienda;
	}
	
	public Area getArea(){
		if(this.empleado != null && this.empleado.getTiendaArea() != null){
			this.area = this.empleado.getTiendaArea().getArea();
		}
		return this.area;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", userpass="
				+ userpass + ", empleado=" + empleado + "]";
	}
	
}
