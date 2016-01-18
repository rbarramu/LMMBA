
<%@ page import="lmmba.Usuario" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<style type='text/css' media='screen'>
		#show-usuario {
				margin: 10em 8em 10em 8em;
			}
			</style>
	</head>
	<body>


		<sec:access expression="hasRole('ROLE_USER')">


		<div class="container">
		  <div class="row">
		    <div class="col-md-8 col-xs-10">
		      <div class="well panel panel-default">
		        <div class="panel-body">
		          <div class="row">
		            <!--/col--> 
		            <div class="col-xs-12 col-sm-8">
		              <h2> Perfil </h2>
		              <p><strong>Nombre completo: </strong> ${usuarioInstance?.nombres} ${usuarioInstance?.apellidoPaterno} ${usuarioInstance?.apellidoMaterno} </p>
		              <p><strong>Username: </strong> ${usuarioInstance?.username} </p>
		              <p><strong>Email: </strong> ${usuarioInstance?.email}</p>
		            </div>
		          </div>
		          <!--/row-->
		        </div>
		        <!--/panel-body-->
		      </div>
		      <!--/panel-->
		    </div>
		    <!--/col--> 
		  </div>
		  <!--/row--> 
		</div>
		<!--/container-->

		</sec:access>



		<sec:access expression="hasRole('ROLE_ADMIN')">
	
		<div id="show-usuario" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuario">
			
				<g:if test="${usuarioInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="usuario.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${usuarioInstance}" field="username"/></span>
					
				</li>
				</g:if>

			
				<g:if test="${usuarioInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="usuario.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${usuarioInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="usuario.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${usuarioInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="usuario.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${usuarioInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="usuario.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${usuarioInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
			</ol>



			<g:form url="[resource:usuarioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${usuarioInstance}"> <g:message code="default.button.edit.label" default="Edit" /> </g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>

		</sec:access>
	</body>
</html>
