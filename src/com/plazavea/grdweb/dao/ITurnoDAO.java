package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.Turno;

public interface ITurnoDAO {

	public List<Turno> listar();
	
	public Turno obtener(Integer idturno);
	
}
