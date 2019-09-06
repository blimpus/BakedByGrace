<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">

<title>Order Page</title>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>THIS IS WHERE THE ORDER FORM WILL GO</h1>
	<h1>Form</h1>
    <form:form modelAttribute="order" method="post">
		<label for="textinput1">
	          Enter Name:
	    </label>
    	<form:input path="name" />
    	<label for="textinput2">
	          Enter Email:
	    </label>
        <form:input path="email" />
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form:form>
    
	     <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</body>
</html>