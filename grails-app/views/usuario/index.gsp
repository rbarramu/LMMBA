
<%@ page import="lmmba.Usuario" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
			<style type='text/css' media='screen'>
		#list-usuario {
				margin: 10em 8em 10em 8em;
			}
			</style>
	</head>
	<body>    
		
		<div id="list-usuario" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

	<g:if test="${usuario}">
	</g:if>		
	    <h1>Bienvenido Administrador, tienes ${usuario} usuarios esperando confirmación</h1>
			<table align="center" border=1 cellspacing=0>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'usuario.username.label', default: 'Username')}" />

						<g:sortableColumn property="nombres" title="${message(code: 'usuario.nombres.label', default: 'Nombres')}" />

						<g:sortableColumn property="apellidoPaterno" title="${message(code: 'usuario.apellidoPaterno.label', default: 'Apellido Paterno')}" />

						<g:sortableColumn property="apellidoMaterno" title="${message(code: 'usuario.apellidoMaterno.label', default: 'Apellido Materno')}" />

						<g:sortableColumn property="email" title="${message(code: 'usuario.email.label', default: 'Email')}" />
					
					
						<g:sortableColumn property="enabled" title="${message(code: 'usuario.enabled.label', default: 'Enabled')}" />
					

							
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usuarioInstance.id}">${fieldValue(bean: usuarioInstance, field: "username")}</g:link></td>

						<td>${fieldValue(bean: usuarioInstance, field: "nombres")}</td>

						<td>${fieldValue(bean: usuarioInstance, field: "apellidoPaterno")}</td>

						<td>${fieldValue(bean: usuarioInstance, field: "apellidoMaterno")}</td>

						<td>${fieldValue(bean: usuarioInstance, field: "email")}</td>
					
					
						<td><g:formatBoolean boolean="${usuarioInstance.enabled}" /></td>
					
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usuarioInstanceCount ?: 0}" />
			</div>
			<g:message action="count" code="${flash.message}" args="${flash.args}" />
		</div>
	</body>
</html>
