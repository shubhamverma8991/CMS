<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>  
<meta charset="UTF-8">
<title>Faculty Login</title>
</head>
<body>
	<%--Form will be submitted to the def action /user/login --%>
	<h1 align="center">Faculty Login</h1>
	<br>
	<div class="container">
	<form method="post">
		<table style=" margin: auto ;with:80%">
			
			<tr>
				<td>Enter Email</td>
				<td></td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td></td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		
		<h5 align="center">
		<button type="submit" class="btn btn-info" value ="Login">Login
		</button>
		<!-- <input  type="submit" value="Login" /> -->
		&emsp;
	<a href="register">Register new User</a>
	</h5>
	
	</form>
</div>
</body>
</html>