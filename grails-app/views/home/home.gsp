<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="dashboard.header" default="Bienvenido"/> </title>
    <style type="text/css" media="screen">
    #login {
        margin: 15px 0px;
        padding: 0px;
        text-align: center;
    }
    </style>
</head>
<body>
<g:if test="${admin}">
    <h1>Bienvenido Admin, tiene ${admin} usuario bloqueados</h1>
</g:if>	
<sec:link controller="usuario" expression="hasRole('ROLE_ADMIN')">Administrar Usuarios</sec:link>
<sec:link controller="usuario" expression="hasRole('ROLE_USER')">Manage Employee Information</sec:link>
</body>
</html>