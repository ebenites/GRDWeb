<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="path" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	
		<!-- HTTP Status Code -->
        <c:if test="${requestScope['javax.servlet.error.status_code']!= null}">
        	<div class="error">
	         	<h2>ERROR EN EL SERVIDOR <c:out value="${pageContext.request.contextPath}"/></h2>
	         	<h3><font color="red"><c:out value="${requestScope['javax.servlet.error.message']}" default="Referencia Nula"/></font></h3>
        	</div>
        </c:if>
	
		<hr/>
	
		<!-- Exception detail -->
		<div class="debug">
			<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}"/>
			<c:if test="${pageContext.request.queryString!=null}">
				<c:set var="url" value="${url}?${pageContext.request.queryString}"/> 
			</c:if>
			<b>URL:</b> <c:out value="${pageContext.request.method}" /> <c:out value="${url}" /><br/>
			<b>Usuario:</b> <c:out value="${pageContext.request.userPrincipal.name}" default="No ha iniciado sesión"></c:out><br/>
			<jsp:useBean id="now" class="java.util.Date" />
	        <b>Fecha:</b> <fmt:formatDate  value="${now}" type="both" pattern="EEEE, dd 'de' MMMM 'de' yyyy, HH:mm:ss" /><br/>
	        <b>Navegador:</b> <c:out value="${header['user-agent']}" default="Desconocido"/><br/>
	        
	        <c:if test="${exception==null}"><!-- isErrorPage --><c:set var="exception" value="${pageContext.exception}"/></c:if>
	        
	        <c:if test="${exception!=null}"><b>Detalle T&eacute;cnico:</b> <font color="red"><c:out value="${exception}"/></font><br/></c:if>
	        
	        <!-- Exception -->
	        <c:if test="${exception!=null}">
	         <ul>
	         	<li><b>Excepci&oacute;n:</b><c:out value="${exception}"/></li>
	         	<li>
	         		<b>Posici&oacute;n:</b> <c:out value="${exception.stackTrace[0]}" default="Desconocida"/>
	         		<ul type="circle">
	         			<li><b>Clase:</b> <c:out value="${exception.stackTrace[0].className}"/></li>
	         			<li><b>L&iacute;nea:</b> <c:out value="${exception.stackTrace[0].lineNumber}"/></li>
	         			<li><b>M&eacute;todo:</b> <c:out value="${exception.stackTrace[0].methodName}"/>()</li>
	         		</ul>
	         	</li>
	         	<li>
	         		<b>Stack Trace:</b><br/>
	         		<div class="code">
	         		<c:forEach items="${exception.stackTrace}" var="stack">
	         			<c:out value="${stack}"/><br/>
	         		</c:forEach>
	         		</div>
	         	</li>
	        	</ul>
	       	</c:if>
       	</div>
               	
		<p>
			<a href="javascript:history.back()">&lt;&lt;Regresar</a>
		</p>
		
	</body>
</html>