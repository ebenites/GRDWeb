package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.IAreaDAO;
import com.plazavea.grdweb.model.TiendaArea;

@Service
public class AreaService implements IAreaService {

	protected static Logger log = Logger.getLogger(AreaService.class);
	
	@Autowired
	private IAreaDAO areaDAO;
	
	@Override
	public List<TiendaArea> listar(Integer idtienda) {
		log.info("calling listar: ");
		return areaDAO.listar(idtienda); 
	}

	@Override
	public TiendaArea obtener(Integer idtienda, Integer idarea) {
		log.info("calling obtener: ");
		return areaDAO.obtener(idtienda, idarea); 
	}
	
}
