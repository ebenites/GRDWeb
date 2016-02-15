<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
</head>
<body>

	<h1 class="page-header">Campañas</h1>
	
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>FECHA INICIO</th>
					<th>FECHA FIN</th>
					<th>ESTADO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${campanas}" var="campana">
				<tr>
					<td><c:out value="${campana.id}"/></td>
					<td><c:out value="${campana.nombre}"/></td>
					<td><c:out value="${campana.fechainicio}"/></td>
					<td><c:out value="${campana.fechafin}"/></td>
					<td><c:out value="${campana.estado}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>