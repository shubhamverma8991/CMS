<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Course</title>
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
	<h2>Course List</h2>
	<table class="table">

		<tr>
			<th>ID no</th>
			<th>Course</th>
			<th>Subject Name</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="v" items="${requestScope.course}">
			<tr>
				<td>${v.id}</td>
				<td>${v.course}</td>
				<td>${v.subjectname}</td>
				<td><a
					href="<spring:url value='/admin/updatecourse?vid=${v.id}'/>">Update</a></td>
				<td><a
					href="<spring:url value='/admin/deletecourse?vid=${v.id}'/>">Delete</a></td>

			</tr>
		</c:forEach>


		<%-- <tr>
			<c:forEach var="v" items="${requestScope.course}">
				<li>${v.course}<input type="radio" name="course" value="ID" /><br>
					<br>
				</li>
			</c:forEach>
		</tr>--%>
		<!-- <tr> 
			<td><input type="submit" value="Choose" /></td>
		</tr>-->
	</table>
</div>
	<h4 align="center">

		<a href="courseadd">Add new Course</a>
	</h4>

</body>
</html>