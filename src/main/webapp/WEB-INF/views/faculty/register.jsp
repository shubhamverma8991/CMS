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
<%@ include file="../../../jsp/headerfaculty.jsp" %>
<body>

<h5 align="center" style="color: green;">${message}</h5>
	<div class="container" align="center">
		<h1>Faculty Register Form:</h1>
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

					<!-- <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact
       No</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="contact"
        placeholder="Enter Contact Address">
      </div>
     </div> -->

					<div class="form-group row">
						<label for="sme" class="col-sm-2 col-form-label">Sme </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="sme"
								placeholder="Enter SME">
						</div>
					</div>

					<div class="form-group row">
						<label for="experience" class="col-sm-2 col-form-label">Experience
						</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="experience"
								placeholder="Enter Experience">
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

					<div class="form-group row">
						<label for="role" class="col-sm-2 col-form-label">Role </label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="role"
								placeholder="Enter Role">
						</div>
					</div>
					<br>
					<button type="submit">Submit</button>
					<h3>
						<a href="login">Login</a>
					</h3>
				</form>
			</div>
		</div>
	</div>
</body>
</html>