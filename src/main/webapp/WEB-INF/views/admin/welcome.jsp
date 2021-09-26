<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<h4 align="right">
		<a href="logout">Logout</a>
	</h4>
	<hr>
	<h1 align="center">Welcome Admin : ${user_details.name}</h1>
	<h3 align="center">
		<li><a href="admin/manageusers">Manage Users</a></li>
	</h3>
	<h3 align="center">
		<li><a href="admin/managecourse">Manage Course</a></li>
	</h3>
	<hr>

</body>
</html>