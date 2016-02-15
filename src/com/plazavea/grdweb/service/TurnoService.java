package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.ITurnoDAO;
import com.plazavea.grdweb.model.Turno;

@Service
public class TurnoService implements ITurnoService {

	protected static Logger log = Logger.getLogger(TurnoService.class);
	
	@Autowired
	private ITurnoDAO turnoDAO;
	
	@Override
	public List<Turno> listar() {
		log.info("calling listar: ");
		return turnoDAO.listar(); 
	}

	@Override
	public Turno obtener(Integer idturno) {
		log.info("calling obtener: ");
		return turnoDAO.obtener(idturno); 
	}

}
