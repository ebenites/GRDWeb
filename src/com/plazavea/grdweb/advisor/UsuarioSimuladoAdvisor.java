package com.plazavea.grdweb.advisor;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plazavea.grdweb.service.IUsuarioService;

@Aspect
@Component
public class UsuarioSimuladoAdvisor {

	protected Logger log = Logger.getLogger(getClass());	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Pointcut("execution(* com.plazavea.grdweb.controller..*Controller.*(..)) && @annotation(requestMapping)")
	protected void controllerAdvisorPointcut(RequestMapping requestMapping) {}
	
	@Before("controllerAdvisorPointcut(requestMapping)") 
	public void beforeAdvisor(JoinPoint joinPoint, RequestMapping requestMapping) {
		log.info("@Before [" + Arrays.toString(requestMapping.method()) + " " + Arrays.toString(requestMapping.value()) + "] JoinPoint [" + joinPoint.toShortString() + "] Args [" + Arrays.toString(joinPoint.getArgs()) + "]");
		
		session.setAttribute("usuario", usuarioService.obtener(2));
		
	}
	
}
