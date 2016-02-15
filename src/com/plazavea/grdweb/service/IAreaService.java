package com.plazavea.grdweb.service;

import java.util.List;

import com.plazavea.grdweb.model.TiendaArea;

public interface IAreaService {

	public List<TiendaArea> listar(Integer idtienda);
	
	public TiendaArea obtener(Integer idtienda, Integer idarea);
	
}
