<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>
<h5 align="center" style="color: blue;">${message}</h5>
	<form:form  method="post" modelAttribute="course">
		<table style="background-color: lightgrey; margin: auto;">
		<tr>
				<td>ID</td>
				<td><form:input  path="id" readonly="true"/></td>
			</tr>
		<tr>
				<td>Enter Course</td>
				<td><form:input  path="course" /></td>
			</tr>
			<tr>
				<td>Enter Subject</td>
				<td><form:input path="subjectname" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>