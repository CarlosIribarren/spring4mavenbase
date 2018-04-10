<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3>
		<spring:message code="datos" />
	</h3>
	<form:form action="" method="POST" modelAttribute="datos">
		<!-- checkbox -->
		<form:checkboxes items="${datosChkList}" path="datosChk"/>
		<br>
		<c:if test="${not empty resChk}">
			<c:forEach var="chk" items="${resChk}">
				<p><c:out value="${chk}"></c:out></p>
			</c:forEach>
		</c:if>
		<br><br>

		<!-- radioButton -->
		<form:radiobuttons items="${datosRadList}" path="datosRad"/>
		<br>
		<c:if test="${not empty resRad}">
			<p><c:out value="${resRad}"></c:out></p>
		</c:if>
		<br><br>

		<!-- select -->
		<form:select items="${datosSelList}" path="datosSel" multiple="false" />
		<br>
		<c:if test="${not empty resSel}">
			<p><c:out value="${resSel}"></c:out></p>
		</c:if>
		<br><br>
		
		<!-- select -->
		<form:textarea path="datosTextarea" rows="5" cols="30"/> 
		<br>
		<c:if test="${not empty resTxt}">
			<p><c:out value="${resTxt}"></c:out></p>
		</c:if>
		<br><br>
		
		<form:button name="aceptar" class="btn btn-default btn-lg active" role="button"><spring:message code="aceptar"/></form:button>
	</form:form>
</div>
