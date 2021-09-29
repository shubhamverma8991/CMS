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
<title>Manage Student</title>
</head>
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>
<h5 align="center" style="color: red;">${message}</h5>
<table style="width: 100%">
		<tr>
		 <th align="left"><a href="welcome">Back</a></th> 
			
		</tr>
	</table>
	<hr>
	<div class="container">
	<h2>Student List</h2>
	<table class="table">
				<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>Class Xth Marks</th>
			<th>Class XII th Marks</th>
			<th>Graduation Marks</th>
			<th>Father Name</th>
			<th>Mother Name</th>
			<th>Adhar Number</th>
		</tr>
		<c:forEach var="v" items="${requestScope.student}">
			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.gender}</td>
				<td>${v.age}</td>
				<td>${v.address}</td>
				<td>${v.classx}</td>
				<td>${v.classxii}</td>
				<td>${v.graduation}</td>
				<td>${v.fathername}</td>
				<td>${v.mothername}</td>
				<td>${v.adharnumber}</td>
				<td><a
					href="<spring:url value='/admin/updatestudent?id=${v.id}'/>">Update</a></td>
				<td><a
					href="<spring:url value='/admin/deletestudent?vid=${v.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>