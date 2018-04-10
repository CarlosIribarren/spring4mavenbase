<%@ include file="taglibs.jsp"%>

<link href="${pageContext.request.contextPath}/estatico/comun/css/cabecera.css" rel="stylesheet" type="text/css" />

<header>    		
	<ul id="menu">
  		<li class="derecha"><a href="${pageContext.request.contextPath}/inicio?locale=es">ES</a></li>
  		<li class="derecha"><a href="${pageContext.request.contextPath}/inicio?locale=eu">EU</a></li>
	</ul>
</header>

<nav>
  <ul>
    <li><a href="${pageContext.request.contextPath}/inicio" title="<spring:message code="usuarios"/>"><spring:message code="usuarios"/></a></li>
    <li><a href="${pageContext.request.contextPath}/calculadora/new" title="<spring:message code="calculadora"/>"><spring:message code="calculadora"/></a></li>
    <li><a href="${pageContext.request.contextPath}/nacimiento" title="<spring:message code="nacimiento.fecha"/>"><spring:message code="nacimiento.fecha"/></a></li>
    <li><a href="${pageContext.request.contextPath}/datos" title="<spring:message code="datos"/>"><spring:message code="datos"/></a></li>
  </ul>
</nav>