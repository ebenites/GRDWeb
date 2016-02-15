package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.Programacion;

public interface IProgramacionDAO {

	public List<Programacion> listar(Integer idusuario);
	
	public List<Programacion> buscar(Integer idusuario, String fecha1, String fecha2) throws Exception;
	
	public List<Programacion> pendientes(Integer idusuario);
	
	public void registrar(Programacion programacion) throws Exception;
	
	public void eliminar(Integer id);
	
}
