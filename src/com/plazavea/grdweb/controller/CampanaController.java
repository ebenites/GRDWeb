package com.plazavea.grdweb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plazavea.grdweb.model.Campana;
import com.plazavea.grdweb.service.ICampanaService;

@Controller()
@RequestMapping("/campana")
public class CampanaController {

	protected static final Logger log = Logger.getLogger(CampanaController.class);	
	
	@Autowired
	private ICampanaService campanaService;
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model) {
		log.info("calling index");
		
		List<Campana> campanas = campanaService.listar();
		
		model.addAttribute("campanas", campanas);
		
		return "campana/index";
	}

}
