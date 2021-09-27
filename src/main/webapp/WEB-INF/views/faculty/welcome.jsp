<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<table style="width: 100%">
		<tr>
			<!-- <th align="left"><a href="welcome">Back</a></th> -->
			<th align="right"><a href="logout">Logout</a></th>
		</tr>
	</table>
	<hr>
	<h2 align="center">Welcome Faculty : ${user_details.name}</h2>
	<h3 align="center">
		<a href="managestudent">Manage Student</a>
	</h3>
	<h3 align="center">
		<a href="managecourse">Manage Course</a>
	</h3>
</body>
</html>