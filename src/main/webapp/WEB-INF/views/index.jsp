<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/admin.css"> 
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../../js/bootstrap.min.js"></script>    
<meta charset="UTF-8">
<title>Welcome Page</title>
<style>
a:link, a:visited {
  background-color: purple;
  color: white;
  padding: 5px 15px;
  text-align: center;
  text-decoration:blink;
  display:inline-block;
}

a:hover, a:active {
  background-color: #d0c8df;
}
</style>
</head>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../../jsp/headerindex.jsp" %>
<body>
	<h1 align="center">
	Welcome to CMS
	</h1>
	<!-- <div> <img src="/1.jpeg" style='width:100%;height:100%'/> 
 -->	<h3 align="center">
		<a href="admin/login">Admin Login</a>
          &emsp; <!-- for space -->
	
		<a href="faculty/login">Faculty Login</a>
	&emsp;
	
		<a href="student/login">Student Login</a>
	</h3>
	<!-- </div> -->
	
	<br>
<br><br>
<br><br>
<br><br>
<br>


</body><%@ include file="../../jsp/footer.jsp" %> 
</html>