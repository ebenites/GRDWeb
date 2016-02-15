<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>

	<title>GRDWeb | <sitemesh:write property='title'/></title>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- jquery -->
	<script src="${path}/js/jquery-1.12.0.min.js"></script>
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="${path}/css/dashboard.css" type="text/css"/>
	
	<!-- bootstrap -->
	<link rel="stylesheet" href="${path}/js/bootstrap-datepicker/css/bootstrap-datepicker.standalone.min.css">
	<script src="${path}/js/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<script src="${path}/js/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js"></script>
		
	<link rel="stylesheet" href="${path}/css/style.css" type="text/css"/>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<script type="text/javascript">
		$(function(){
			
			// Menu
			$(".navbar button.btn-sidebar").click(function(e) {
		        $(".sidebar").slideToggle();
		    });
			
		});
	</script>
	
	<sitemesh:write property='head'/>
	
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
			
				<button type="button" class="btn btn-default btn-sidebar" aria-label="Mostrar/Ocultar Menú">
        			<span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
        		</button>
			
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				
				<a class="navbar-brand navbar-logo" href="#"><img src="${path}/img/logo.png" height="50"/></a>
				
				<a class="navbar-brand" href="${path}/">Sistema GDRWeb</a>
				
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Buscar...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="${path}/">Inicio</a></li>
					<li><a href="${path}/campana/index.html">Campaña</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${path}/programacion/index.html">Actualizar programación de personal de apoyo</a></li>
					<li><a href="${path}/programacion/pendientes.html">Aprobar programación de personal de apoyo</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<c:if test="${message != null}">
					<div class="alert alert-warning alert-dismissible fade in" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
						<c:out value="${message}"/>
					</div>
				</c:if>

				<sitemesh:write property='body'/>

			</div>
		</div>
	</div>
	
	<div id="footer">
        <jsp:useBean id="now" class="java.util.Date" />
	    Todos los Derechos Reservados © <fmt:formatDate pattern="yyyy" value="${now}" />
	</div>

	
	<div id="modal-alert" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">Advertencia</h4>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				</div>

			</div>
		</div>
	</div>
	
	<div id="modal-confirm" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">Confirmación</h4>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary">Eliminar</button>
				</div>

			</div>
		</div>
	</div>

</body>
</html>