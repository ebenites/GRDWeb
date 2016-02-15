package com.plazavea.grdweb.service;

import java.util.List;

import com.plazavea.grdweb.model.Caja;

public interface ICajaService {

	public List<Caja> listar(Integer idtienda);
	
	public Caja obtener(Integer idcaja);
	
}
