<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3><spring:message code="usuario"/></h3>
	<form:form action="" method="POST" modelAttribute="usuario">
		<p>
			<label for="nombre"><spring:message code="usuario.nombre"/></label>
			<form:input path="nombre" /><form:errors path="nombre" cssClass="errorTootip"></form:errors>
		</p>
		<p>
			<label for="apellido"><spring:message code="usuario.apellido"/></label>
			<form:input path="apellido" /><form:errors path="apellido" cssClass="errorTootip"></form:errors>
		</p>
		<p>
			<label for="edad"><spring:message code="usuario.edad"/></label>
			<form:input type="number" path="edad" /><form:errors path="edad" cssClass="errorTootip"></form:errors>
		</p>
		<p>
			<form:button name="aceptar" class="btn btn-default btn-lg active" role="button"><spring:message code="aceptar"/></form:button>
		</p>
	</form:form>
</div>