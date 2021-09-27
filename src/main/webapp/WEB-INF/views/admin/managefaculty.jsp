<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Faculty</title>
</head>
<body>
<table style="width: 100%">
		<tr>
		 <th align="left"><a href="welcome">Back</a></th> 
			<th align="right"><a href="logout">Logout</a></th>
		</tr>
	</table>
	<hr>
<table style="background-color: lightgrey; margin: auto;">
		<caption>Faculty List</caption>
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
</body>
</html>