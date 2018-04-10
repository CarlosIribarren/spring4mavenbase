<%@ include file="../comun/templates/taglibs.jsp"%>

<div class="contenedor">
	<h3>
		<spring:message code="usuarios" />
	</h3>
	<spring:url var="urlXML" value="usuarios.xml"></spring:url>
	<spring:url var="urlJSON" value="usuarios.json"></spring:url>
	<spring:url var="urlPDF" value="usuarios/pdf"></spring:url>

	<p>
		( <a href="${urlPDF}" target="_blank" title="<spring:message code="index.pdf"/>"><spring:message code="index.pdf" /></a> 
		| <a href="${urlXML}" target="_blank" title="<spring:message code="index.xml"/>"><spring:message code="index.xml" /></a> 
		| <a href="${urlJSON}" target="_blank" title="<spring:message code="index.json"/>"><spring:message code="index.json" /></a> )
	</p>
	<table>
		<tr>
			<th><spring:message code="usuario.nombre" /></th>
			<th><spring:message code="usuario.apellido" /></th>
			<th><spring:message code="usuario.edad" /></th>
			<th class="opciones"><spring:message code="index.modificar" /></th>
			<th class="opciones"><spring:message code="index.eliminar" /></th>
			<th class="opciones"><spring:message code="index.visualizar" /></th>
		</tr>
		<c:forEach var="usuario" items="${usuarios}">
			<spring:url var="urlEdit" value="usuario/${usuario.nombre}/edit"></spring:url>
			<spring:url var="urlDelete" value="usuario/${usuario.nombre}/delete"></spring:url>
			<spring:url var="urlView" value="usuario/${usuario.nombre}"></spring:url>
			<tr>
				<td><c:out value="${usuario.nombre}"></c:out></td>
				<td><c:out value="${usuario.apellido}"></c:out></td>
				<td><c:out value="${usuario.edad}"></c:out></td>
				<td><a href="${urlEdit}">M</a></td>
				<td><a data-toggle="modal" href="#ventana-${usuario.nombre}">E</a></td>
				<td><a href="${urlView}">V</a></td>
			</tr>
			<div id="ventana-${usuario.nombre}" class="modal hide fade in" style="display: none">
				<div class="modal-header">
					<a class="close" data-dismiss="modal">×</a>
					<h3>
						<spring:message code="index.eliminar" />
					</h3>
				</div>
				<div class="modal-body">
					<p>
						¿<spring:message code="index.eliminar" /> ${usuario.nombre}?
					</p>
				</div>
				<div class="modal-footer">
					<a href="${urlDelete}" class="btn btn-success"><spring:message code="aceptar" /></a> 
					<a href="#" class="btn" data-dismiss="modal"><spring:message code="cancelar" /></a>
				</div>
			</div>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/usuario/new" class="btn btn-default btn-lg active" role="button" title="<spring:message code="nuevo" />"><spring:message code="nuevo"/></a>
</div>