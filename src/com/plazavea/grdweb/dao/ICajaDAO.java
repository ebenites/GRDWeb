package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.Caja;

public interface ICajaDAO {

	public List<Caja> listar(Integer idtienda);
	
	public Caja obtener(Integer idcaja);
	
}
