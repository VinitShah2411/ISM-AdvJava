<%@page import="bean.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	id="bootstrap-css
	https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js
	https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js
">
<style type="text/css">
.error {
	color: red;
}

body {
	background: rgb(99, 39, 120)
}

.form-control:focus {
	box-shadow: none;
	border-color: #BA68C8
}

.profile-button {
	background: rgb(99, 39, 120);
	box-shadow: none;
	border: none
}

.profile-button:hover {
	background: #682773
}

.profile-button:focus {
	background: #682773;
	box-shadow: none
}

.profile-button:active {
	background: #682773;
	box-shadow: none
}

.back:hover {
	color: #682773;
	cursor: pointer
}

.labels {
	font-size: 11px
}

.add-experience:hover {
	background: #BA68C8;
	color: #fff;
	cursor: pointer;
	border: solid 1px #BA68C8
}
</style>

</head>
<body>
	<%
	UserBean user = (UserBean) request.getAttribute("user");
	String genderValue = user.getGender();
	%>
	<form method="post" action="UpdateUserController">
	<input type="hidden" value="${user.userId }" name="userId">
	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Edit Details</h4>
					</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels">First Name</label> <input type="text"
									name="firstName" class="form-control" placeholder="First Name"
									value="${user.firstName}">
							</div>
							<div class="col-md-6">
								<label class="labels">Last Name</label> <input type="text"
									name="lastName" class="form-control" placeholder="Last Name"
									value="${user.lastName}">
							</div>
						</div>

						<div class="row mt-3">
							<div class="col-md-12">
								<label class="labels">Email</label> <input type="email"
									class="form-control" placeholder="Email Id"
									value="${user.email}" disabled> 
							</div>
							<div class="col-md-12">
								<label class="labels">Password</label> <input type="password"
									name="password"  class="form-control" placeholder="Password"
									value="${user.password}"> 
							</div>
							<div class="col-md-12">
								<label class="labels">Gender</label> <br> Male<input
									type="radio" name="gender" value="male"
									<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />
								Female<input type="radio" name="gender" value="female"
									<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />
							</div>
						</div>


						<div class="mt-5 text-center">
							<button class="btn btn-primary profile-button" type="submit"
								value="Update User">Save Profile</button>
						</div>
				</div>
			</div>

		</div>
	</div>
</form>
</body>
</html>


