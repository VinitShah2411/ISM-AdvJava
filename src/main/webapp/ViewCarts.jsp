<%@page import="bean.CartProductBean"%>
<%@page import="bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Carts</title>
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>

	<%
	ArrayList<CartProductBean> carts = (ArrayList<CartProductBean>) request.getAttribute("carts");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Items in Cart</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>ProductId</th>
							<th>ProductName</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						int total = 0;
						for (CartProductBean cart : carts) {
							total = total + cart.getPrice();
						%>
						<tr>
							<td><%=cart.getProductId()%></td>
							<td><%=cart.getProductname() %></td>
							<td><%=cart.getPrice()%></td>
							<td>
							<a href="DeleteCartController?cartId=<%=cart.getCartId()%>">Delete</a>
							</td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
				<h2>
					Total =
					<%=total%></h2>

				<a href="CheckOutController" class="btn btn-success">Checkout -
					Place Order</a>

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

</body>
</html>
</body>
</html>