package com.plazavea.grdweb.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plazavea.grdweb.model.Caja;
import com.plazavea.grdweb.model.Campana;
import com.plazavea.grdweb.model.DetalleProgramacion;
import com.plazavea.grdweb.model.Personal;
import com.plazavea.grdweb.model.Programacion;
import com.plazavea.grdweb.model.TiendaArea;
import com.plazavea.grdweb.model.Turno;
import com.plazavea.grdweb.model.Usuario;
import com.plazavea.grdweb.service.IAreaService;
import com.plazavea.grdweb.service.ICajaService;
import com.plazavea.grdweb.service.ICampanaService;
import com.plazavea.grdweb.service.IPersonalService;
import com.plazavea.grdweb.service.IProgramacionService;
import com.plazavea.grdweb.service.ITurnoService;
import com.plazavea.grdweb.service.IUsuarioService;

@Controller()
@RequestMapping("/programacion")
public class ProgramacionController {

	protected static final Logger log = Logger.getLogger(ProgramacionController.class);	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IProgramacionService programacionService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ICampanaService campanaService; 
	
	@Autowired
	private IAreaService areaService; 
	
	@Autowired
	private IPersonalService personalService;
	
	@Autowired
	private ITurnoService turnoService;
	
	@Autowired
	private ICajaService cajaService;
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model) {
		log.info("calling index");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Programacion> programaciones = programacionService.listar(usuario.getId());
		model.addAttribute("programaciones", programaciones);
		
		return "programacion/index";
	}
	
	@RequestMapping(value = "/buscar.html", method = RequestMethod.POST)
	public String buscar(Model model, @RequestParam String fecha1, @RequestParam String fecha2) throws Exception{
		log.info("calling buscar");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Programacion> programaciones = programacionService.buscar(usuario.getId(), fecha1, fecha2);
		model.addAttribute("programaciones", programaciones);
		
		model.addAttribute("fecha1", fecha1);
		model.addAttribute("fecha2", fecha2);
		
		return "programacion/index";
	}
	
	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		log.info("calling nuevo");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Campana> campanas = campanaService.listar();
		model.addAttribute("campanas", campanas);
		
		List<TiendaArea> areas = areaService.listar(usuario.getTienda().getId());
		model.addAttribute("areas", areas);
		
		List<Turno> turnos = turnoService.listar();
		model.addAttribute("turnos", turnos);
		
		List<Caja> cajas = cajaService.listar(usuario.getTienda().getId());
		model.addAttribute("cajas", cajas);
		
		session.setAttribute("progdetalles", new ArrayList<>());
		
		return "programacion/nuevo";
	}
	
	@RequestMapping(value = "/campana/{idcampana}", method = RequestMethod.GET)
	public @ResponseBody Campana campana(Model model, @PathVariable Integer idcampana) {
		log.info("calling campana");
		
		Campana campana = campanaService.obtener(idcampana);
		
		return campana;
	}
	
	@RequestMapping(value = "/personal/{idcampana}", method = RequestMethod.GET)
	public @ResponseBody List<Personal> personal(Model model, @PathVariable Integer idcampana) {
		log.info("calling personal");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Personal> personales = personalService.listar(idcampana, usuario.getTienda().getId(), usuario.getArea().getId());
		
		return personales;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ajax/agregar.html", method = RequestMethod.POST)
	public String agregar(Model model, @RequestParam Integer idpersonal, @RequestParam Integer idturno, 
			@RequestParam Integer idcaja, @RequestParam String fecha) {
		log.info("calling agregar");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		// Recuperar de la sesion
		
		List<DetalleProgramacion> detalles = new ArrayList<>();
		if(session.getAttribute("progdetalles")!=null)
			detalles = (List<DetalleProgramacion>) session.getAttribute("progdetalles");
		
		// Verificar repetido
		
		String error = null;
		for (DetalleProgramacion d : detalles) {
			if(d.getPersonal().getId() == idpersonal && d.getFechaAsignacion().equals(fecha) && d.getTurno().getId() == idturno){
				error = "El personal ya ha sido asginado en el mismo día y el mismo turno.";
				model.addAttribute("error", error);
			}
		}
		
		if(error==null){
		
			// Añadir
			
			DetalleProgramacion detalle = new DetalleProgramacion();
			detalle.setArea(areaService.obtener(usuario.getTienda().getId(), usuario.getArea().getId()));
			detalle.setPersonal(personalService.obtener(idpersonal));
			detalle.setTurno(turnoService.obtener(idturno));
			detalle.setCaja(cajaService.obtener(idcaja));
			detalle.setFechaAsignacion(fecha);
			
			detalles.add(detalle);
			
			// Reordenar indice
			
			int item = 1;
			for (DetalleProgramacion detalleProgramacion : detalles) {
				detalleProgramacion.setItem(item++);
			}
		
		}
		model.addAttribute("detalles", detalles);
		
		return "programacion/ajax/detalle";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ajax/eliminar.html", method = RequestMethod.POST)
	public String eliminar(Model model, @RequestParam Integer item) {
		log.info("calling eliminar");
		
		// Recuperar de la sesion
		
		List<DetalleProgramacion> detalles = (List<DetalleProgramacion>) session.getAttribute("progdetalles");
		
		// Eliminar
		
		for (Iterator<DetalleProgramacion> i = detalles.iterator(); i.hasNext();) {
			if(i.next().getItem() == item)
				i.remove();
		}
		
		// Reordenar indice
		
		item = 1;
		for (DetalleProgramacion detalleProgramacion : detalles) {
			detalleProgramacion.setItem(item++);
		}
		
		model.addAttribute("detalles", detalles);
		
		return "programacion/ajax/detalle";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/registrar.html", method = RequestMethod.POST)
	public String registrar(Model model, RedirectAttributes redirect, @RequestParam Integer campana_id, @RequestParam String fecha1, @RequestParam String fecha2) throws Exception {
		log.info("calling registrar");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		Programacion programacion = new Programacion();
		programacion.setFechainicio(fecha1);
		programacion.setFechafin(fecha2);
		
		Campana campana = new Campana();
		campana.setId(campana_id);
		
		programacion.setCampana(campana);
		programacion.setUsuario(usuario);
		programacion.setEstado(Programacion.ESTADO_PENDIENTE);
		
		// Recuperar de la sesion
		
		List<DetalleProgramacion> detalles = (List<DetalleProgramacion>) session.getAttribute("progdetalles");
		programacion.setDetalles(detalles);
		
		// Registrar a la BD
		
		programacionService.registrar(programacion);
		
		redirect.addFlashAttribute("message", "Programación registrada satisfactoriamente.");
		
		return "redirect:index.html";
	}
	
	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(Model model, RedirectAttributes redirect, @RequestParam Integer id) {
		log.info("calling eliminar");
		
		programacionService.eliminar(id);
		
		redirect.addFlashAttribute("message", "Programación eliminada satisfactoriamente.");
		
		return "redirect:index.html";
	}
	
	@RequestMapping(value = "/pendientes.html", method = RequestMethod.GET)
	public String pendientes(Model model) {
		log.info("calling pendientes");
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		List<Programacion> programaciones = programacionService.pendientes(usuario.getId());
		model.addAttribute("programaciones", programaciones);
		
		return "programacion/pendientes";
	}
	
	
	
}
