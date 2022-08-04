package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.OrderDao;

public class MyOrdersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		ArrayList<OrderBean> orders = orderDao.getMyOrders(userId);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("MyOrders.jsp").forward(request, response);
	}
}