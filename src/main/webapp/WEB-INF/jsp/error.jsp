<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
  xmlns:th="http://www.thymeleaf.org">
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
		<link href="styles/restaurantStyles.css" rel="stylesheet" type="text/css" />
		<link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet"> 
     <title>Error page</title>
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
    
    
    
    <body style="text-align:center">
    <header class="jumbotron" style="background-color: #eb6c6c; margin-bottom: auto;">
           <h1 class="cursive" style="text-align: left;">Baked By Grace</h1>
		<h2 style="text-align: right;">Sweet Treats For Prices That Nobody Beats</h2>
	<!-- alerts using not using JS that it is built with it -->
	<p id="js_disabled_message">Site Best used with JavaScript</p>
		<script>
		document.getElementById('js_disabled_message').style.display = 'none';
		</script>
     </header>
      <nav>
		<a class="btn" href="/BakedByGrace/">Home</a>
		<a class="btn" href="/BakedByGrace/login">Register</a>
		<a class="btn" href="/BakedByGrace/order">Create An Order</a>
      </nav>
        
      <span th:text="${message}"></span>
        
    </body>
</html>