<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Portal</title>
</head>
<%@ include file="../../../jsp/headerstudent.jsp" %>
<body>

<h2 align="center">Welcome Student : ${user_details.name}</h2>
<h4 align="center">
		<a href="viewcourse">View Course</a>
		</h4>
		<h4 align="center">
		<a href="viewnotice">View Notice</a>
		</h4>
		<h4 align="center">
		<a href="viewschedule">View Schedule</a>
		</h4>
		
</body>
<%@ include file="../../../jsp/footer.jsp" %>
</html>