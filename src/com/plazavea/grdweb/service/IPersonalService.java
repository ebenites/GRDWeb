package com.plazavea.grdweb.service;

import java.util.List;

import com.plazavea.grdweb.model.Personal;

public interface IPersonalService {

	public List<Personal> listar(Integer idcampana, Integer idtienda, Integer idarea);
	
	public Personal obtener(Integer idpersonal);
	
}
