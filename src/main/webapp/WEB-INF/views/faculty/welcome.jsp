<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>

	<h2 align="center">Welcome Faculty : ${user_details.name}</h2>
	<h3 align="center">
		<a href="managestudent">Manage Student</a>
	</h3>
	<h3 align="center">
		<a href="managecourse">Manage Course</a>
	</h3>
	<h3 align="center">
	<a href="addnoticestudent">Add Student Notice</a>
	</h3>
	<h3 align="center">
	<a href="viewnotice">View Notice</a>
	</h3>
	<h3 align="center">
	<a href="viewschedule">View Schedule</a>
	</h3>
</body>
<%@ include file="../../../jsp/footer.jsp" %>
</html>