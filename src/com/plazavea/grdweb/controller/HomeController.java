package com.plazavea.grdweb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	protected static final Logger log = Logger.getLogger(HomeController.class);	
	
	@RequestMapping(value = { "/", "/home.html" }, method = RequestMethod.GET)
	public String index(Model model) {	//For User
		log.info("calling index");
		
//		model.addAttribute("title", "GRD");
		
		return "index";
	}
	
	@RequestMapping(value = "/500.html", method = RequestMethod.GET)
	@ResponseBody
	public String error() {
		log.info("calling error");
		
		return "Error general";

	}

}
