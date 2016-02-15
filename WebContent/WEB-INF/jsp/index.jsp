<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<body>
	
	<div class="jumbotron">
	    <h1>Sistema GRDWeb</h1>
	    <p class="lead">Gestión de Recurso por Demanda</p>
	</div>
	
	<div class="row">
	    <div class="col-md-6">
	        <h2>Actualizar programación de personal de apoyo</h2>
	        <p>
	            El caso de uso comienza cuando ...
	        </p>
	        <p><a class="btn btn-default" href="${path}/programacion/index.html">Actualizar programación de personal de apoyo &raquo;</a></p>
	    </div>
	    <div class="col-md-6">
	        <h2>Aprobar programación de personal de apoyo</h2>
	        <p>
	            Este caso de uso inicia cuando ...
	        </p>
	        <p><a class="btn btn-default" href="#">Aprobar programación de personal de apoyo &raquo;</a></p>
	    </div>
	</div>

</body>
</html>