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
	<hr>

</body>
</html>