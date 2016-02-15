package com.plazavea.grdweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plazavea.grdweb.dao.IProgramacionDAO;
import com.plazavea.grdweb.model.Programacion;

@Service
public class ProgramacionService implements IProgramacionService {

	protected static Logger log = Logger.getLogger(ProgramacionService.class);
	
	@Autowired
	private IProgramacionDAO programacionDAO;
	
	@Override
	public List<Programacion> listar(Integer idusuario) {
		log.info("calling listar: ");
		return programacionDAO.listar(idusuario); 
	}

	public List<Programacion> buscar(Integer idusuario, String fecha1, String fecha2) throws Exception {
		log.info("calling buscar: ");
		return programacionDAO.buscar(idusuario, fecha1, fecha2); 
	}
	
	@Override
	public List<Programacion> pendientes(Integer idusuario) {
		log.info("calling pendientes: ");
		return programacionDAO.pendientes(idusuario); 
	}
	
	@Override
	@Transactional
	public void registrar(Programacion programacion) throws Exception {
		log.info("calling registrar: ");
		programacionDAO.registrar(programacion); 
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		log.info("calling eliminar: ");
		programacionDAO.eliminar(id); 
	}

}
