package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.TiendaArea;

public interface IAreaDAO {

	public List<TiendaArea> listar(Integer idtienda);
	
	public TiendaArea obtener(Integer idtienda, Integer idarea);
	
}
