<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeLeaf.org">
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register Faculty</title>
</head>
<%@ include file="../../../jsp/headerstudent.jsp" %>
<body>
<h5 align="center" style="color: green;">${message}</h5>
	<div class="container">
		<h1>Student Register Form:</h1>
		<div class="card">
			<div class="card-body">
				<form action="#" th:action="@{/register}" method="POST">

					<div class="form-group row">
						<label for="Name" class="col-sm-2 col-form-label"> Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="Name"
								placeholder="Enter Name">
						</div>
					</div>

					<div class="form-group row">
						<label for="Age" class="col-sm-2 col-form-label">Age</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="Age"
								placeholder="Enter Age">
						</div>
					</div>

					<div class="form-group row">
						<label for="gender" class="col-sm-2 col-form-label">Gender
						</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="gender"
								placeholder="Enter Gender">
						</div>
					</div>

					<div class=" form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email"
								placeholder="Enter Email">
						</div>
					</div>

					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Passwrod</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Address</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="address"
								placeholder="Enter Address">
						</div>
					</div>

					<div class="form-group row">
						<label for="phoneno" class="col-sm-2 col-form-label">Contact
							No</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="phoneno"
								placeholder="Enter Contact Address">
						</div>
					</div>

					<div class="form-group row">
						<label for="classx" class="col-sm-2 col-form-label">Class
							Xth Marks </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="classx"
								placeholder="Enter 10th Marks">
						</div>
					</div>

					<div class="form-group row">
						<label for="classxii" class="col-sm-2 col-form-label">Class
							XII th Marks </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="classxii"
								placeholder="Enter 12th Marks">
						</div>
					</div>



					<div class="form-group row">
						<label for="graduation" class="col-sm-2 col-form-label">Graduation
							Marks </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="graduation"
								placeholder="Enter Graduation Marks">
						</div>
					</div>

					<div class="form-group row">
						<label for="fathername" class="col-sm-2 col-form-label">
							Father Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="fathername"
								placeholder="Enter Father Name">
						</div>
					</div>

					<div class="form-group row">
						<label for="mothername" class="col-sm-2 col-form-label">
							Mother Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="mothername"
								placeholder="Enter Mother Name">
						</div>
					</div>

					<div class="form-group row">
						<label for="adharnumber" class="col-sm-2 col-form-label">Adhar
							No</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="adharnumber"
								placeholder="Enter Adhar Number">
						</div>
					</div>

					<div class="form-group row">
						<label for="coursename" class="col-sm-2 col-form-label">
							Course Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="coursename"
								placeholder="Enter Course Name">
						</div>
					</div>


					<h4 align="center">
						<button type="submit" class="btn btn-info" >Save
				</button>
						&ensp; <a href="login">Login</a>
					</h4>
				</form>
			</div>
		</div>
	</div>
</body>
</html>