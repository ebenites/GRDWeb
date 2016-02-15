<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(function () {
	        
	    });
	</script>
</head>
<body>

	<h2 class="page-header">Aprobar programación de personal de apoyo</h2>
	
	<div class="table-responsive">
		<table class="table table-striped">
			<colgroup>
				<col width="60">
				<col width="120">
				<col width="120">
				<col >
				<col width="100">
				<col width="100">
				<col width="100">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>FECHA INICIO</th>
					<th>FECHA FIN</th>
					<th>CAMPAÑA</th>
					<th>ESTADO</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${programaciones}" var="programacion">
				<tr>
					<td><c:out value="${programacion.id}"/></td>
					<td><c:out value="${programacion.fechainicio}"/></td>
					<td><c:out value="${programacion.fechafin}"/></td>
					<td><c:out value="${programacion.campana.nombre}"/></td>
					<td><c:out value="${programacion.estadoAsString}"/></td>
					<td><a href="${path}/" class="btn btn-success btn-sm">Aprobar <i class="glyphicon glyphicon-ok"></i></a></td>
					<td><a href="${path}/" class="btn btn-danger btn-sm">Rechazar <i class="glyphicon glyphicon-remove"></i></a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>