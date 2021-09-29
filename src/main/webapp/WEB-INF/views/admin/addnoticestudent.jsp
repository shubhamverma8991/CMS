<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeLeaf.org">
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>   
<meta charset="ISO-8859-1">
<title>Add Notice Student</title>
</head>
<%@ include file="../../../jsp/header.jsp" %>
<body>
<table style="width: 100%">
		<tr>
			<th align="left"><a href="welcome">Back</a></th>
			
		</tr>
		
	</table>
	<div class="container" align="center">
		<h1>Add Notice For Student</h1>
		<div class="card">
			<div class="card-body">
				<form action="#" th:action="@{/addnoticestudent}" method="POST">

					<div class="form-group row">
						<label for="date" class="col-sm-2 col-form-label">Notice Date</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="date"
								placeholder="Enter Date">
						</div>
					</div>

					<div class="form-group row">
						<label for="topic" class="col-sm-2 col-form-label">Topic</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="topic"
								placeholder="Enter Topic">
						</div>
					</div>

					<div class=" form-group row">
						<label for="description" class="col-sm-2 col-form-label">Desciption </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								placeholder="Enter Description">
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