<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
</head>
<body>
	<h3 align="center">Course List</h3>
	<table style="background-color: lightgrey; margin: auto;">

		<!-- <tr>
			<th>ID</th>
			<th>Course Name</th>
		</tr> -->
		<%-- <c:forEach var="v" items="${requestScope.course}">
			<tr>
				<td>${v.id}</td>
				<td>${v.course}</td>
				<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td>
			</tr>
		</c:forEach> --%>


		<tr>
			<c:forEach var="v" items="${requestScope.course}">
				<li>${v.course}<input type="radio" name="course" value="ID" /><br>
					<br>
				</li>
			</c:forEach>
		</tr>
		<tr>
			<td><input type="submit" value="Choose" /></td>
		</tr>
	</table>

</body>
</html>