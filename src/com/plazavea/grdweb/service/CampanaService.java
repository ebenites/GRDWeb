package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.ICampanaDAO;
import com.plazavea.grdweb.model.Campana;

@Service
public class CampanaService implements ICampanaService {

	protected static Logger log = Logger.getLogger(CampanaService.class);
	
	@Autowired
	private ICampanaDAO campanaDAO;
	
	@Override
	public List<Campana> listar() {
		log.info("calling listar: ");
		return campanaDAO.listar(); 
	}
	
	@Override
	public Campana obtener(Integer id) {
		log.info("calling obtener: " + id);
		return campanaDAO.obtener(id); 
	}

}
