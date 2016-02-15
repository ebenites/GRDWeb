<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(function () {
	        
	        $('.input-daterange').datepicker({
	            format: "yyyy-mm-dd",
	            language: "es",
	            //startDate: "2016-02-02",
	            //endDate: "2016-02-02",
	            autoclose: true,
	            todayHighlight: true
	        });
	
	    });
		
		function validar(form){
			var fecha1 = $('#form-buscar input[name="fecha1"]').val();
			var fecha2 = $('#form-buscar input[name="fecha2"]').val();
			
			if(fecha1 == '' || fecha2 == ''){
				$('#modal-alert div.modal-body').html('Debe indicar un rango de fechas.');
				$('#modal-alert').modal();
				return false;
			}
			
			return true;
		}
		
		function eliminar(id){
			$('#modal-confirm div.modal-body').html('¿Realmente desea eliminar la programación?.');
			$('#modal-confirm div.modal-footer button.btn-primary').unbind('click').click(function(){
				location.href = '${path}/programacion/eliminar.html?id='+id;
			});
			$('#modal-confirm').modal();
		}
	</script>
</head>
<body>

	<h2 class="page-header">Actualizar programación de personal de apoyo</h2>
	
	<form id="form-buscar" action="${path}/programacion/buscar.html" method="post" onsubmit="return validar(this)">
		<fieldset>
			<legend>Búsqueda de Programaciones</legend>
			
			<div class="row">
				<div class="form-group col-md-5">
					<input type="text" name="usuario" class="form-control" placeholder="Usuario" value="${usuario.nombres}" readonly="readonly"/>
				</div>
	            <div class="form-group col-md-5">
	                <div class="input-daterange input-group">
	                	<input type="text" name="fecha1" class="form-control" placeholder="Fecha Inicio" value="<c:out value="${fecha1}"/>"/>
	                    <span class="input-group-addon">a</span>
	                    <input type="text" name="fecha2" class="form-control" placeholder="Fecha Fin" value="<c:out value="${fecha2}"/>"/>
	                </div>
	            </div>
	            <div class="form-group col-md-2 text-right">
	                <input type="submit" value="Buscar Registros" class="btn btn-primary"/>
	            </div>
	        </div>
			
		</fieldset>
	</form>
	
	<div class="row">
		<div class="form-group col-md-6">
			<a href="${path}/programacion/nuevo.html" class="btn btn-success">Nuevo <i class="glyphicon glyphicon-plus-sign"></i></a>
		</div>
<!-- 		<div class="form-group col-md-6 text-right"> -->
<%-- 			<a href="${path}/" class="btn btn-default">Consultar <i class="glyphicon glyphicon-search"></i></a> --%>
<!-- 		</div> -->
	</div>
	
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
					<td><a href="${path}/" class="btn btn-info btn-sm">Consultar <i class="glyphicon glyphicon-search"></i></a></td>
					<td><c:if test="${programacion.estado=='P'}"><a href="${path}/" class="btn btn-warning btn-sm">Modificar <i class="glyphicon glyphicon-edit "></i></a></c:if></td>
					<td><c:if test="${programacion.estado=='P'}"><a href="javascript:void(0)" onclick="eliminar(<c:out value="${programacion.id}"/>)" class="btn btn-danger btn-sm">Eliminar <i class="glyphicon glyphicon-remove"></i></a></c:if></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>