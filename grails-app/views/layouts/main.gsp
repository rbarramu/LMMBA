
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="LMMBA"/></title>
		

		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<asset:stylesheet src="bootstrap.min.css"/>
  		<asset:stylesheet src="bootstrap.css"/>
  		<asset:stylesheet src="bootstrap-theme.css"/>
  		<asset:stylesheet src="bootstrap-social.css"/>
  		<asset:stylesheet src="font-awesome.css"/>
		<asset:javascript src="bootstrap.min.js"/>
		<asset:javascript src="bootstrap.js"/>
		<asset:javascript src="bootstrap.min.js"/>
	
		<g:layoutHead/>
		<style type='text/css' media='screen'>
		#page-body {
				margin: 10em 8em 10em 8em;
			}

		#create-usuario {
      
    text-align: center;
    padding: 70px 50px 50px 26px;
    background-color: #f7f7ff;
    margin: 0px 0 14px 0;
    color: #2e3741;
    
    font-weight: bold;
        
  }


    .footerwrap {
  background-color: #222222;
  color: #7b8f9d;
border-top: 5px solid #999;
 padding: 50px 0;

}

.footerwrap h4 { color: #fff; }



    </style>
			
	</head>
	<body>
	<div id="grailsLogo" role="banner">
		
		<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >LMMBA</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="home"><a href="${createLink(uri: '/')}"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li><a href="../lmmba/historia">Historia</a></li>
        <li><a href="${createLink(uri: '/integrantes')}">Integrantes</a></li>
        <li><a href="#">Ubicación</a></li>
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<sec:ifNotLoggedIn>
        <li><a class ="user" href="${createLink(uri: '/usuario/create')}"><span class="glyphicon glyphicon-user"></span> Regístrate</a></li>
        <li><a class="user" href="${createLink(uri: '/create')}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
        <sec:ifAllGranted roles="ROLE_USER">
		  <li><g:link controller="usuario" action="profile" ><span class="glyphicon glyphicon-user"></span> Mi perfil </g:link> </li>


			</sec:ifAllGranted>
		 <sec:ifAllGranted roles="ROLE_USER">
		  <li><g:link controller="usuario" action="buscador" ><span class="glyphicon glyphicon-user"></span> Buscar</g:link> </li>


			</sec:ifAllGranted>
		 <sec:ifAllGranted roles="ROLE_USER">
		  <li><g:link controller="document" action="list" ><span class="glyphicon glyphicon-user"></span> Subir archivo </g:link> </li>

			</sec:ifAllGranted>	
		  	<sec:ifAllGranted roles="ROLE_ADMIN">
		  <li><g:link controller="usuario" action="profile" ><span class="glyphicon glyphicon-user"></span> Mi perfil </g:link> </li>
		  <li><sec:link controller="usuario" expression="hasRole('ROLE_ADMIN')"><span class="glyphicon glyphicon-user"></span> Administrar Usuarios </sec:link></li>

		   <li><a expression="hasRole('ROLE_ADMIN')" href="${createLink(uri: '/usuario/create')}" ><span class="glyphicon glyphicon-user"></span> Nuevo usuario </a></li>
		  </sec:ifAllGranted>
		<li><a class="user" href="${createLink(uri: '/logout')}"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </sec:ifLoggedIn>



      </ul>
    </div>
  </div>
</nav>
	<g:layoutBody/>

	<div id='page-body'>



	<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</div>
<footer>
	<section id="footerwrap">
		<div class="footerwrap">

		<p class="pull-right"></p> 
	
	<div class="container">
		<div class="row">

			<div class="col-xs-6 col-md-6">
				<h4>Contáctenos</h4><br>
					<div class="row">
                        <p class="col-md-12 col-xs-12">
                            <span class="glyphicon glyphicon-home"></span>       
                                 Av. España 1680, Edificio B, 3° piso,<br> Universidad Técnica Federico Santa María<br>
                                   Valparaíso</p>
                        <p class="col-md-12 col-xs-12">
                            <span class="glyphicon glyphicon-earphone"></span>
									<span class="fono"> Fono:  xxxxx</span><br>
						</p>
							<p class="col-md-12 col-xs-12">
								<span class="glyphicon glyphicon-envelope"></span><span class="contacto"> contacto@lmmba.cl </span></p>
				
					</div><!-- row adentro-->
			</div>
		
			
			<div class="col-xs-6 col-md-6">	
			<h4>Síguenos en las redes sociales</h4>
				<a class="btn btn-social-icon btn-sm btn-facebook" onclick="_gaq.push(['_trackEvent', 'btn-social-icon', 'click', 'btn-sm']);"><i class="fa fa-facebook"></i></a>
  				<a class="btn btn-social-icon btn-sm btn-twitter" onclick="_gaq.push(['_trackEvent', 'btn-social-icon', 'click', 'btn-sm']);"><i class="fa fa-twitter"></i></a>
  				<a class="btn btn-social-icon btn-sm btn-google-plus" onclick="_gaq.push(['_trackEvent', 'btn-social-icon', 'click', 'btn-sm']);"><i class="fa fa-google-plus"></i></a>		
			

			</div>
		</div><!-- row afuera -->
		
	</div>
	</div>
	</section>
</footer>


	</body>
</html>
