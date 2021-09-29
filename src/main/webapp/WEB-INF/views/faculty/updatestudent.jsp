<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>
<h5 align="center" style="color: blue;">${message}</h5>
	<form:form  method="post" modelAttribute="student">
		<table style="background-color: lightgrey; margin: auto;">
		<tr>
				<td>ID</td>
				<td><form:input  path="id" readonly="true"/></td>
			</tr>
		<tr>
				<td>Enter Name</td>
				<td><form:input  path="name" /></td>
			</tr>
			<tr>
				<td>Enter Gender</td>
				<td><form:input path="gender"  /></td>
			</tr>
			<tr>
				<td>Enter Age</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input  path="address" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><form:input  path="email" readonly="true"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" showPassword="true" readonly="true"/></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Class Xth Marks</td>
				<td><form:input  path="classx" /></td>
			</tr>
			<tr>
				<td>Enter Class XII th Marks</td>
				<td><form:input  path="classxii"  /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Graduation Marks</td>
				<td><form:input  path="graduation"  /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Father Name</td>
				<td><form:input  path="fathername"  /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Mother Name</td>
				<td><form:input  path="mothername"  /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter AdharCard Number</td>
				<td><form:input  path="adharnumber" readonly="true" /></td>
			</tr>
			<tr>
			<tr>
				<td>Enter Course </td>
				<td><form:input  path="coursename" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>