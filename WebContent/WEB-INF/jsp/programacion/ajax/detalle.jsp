<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<c:if test="${error!=null }">
	<div class="alert alert-danger alert-dismissible fade in" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span>
		</button>
		<p><c:out value="${error}"/><p>
	</div>
</c:if>

<table class="table table-striped">
	<colgroup>
		<col width="40">
		<col width="220">
		<col width="100">
		<col >
		<col width="120">
		<col width="180">
		<col width="100">
		<col width="80">
	</colgroup>
	<thead>
		<tr>
			<th>#</th>
			<th>TIENDA</th>
			<th>AREA</th>
			<th>PERSONAL</th>
			<th>FECHA</th>
			<th>TURNO</th>
			<th>CAJA</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${detalles}" var="detalle">
		<tr>
			<td><c:out value="${detalle.item}"/></td>
			<td><c:out value="${detalle.area.tienda.nombre}"/></td>
			<td><c:out value="${detalle.area.area.nombre}"/></td>
			<td><c:out value="${detalle.personal.nombreCompleto}"/></td>
			<td><c:out value="${detalle.fechaAsignacion}"/></td>
			<td><c:out value="${detalle.turno.descripcion}"/></td>
			<td><c:out value="${detalle.caja.numero}"/></td>
			<td><a href="javascript:void(0)" class="btn btn-danger btn-sm" onclick="eliminar(<c:out value="${detalle.item}"/>)">Eliminar <i class="glyphicon glyphicon-remove"></i></a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
