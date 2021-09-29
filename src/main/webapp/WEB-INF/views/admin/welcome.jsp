<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>

	<br>
	<br>

	<h1 align="center">Welcome Admin : ${user_details.name}</h1>
	<h3 align="center">
		<li><a href="managefaculty">Manage Faculty</a></li>
	</h3>
	<h3 align="center">
		<li><a href="managestudent">Manage Student</a></li>
	</h3>
	<h3 align="center">
		<li><a href="managecourse">Manage Course</a></li>
	</h3>
	<h3 align="center">
		<li><a href="addnotice">Add Faculty Notice</a></li>
	</h3>
	<h3 align="center">
		<li><a href="addnoticestudent">Add Student Notice</a></li>
	</h3>
	<h3 align="center">
		<li><a href="addschedule">Add Schedule</a></li>
	</h3>
	
<br>
</body>
<%@ include file="../../../jsp/footer.jsp" %>
</html>