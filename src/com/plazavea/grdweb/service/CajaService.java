package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.ICajaDAO;
import com.plazavea.grdweb.model.Caja;

@Service
public class CajaService implements ICajaService {

	protected static Logger log = Logger.getLogger(CajaService.class);
	
	@Autowired
	private ICajaDAO cajaDAO;
	
	@Override
	public List<Caja> listar(Integer idtienda) {
		log.info("calling listar: ");
		return cajaDAO.listar(idtienda); 
	}

	@Override
	public Caja obtener(Integer idcaja) {
		log.info("calling obtener: ");
		return cajaDAO.obtener(idcaja);
	}

}
