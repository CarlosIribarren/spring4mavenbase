<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3><spring:message code="nacimiento.fecha"/></h3>
	<form:form action="" method="POST" modelAttribute="nacimiento">
		<p>
			<label for="fechaNacimiento"><spring:message code="nacimiento.fecha"/> (<spring:message code="nacimiento.formato"/>)</label>
			<form:input path="fechaNacimiento" /><form:errors path="fechaNacimiento" cssClass="errorTootip"></form:errors>
		</p>
		<c:if test="${not empty resEdad}">
			<p><spring:message code="nacimiento.resultado"/> <c:out value="${resEdad}"/></p>
		</c:if>
		<p>
			<form:button name="aceptar" class="btn btn-default btn-lg active" role="button"><spring:message code="nacimiento.calcular"/></form:button>
		</p>
	</form:form>
</div>