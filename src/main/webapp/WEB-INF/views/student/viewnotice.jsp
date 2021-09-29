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
<title>Notice</title>
</head>
<%@ include file="../../../jsp/headerstudent.jsp" %>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			
		</tr>
	</table>
	<hr>
	<div class="container">
	<h2 align="center">Notice Board</h2>
	 <table class="table"> 

		 <tr>
			
			<th>Date</th>
			<th>Topic</th>
			<th>Description</th>
		</tr>
		 <c:forEach var="v" items="${requestScope.studentnotice}">
			<tr>
				
				<td>${v.date}</td>
				<td>${v.topic}</td>
				<td>${v.description}</td>
				</tr>
		</c:forEach> 
	</table> 
</div>
</body>
</html>