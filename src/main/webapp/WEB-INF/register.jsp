<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<title>Registration Page</title>
</head>
<body>
<h1>THIS IS WHERE NEW USERS REGISTER</h1>
    <form:form modelAttribute="user" method="post">
		<label for="textinput1">
	          Enter username:
	    </label>
    	<form:input path="username" />
    	<label for="textinput2">
	          Enter Password:
	    </label>
        <form:input path="password" />
        <label for="textinput3">
	          Enter Email:
	    </label>
        <form:input path="email" />
        <label for="textinput4">
	          Enter Phone:
	    </label>
        <form:input path="phone" />
        <label for="textinput5">
	          Enter First Name:
	    </label>
        <form:input path="firstName" />
        <label for="textinput6">
	          Enter Last Name:
	    </label>
        <form:input path="lastName" />
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
        <a href ="/BakedByGrace/">Return to Home Page</a>
    </form:form>
</body>
</html>