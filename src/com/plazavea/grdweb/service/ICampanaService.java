package com.plazavea.grdweb.service;

import java.util.List;

import com.plazavea.grdweb.model.Campana;

public interface ICampanaService {

	public List<Campana> listar();
	
	public Campana obtener(Integer id);
	
}
