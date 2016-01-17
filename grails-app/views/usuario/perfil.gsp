
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

</g:if>


<g:if test="${usuario}">

  
<div class="container">
  <div class="row">
    <div class="col-md-8 col-xs-10">
      <div class="well panel panel-default">
        <div class="panel-body">
          <div class="row">
            <!--/col--> 
            <div class="col-xs-12 col-sm-8">
              <h2> Mi Perfil </h2>
              <p><strong>Nombre completo: </strong> ${usuario.nombres} ${usuario.apellidoPaterno} ${usuario.apellidoMaterno} </p>
              <p><strong>Username: </strong> ${usuario.username} </p>
              <p><strong>Rut: </strong> ${usuario.rut} </p>
              <p><strong>Email: </strong> ${usuario.email}</p>
              <p><strong>Cargo: </strong> ${cargo.nombre}</p>
              <p><strong>Área de investigación: </strong> ${area.nombre}</p>
            </div>

            <div class="col-xs-12 col-sm-4">
            <g:link class="edit" action="edit" resource="${usuario}"><button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Edita tu perfil </button> </g:link>
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

</g:if>


	</body>

</html>
