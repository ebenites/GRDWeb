package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.Campana;

public interface ICampanaDAO {

	public List<Campana> listar();
	
	public Campana obtener(Integer id);
	
}
