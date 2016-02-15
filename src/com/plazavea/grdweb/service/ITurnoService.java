package com.plazavea.grdweb.service;

import java.util.List;

import com.plazavea.grdweb.model.Turno;

public interface ITurnoService {

	public List<Turno> listar();
	
	public Turno obtener(Integer idturno);
	
}
