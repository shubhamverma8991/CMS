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
<title>Schedule</title>
</head>
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			
		</tr>
	</table>
	<hr>
	<div class="container">
	<h2 align="center">Schedule</h2>
	 <table class="table"> 

		 <tr>
			
			<th>Course</th>
			<th>Subject</th>
			<th>Faculty</th>
			<th>Venue</th>
			<th>Timing</th>
			<th>Date</th>
		</tr>
		 <c:forEach var="v" items="${requestScope.schedule}">
			<tr>
				
				<td>${v.course}</td>
				<td>${v.subject}</td>
				<td>${v.faculty}</td>
				<td>${v.venue}</td>
				<td>${v.timing}</td>
				<td>${v.date}</td>
				</tr>
		</c:forEach> 
	</table> 
</div>
</body>
</html>