<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Registration Page</title>
</head>
<body>
<!-- 	<h1>THIS IS WHERE NEW USERS REGISTER</h1> -->
<%-- 	<form:form modelAttribute="login" method="post"> --%>
<!-- 		<label for="textinput1"> Enter username: </label> -->
<%-- 		<form:input path="username" /> --%>
<!-- 		<label for="textinput2"> Enter Password: </label> -->
<%-- 		<form:input path="password" /> --%>
<!-- 		<p> -->
<!-- 			<input type="submit" value="Submit" /> <input type="reset" -->
<!-- 				value="Reset" /> -->
<!-- 		</p> -->
<%-- 	</form:form> --%>

	<div class="panel-body">

		<form action="doLogin" method="post">

			<fieldset>

				<legend>Please sign in</legend>

<%-- 				<c:if test="${not empty error}"> --%>

<!-- 					<div class="alert alert-danger"> -->

<!-- 						<spring:message -->
<!-- 							code="AbstractUserDetailsAuthenticationProvider.badCredentials" /> -->

<!-- 						<br /> -->

<!-- 					</div> -->

<!-- 				</c:if> -->

				<div class="form-group">

					<input class="form:input-large" placeholder="User Name"
						name='username' type="text">

				</div>

				<div class="form-group">

					<input class=" form:input-large" placeholder="Password"
						name='password' type="password" value="">

				</div>

				<input class="btn" type="submit" value="Login">

			</fieldset>

		</form>

	</div>
</body>
</html>