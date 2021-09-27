<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DAC List</title>
</head>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			<th align="right" ><a href="logout">Logout</a></th>
		</tr>
	</table>
	<hr>
	 <table style="background-color: lightgrey; margin: auto;"> 

		 <tr>
			<th>ID</th>
			<th>Course</th>
			<th>Subject Name</th>
		</tr>
		 <c:forEach var="v" items="${requestScope.dac}">
			<tr>
				<td>${v.id}</td>
				<td>${v.course}</td>
				<td>${v.subjectname}</td>
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

</body>
</html>