<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(function () {
	        
	        $('#form-nuevo .input-daterange').datepicker({
	            format: "yyyy-mm-dd",
	            language: "es",
	            //startDate: "2016-02-02",
	            //endDate: "2016-02-02",
	            autoclose: true,
	            todayHighlight: true
	        });
	        
	        $('#form-nuevo input[name="fechaasignacion"]').datepicker({
	            format: "yyyy-mm-dd",
	            language: "es",
	            //startDate: "2016-02-02",
	            //endDate: "2016-02-02",
	            autoclose: true,
	            todayHighlight: true
	        });
	        
	    });
		
		function cargarFechas(select){
			
			$.get('${path}/programacion/campana/' + $(select).val(), function(data){
// 				console.log(data);
				
				// Limitar fecha de asignacion
				
				$('#form-nuevo input[name="fechaasignacion"]').datepicker('setStartDate', data.fechainicio);
				$('#form-nuevo input[name="fechaasignacion"]').datepicker('setEndDate', data.fechafin);
				
				$('#form-nuevo input[name="fechaasignacion"]').datepicker("setDate", data.fechainicio);
// 				$('#form-nuevo input[name="fechaasignacion"]').datepicker("clearDates");
				
				// Limitar rango de fechas
				
				$('#form-nuevo input[name="fecha1"]').datepicker('setStartDate', data.fechainicio);
				$('#form-nuevo input[name="fecha1"]').datepicker('setEndDate', data.fechafin);
				$('#form-nuevo input[name="fecha2"]').datepicker('setStartDate', data.fechainicio);
				$('#form-nuevo input[name="fecha2"]').datepicker('setEndDate', data.fechafin);
				
				$('#form-nuevo input[name="fecha1"]').val(data.fechainicio);
				$('#form-nuevo input[name="fecha1"]').datepicker("update");
				$('#form-nuevo input[name="fecha2"]').val(data.fechafin);
				$('#form-nuevo input[name="fecha2"]').datepicker("update");
				
			}, 'json');
			
			// Cargar lista de personal del area-camapana
			$.get('${path}/programacion/personal/' + $(select).val(), function(data){
// 				console.log(data);
				
				var select = $("#form-nuevo select[name='personal_id']").find('option[value]').remove().end();  
				$(data).each(function() {
					select.append($("<option />").val(this.id).text(this.nombreCompleto));
				});
				
			});
			
		}
		
		function agregar(){
			
			var idpersonal = $('#form-nuevo select[name="personal_id"]').val();
			var idturno = $('#form-nuevo select[name="turno_id"]').val();
			var idcaja = $('#form-nuevo select[name="caja_id"]').val();
			var fecha = $('#form-nuevo input[name="fechaasignacion"]').val();
			
			if(!idpersonal || !idturno || !idcaja || fecha == ''){
				var message = 'Debe completar todos los campos.'
				$('#modal-alert div.modal-body').html(message);
				$('#modal-alert').modal();
				return;
			}
			
			$.post('${path}/programacion/ajax/agregar.html', { 
				'idpersonal' : idpersonal,
				'idturno' : idturno,
				'idcaja' : idcaja,
				'fecha' : fecha
				}, function(data){
				
					$('#table-detalle').html(data);
					
			});
		}
		
		function eliminar(item){
			
			$.post('${path}/programacion/ajax/eliminar.html', { 'item' : item }, function(data){
				
					$('#table-detalle').html(data);
					
			});
		}
		
		function validar(form){
			var idcampana = $('#form-nuevo select[name="campana_id"]').val();
			var fecha1 = $('#form-nuevo input[name="fecha1"]').val();
			var fecha2 = $('#form-nuevo input[name="fecha2"]').val();
			var items = $('#table-detalle table > tbody > tr').length;
			
			if(!idcampana){
				$('#modal-alert div.modal-body').html('Debe seleccionar una campaña.');
				$('#modal-alert').modal();
				return false;
			}
			
			if(fecha1 == '' || fecha2 == ''){
				$('#modal-alert div.modal-body').html('Debe indicar un rango de fechas.');
				$('#modal-alert').modal();
				return false;
			}
			
			if(items == 0){
				$('#modal-alert div.modal-body').html('No ha agregado ningún item a la programación.');
				$('#modal-alert').modal();
				return false;
			}
			
			return true;
		}
		
	</script>
</head>
<body>

	<h2 class="page-header">Nueva Programación de Personal de Apoyo</h2>
	
	<form id="form-nuevo" action="${path}/programacion/registrar.html" method="post" onsubmit="return validar(this)">
		<fieldset>
			<legend>Programación</legend>
			
			<div class="row">
				<div class="form-group col-md-4">
	            	<label>Campaña</label>
					<select name="campana_id" class="form-control" onchange="cargarFechas(this)">
						<option disabled="disabled" selected="selected">-- Seleccione un valor --</option>
						<c:forEach items="${campanas}" var="campana">
							<option value="<c:out value="${campana.id}"/>"><c:out value="${campana.nombre}"/></option>
						</c:forEach>
					</select>
				</div>
	            <div class="form-group col-md-8">
	            	<label>Rango de fechas del</label>
	                <div class="input-daterange input-group">
	                	<input type="text" name="fecha1" class="form-control" placeholder="Fecha Inicio" value=""/>
	                    <span class="input-group-addon">al</span>
	                    <input type="text" name="fecha2" class="form-control" placeholder="Fecha Fin" value=""/>
	                </div>
	            </div>
	        </div>
			
		</fieldset>
		
		<fieldset>
			<legend>Detalle de Programación</legend>
			
			<div class="row">
	            <div class="form-group col-md-4">
	            	<label>Tienda</label>
	            	<select name="tienda_id" class="form-control" disabled="disabled">
						<option value="<c:out value="${usuario.tienda.id}"/>"><c:out value="${usuario.tienda.nombre}"/></option>
					</select>
	            </div>
	            <div class="form-group col-md-4">
	            	<label>Area</label>
	            	<select name="area_id" class="form-control" disabled="disabled">
						<option disabled="disabled" selected="selected">-- Seleccione un valor --</option>
						<c:forEach items="${areas}" var="area">
							<option value="<c:out value="${area.area.id}"/>" <c:if test="${area.area.id == usuario.area.id}">selected="selected"</c:if> ><c:out value="${area.area.nombre}"/></option>
						</c:forEach>
					</select>
	            </div>
	            <div class="form-group col-md-4">
	            	<label>Personal</label>
	            	<select name="personal_id" class="form-control">
						<option disabled="disabled" selected="selected">-- Seleccione un valor --</option>
					</select>
				</div>
	        </div>
	        
	        <div class="row">
	            <div class="form-group col-md-4">
	            	<label>Fecha Asignación</label>
					<input type="text" name="fechaasignacion" class="form-control" placeholder="" value=""/>
				</div>
				<div class="form-group col-md-4">
					<label>Turno</label>
					<select name="turno_id" class="form-control">
						<option disabled="disabled" selected="selected">-- Seleccione un valor --</option>
						<c:forEach items="${turnos}" var="turno">
							<option value="<c:out value="${turno.id}"/>"><c:out value="${turno.descripcion}"/></option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-4">
					<c:if test="${usuario.area.tipo == 'C'}">
	            	<label>Caja Habilitada</label>
					<select name="caja_id" class="form-control">
						<option disabled="disabled" selected="selected">-- Seleccione un valor --</option>
						<c:forEach items="${cajas}" var="caja">
							<option value="<c:out value="${caja.id}"/>"><c:out value="${caja.numero}"/></option>
						</c:forEach>
					</select>
					</c:if>
				</div>
	        </div>
	        
	        <div class="row">
				<div class="form-group col-md-12">
					<input type="button" value="Agregar" class="btn btn-default" onclick="agregar()"/>
				</div>
	        </div>
			
			<div class="table-responsive" id="table-detalle">
				
			</div>
			
		</fieldset>
		
		<hr/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<input type="submit" value="Grabar" class="btn btn-primary"/>
			</div>
		</div>
		
	</form>

</body>
</html>