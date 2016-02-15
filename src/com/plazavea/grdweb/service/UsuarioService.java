package com.plazavea.grdweb.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazavea.grdweb.dao.IUsuarioDAO;
import com.plazavea.grdweb.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

	protected static Logger log = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public Usuario obtener(Integer id) {
		log.info("calling listar: ");
		return usuarioDAO.obtener(id); 
	}

}
