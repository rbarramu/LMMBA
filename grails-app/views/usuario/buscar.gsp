
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
	<center>
	<div class="content scaffold-create" role="main">
			<h1>Buscar</h1>
			<g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
			<g:uploadForm action="Search" controller = "Usuario">
				<fieldset class="form">
                      <input type="text"  name="buscar" />
                      <select name = "tipo">
	                      <option value="Archivo" > Archivo</option><br>
	  					  <option value="Nombre"> Nombre</option><br>
	  					  <option value="Apellido"> Apellido</option><br>
	  				 </select>	  
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="Search" class="save" value="Buscar" />
				</fieldset>
			</g:uploadForm>
		</div>
	</center>
	</body>

</html>
