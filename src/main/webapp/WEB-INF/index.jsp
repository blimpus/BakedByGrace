<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Baked By Grace</title>
		<!-- Bootstrap CDN copied from https://getbootstrap.com/docs/4.1/getting-started/download/ -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link href="styles/restaurantStyles.css" rel="stylesheet" type="text/css" />
		<link href="//fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet"> 
		
		<style>
			nav {
				border-top: thin #5b7d87 solid;
				border-bottom: thin #5b7d87 solid;
				padding-top: 12px;
				padding-bottom: 12px;
			}
			nav .btn{
				background-color: #eb6c6c;
				color: #fef9ff;
			}
			nav .btn:hover {
				font-weight: bold;
			}
			
			#wrapper {
				background-color: #dad4d3;
			}
			
			.cursive {
				font-family: 'Great Vibes', cursive;
			}
		</style>
</head>
<body>
	<header class="jumbotron" style="background-color: #eb6c6c; margin-bottom: auto;">
           <h1 class ="cursive" style="text-align: left;">Baked By Grace</h1>
		<h2 style="text-align: right;">Sweet Treats For Prices That Nobody Beats</h2>
	<!-- alerts using not using JS that it is built with it -->
	<p id="js_disabled_message">Site Best used with JavaScript</p>
		<script>
		document.getElementById('js_disabled_message').style.display = 'none';
		</script>
     </header>
     
     
      <nav>
		<a class="btn" href="/BakedByGrace/login">Login</a>
		<a class="btn" href="/BakedByGrace/register">Register</a>
		<a class="btn" href="/BakedByGrace/order">Create An Order</a>
      </nav>
	
		 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</body>
</html>