<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>

	<%
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-9">
				<h2 align="center">List Users</h2>

				<table class="display" id="users">
					<thead class="thead-light">
						<tr>
							<th>UserId</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>Email</th>
							<th>Gender</th>
							<th>UserType</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (UserBean user : users) {
						%>
						<tr>
							<td><%=user.getUserId()%></td>
							<td><%=user.getFirstName()%></td>
							<td><%=user.getLastName()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getGender()%></td>
							<td><%=user.getUserType() %></td>
						<td><a href="DeleteController?userid=<%=user.getUserId()%>">Delete</a> |
						<a href="UpdateUserFormController?userid=<%=user.getUserId() %>"> Update</a>
						 </td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>