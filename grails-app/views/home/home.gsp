<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="dashboard.header" default="Welcome to Grails Webinar"/> </title>
    <style type="text/css" media="screen">
    #login {
        margin: 15px 0px;
        padding: 0px;
        text-align: center;
    }
    </style>
</head>
<body>
<sec:link controller="admin" expression="hasRole('ROLE_ADMIN')">Admin Services</sec:link>
<sec:link controller="usuario" expression="hasRole('ROLE_USER')">Manage Employee Information</sec:link>
</body>
</html>