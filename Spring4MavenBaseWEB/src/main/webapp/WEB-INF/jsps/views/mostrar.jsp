<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3><spring:message code="usuario"/></h3>
	<c:if test="${not empty nombre}">
		<p><b><spring:message code="usuario.nombre"/>: </b><c:out value="${nombre}"></c:out></p>
		<p><b><spring:message code="usuario.apellido"/>: </b><c:out value="${apellido}"></c:out></p>
		<p><b><spring:message code="usuario.edad"/>: </b><c:out value="${edad}"></c:out></p>
	</c:if>
	<c:if test="${not empty error}">
		<p><c:out value="${error}"></c:out></p>
	</c:if>
	<a href="${pageContext.request.contextPath}/inicio" title="<spring:message code="volver"/>"><spring:message code="volver"/></a>
</div>