
<!DOCTYPE html>

<%@ page import="lmmba.Usuario" %>

<html>
	<head>
     
		<meta name="layout" content="main">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="bootstrap.css"/>
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>

    
	</head>

	<body>



<g:if test="${usuario}">
<h4>Bienvenido, ${usuario.nombres} ${usuario.apellidoPaterno} !</h4> 

<br> 
<div style=" text-align: center;">
<h4> Perfil: </h4> 
</g:if>
</div>

<g:if test="${usuario}">
<table align="center" border=1 cellspacing=0 >
<tr>
<td><strong>Username</strong></td>
<td><strong>Nombre completo</strong></td>
<td><strong>Email</strong></td>
<td><strong>Rut</strong></td>
<td><strong>Cargo</strong></td>
</tr>
<tr>
<td>${usuario.username}</td>
<td>${usuario.nombres} ${usuario.apellidoPaterno} ${usuario.apellidoMaterno}</td>
<td>${usuario.email}</td>
<td>${usuario.rut}</td>
<td>${cargo.nombre}</td>

</tr>
</table>
</g:if>


<g:link class="edit" action="edit" resource="${usuario}"> <g:message code="default.button.edit.label" default="Edit" /> </g:link>

	</body>

</html>
