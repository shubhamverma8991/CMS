<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Faculty</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>
<h5 align="center" style="color: blue;">${message}</h5>
	<form:form  method="post" modelAttribute="user">
		<table style="background-color: lightgrey; margin: auto;">
		<tr>
				<td>ID</td>
				<td><form:input  path="id" readonly="true"/></td>
			</tr>
		<tr>
				<td>Enter Name</td>
				<td><form:input  path="name" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" showPassword="true"/></td>
			</tr>
			<tr>
				<td>SME</td>
				<td><form:input  path="sme" /></td>
			</tr>
			<tr>
				<td>Enter Experience</td>
				<td><form:input  path="experience" /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Gender</td>
				<td><form:input  path="gender" /></td>
			</tr>
			<tr>
				<td>Enter Age</td>
				<td><form:input  path="age"  /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Role</td>
				<td><form:input  path="role" readonly="true" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>