<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Portal</title>
</head>
<body>
<table style="width: 100%">
		<tr>
			<!-- <th align="left"><a href="welcome">Back</a></th> -->
			<th align="right"><a href="logout">Logout</a></th>
		</tr>
	</table>
	<hr>
<h2 align="center">Welcome Student : ${user_details.name}</h2>
<h4 align="center">
		<a href="viewcourse">View Course</a>
		</h4>
</body>
</html>