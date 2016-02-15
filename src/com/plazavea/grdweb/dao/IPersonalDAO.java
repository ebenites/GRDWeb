package com.plazavea.grdweb.dao;

import java.util.List;

import com.plazavea.grdweb.model.Personal;

public interface IPersonalDAO {

	public List<Personal> listar(Integer idcampana, Integer idtienda, Integer idarea);
	
	public Personal obtener(Integer idpersonal);
	
}
