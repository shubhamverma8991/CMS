<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeLeaf.org">
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>   
<meta charset="ISO-8859-1">
<title>Add Schedule</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			
		</tr>
		
	</table>
	<div class="container" align="center">
		<h1>Add Schedule</h1>
		<div class="card">
			<div class="card-body">
				<form action="#" th:action="@{/addschedule}" method="POST">

					<div class="form-group row">
						<label for="course" class="col-sm-2 col-form-label">Course Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="course"
								placeholder="Enter Course">
						</div>
					</div>

					<div class="form-group row">
						<label for="subject" class="col-sm-2 col-form-label">Subject</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="subject"
								placeholder="Enter Subject">
						</div>
					</div>

					<div class=" form-group row">
						<label for="faculty" class="col-sm-2 col-form-label">Faculty </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="faculty"
								placeholder="Enter Faculty Name">
						</div>
					</div>
					
					<div class=" form-group row">
						<label for="venue" class="col-sm-2 col-form-label">Venue </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="venue"
								placeholder="Enter Venue">
						</div>
					</div>
					
					<div class=" form-group row">
						<label for="timing" class="col-sm-2 col-form-label">Timing</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="timing"
								placeholder="Enter Timing">
						</div>
					</div>
					
					<div class=" form-group row">
						<label for="date" class="col-sm-2 col-form-label">Date </label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="date"
								placeholder="Enter Date">
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