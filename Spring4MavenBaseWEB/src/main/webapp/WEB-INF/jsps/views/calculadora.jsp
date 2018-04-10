<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3><spring:message code="calculadora"/></h3>
	<form:form action="" method="POST" modelAttribute="calculadora">
		<p>
			<label for="numero1"><spring:message code="calculadora.numero1"/></label>
			<form:input type="number" path="numero1" /><form:errors path="numero1" cssClass="errorTootip"></form:errors>
		</p>
		<p>
			<label for="numero2"><spring:message code="calculadora.numero2"/></label>
			<form:input type="number" path="numero2" /><form:errors path="numero2" cssClass="errorTootip"></form:errors>
		</p>
    <p>
      <label for="numero3"><spring:message code="calculadora.numero3"/></label>
      <form:input type="number" path="numero3" /><form:errors path="numero3" cssClass="errorTootip"></form:errors>
    </p>
		<c:if test="${not empty resCalculadora}">
			<p><spring:message code="calculadora.resultado"/> <c:out value="${resCalculadora}"/></p>
		</c:if>
		<p>
			<form:button name="sumar" class="btn btn-default btn-lg active" role="button"><spring:message code="calculadora.sumar"/></form:button>
			<form:button name="restar" class="btn btn-default btn-lg active" role="button"><spring:message code="calculadora.restar"/></form:button>
			<form:button name="multiplicar" class="btn btn-default btn-lg active" role="button"><spring:message code="calculadora.multiplicar"/></form:button>
			<form:button name="dividir" class="btn btn-default btn-lg active" role="button"><spring:message code="calculadora.dividir"/></form:button>
		</p>
	</form:form>
</div>