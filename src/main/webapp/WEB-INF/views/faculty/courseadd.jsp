<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeLeaf.org">
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>   
<meta charset="ISO-8859-1">
<title>Course Add</title>
</head>
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			
		</tr>
	</table>
	<hr>
	<div class="container" align="center">
		<h1>Course Add</h1>
		<div class="card">
			<div class="card-body">
				<form action="#" th:action="@{/addcourse}" method="POST">

					<div class="form-group row">
						<label for="course" class="col-sm-2 col-form-label"> Course Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="course"
								placeholder="Enter Course Name">
						</div>
					</div>

					<div class="form-group row">
						<label for="subjectname" class="col-sm-2 col-form-label">Subject</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="subjectname"
								placeholder="Enter Subject">
						</div>
					</div>

					<br>
					<button type="submit">Submit</button>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>