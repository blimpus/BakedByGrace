<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">

<title>Registration Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link href="styles/restaurantStyles.css" rel="stylesheet" type="text/css" />
		<link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet"> 
		
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
			input {
				width: 25%
			}
			* {
			  box-sizing: border-box;
			}
			
			input[type=text], select, textarea {
			  width: 100%;
			  padding: 12px;
			  border: 1px solid #ccc;
			  border-radius: 4px;
			  resize: vertical;
			}
			
			label {
			  padding: 12px 12px 12px 0;
			  display: inline-block;
			}
			
			input[type=submit] {
			  background-color: #4CAF50;
			  color: white;
			  padding: 12px 20px;
			  border: none;
			  border-radius: 4px;
			  cursor: pointer;
			  float: right;
			}
			
			input[type=submit]:hover {
			  background-color: #45a049;
			}
			input[type=reset] {
			  background-color: #4CAF50;
			  color: white;
			  padding: 12px 20px;
			  border: none;
			  border-radius: 4px;
			  cursor: pointer;
			  float: right;
			}
			
			input[type=reset]:hover {
			  background-color: #45a049;
			}
			input[type=password]{
				width: 100%;
			  padding: 12px;
			  border: 1px solid #ccc;
			  border-radius: 4px;
			  resize: vertical;
			}
			
			.container {
			  border-radius: 5px;
			  background-color: #f2f2f2;
			  padding: 20px;
			}
			
			.col-25 {
			  float: left;
			  width: 25%;
			  margin-top: 6px;
			  padding-left:12px;
			}
			
			.col-75 {
			  float: left;
			  width: 75%;
			  margin-top: 6px;
			  padding-right:12px;
			  
			}
			
			/* Clear floats after the columns */
			.row:after {
			  content: "";
			  display: table;
			  clear: both;
			}
			
			.container {
				padding: 12px;
			}
			
			/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
			@media screen and (max-width: 600px) {
			  .col-25, .col-75, input[type=submit] {
			    width: 100%;
			    margin-top: 0;
			  }
			}
			
			.cursive {
				font-family: 'Great Vibes', cursive;
			}
		</style>
</head>
<body>
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
      
     <div class="container" style="margin-top:16px;">
		<h1>REGISTER AS NEW USER</h1>
	
	    <form:form modelAttribute="user" method="post">
	    	<div class="row">
	    		<div class="col-25">
				<label for="textinput1">
			          Enter Username:
			    </label>
			    </div>
			    <div class="col-75">
		    	<form:input path="username" />
		    	</div>
	    	</div>
	    	<div class="row">
	    		<div class="col-25">
		    	<label for="textinput2">
			          Enter Password:
			    </label>
			    </div>
			    <div class="col-75">
		        <form:input path="password" type="password"/>
		        </div>
	        </div>
	    	<div class="row">
	    		<div class="col-25">
		        <label for="textinput3">
			          Enter Email:
			    </label>
			    </div>
			    <div class="col-75">
		        <form:input path="email" />
		        </div>
	        </div>
	    	<div class="row">
	    		<div class="col-25">
		        <label for="textinput4">
			          Enter Phone:
			    </label>
			    </div>
			    <div class="col-75">
		        <form:input path="phone" />
		        </div>
	        </div>
	    	<div class="row">
	    		<div class="col-25">
		        <label for="textinput5">
			          Enter First Name:
			    </label>
			    </div>
			    <div class="col-75">
		        <form:input path="firstName" />
		        </div>
	        </div>
	    	<div class="row">
	    		<div class="col-25">
		        <label for="textinput6">
			          Enter Last Name:
			    </label>
			    </div>
			    <div class="col-75">
		        <form:input path="lastName" />
		        </div>
	        </div>
	        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	        <a href ="/BakedByGrace/">Return to Home Page</a>
	    </form:form>
    </div>
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</body>
</html>