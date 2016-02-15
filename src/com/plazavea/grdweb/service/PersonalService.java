package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.IPersonalDAO;
import com.plazavea.grdweb.model.Personal;

@Service
public class PersonalService implements IPersonalService {

	protected static Logger log = Logger.getLogger(PersonalService.class);
	
	@Autowired
	private IPersonalDAO personalDAO;
	
	@Override
	public List<Personal> listar(Integer idcampana, Integer idtienda, Integer idarea) {
		log.info("calling listar: ");
		return personalDAO.listar(idcampana, idtienda, idarea); 
	}

	@Override
	public Personal obtener(Integer idpersonal) {
		log.info("calling obtener: ");
		return personalDAO.obtener(idpersonal); 
	}

}
