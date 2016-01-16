<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		  <asset:stylesheet src="bootstrap.css"/>
		    <asset:stylesheet src="bootstrap-social.css"/>
		    <asset:stylesheet src="font-awesome.css"/>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 10em 8em 10em 8em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}

			
/* Carousel base class */
.carousel {
  height: 500px;
 
  margin-top: -20px;
}
/* Since positioning the image, we need to help out the caption */
.carousel-caption {
  z-index: 10;
}

/* Declare heights because of positioning of img element */
.carousel .item {
  height: 500px;
  background-color: #777;
}
.carousel-inner > .item > img {
  position: absolute;
  top: 0;
  left: 0;
  min-width: 100%;
  height: 500px;
}





/* FOOTER
-------------------------------------------------- */

.footerwrap {
  background-color: #222222;
  color: #7b8f9d;
border-top: 5px solid #999;
 padding: 50px 0;

}

.footerwrap h4 { color: #fff; }


.social{
	position:relative;
	top:1px;
	display:inline-block;
	font-family:'Glyphicons Social';
	font-style:normal;
	font-weight:normal;
	line-height:1;
	vertical-align:top;
	speak:none;
	-webkit-font-smoothing:antialiased;
	-moz-osx-font-smoothing:grayscale
}

.social.x05{
	font-size:12px
}

.social.x2{
	font-size:48px
}

.social.x3{
	font-size:72px
}

.social.x4{
	font-size:96px
}

.social.x5{
	font-size:120px
}

.social-facebook:before{
	content:"\E031"
}

.social-twitter:before{
	content:"\E032"
}

 span.icon:before { 

            font-family: 'Glyphicons Halflings'; 

            content: "\f015"; 

          }

		</style>
	</head>
    <body>
        
     
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
 
    <div class="item active">
      <img src="${assetPath(src: 'lab4.jpg')}" alt="lmmba" width="460" height="345">
    </div>

    <div style="min-height: 320px;" class="item">
      <img src="${assetPath(src: 'convenio.jpg')}" alt="convenio" width="460" height="345">
    </div>

     <div class="item">
      <img src="${assetPath(src: 'lab2.jpg')}" alt="lab2" width="460" height="345">
    </div>

     <div class="item">
      <img src="${assetPath(src: 'LMMBA.jpg')}" alt="lab3" width="460" height="345">
    </div>

     <div class="item">
      <img src="${assetPath(src: 'lab3.jpg')}" alt="lab4" width="460" height="345">
    </div>
  
  </div>


            <div class="carousel-caption">
              <h1>Laboratorio de Microbiología Molecular y Biotecnología Ambiental</h1>
              <p></p>
            </div>
          
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



        <div id="page-body" role="main">
            <h1>Bienvenido a LMMBA</h1>
            <p>El laboratorio MMBA de la Universidad Técnica Federico Santa María estudia la degradación bacteriana de contaminantes orgánicos persistentes, química ambiental, genómica y proteómica funcional.</p>
        </div>


    </body>
</html>
