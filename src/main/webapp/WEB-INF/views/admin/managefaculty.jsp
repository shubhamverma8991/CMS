<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Manage Faculty</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>
<h5 align="center" style="color: red;">${message}</h5>
	<div class="container">
	<h3>Faculty List</h3>
<table class="table">
		
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Age</th>
			<th>SME</th>
			<th>Experience</th>
			<th>Role</th>
		</tr>
		<c:forEach var="v" items="${requestScope.faculty}">
			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.gender}</td>
				<td>${v.age}</td>
				<td>${v.sme}</td>
				<td>${v.experience}</td>
				<td>${v.role}</td>
				<td><a href="<spring:url value='/admin/updatefaculty?vid=${v.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/deletefaculty?vid=${v.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<h4 align="center">
		<a href="welcome">Back</a> 
	</h4>
</body>
</html>