package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.OrderDao;

public class CheckOutController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		System.out.println(userId);
		
		OrderDao orderDao = new OrderDao();
		orderDao.PlaceOrder(userId);
		
		//remove all data from cart - userId 
		
				// order detail 
				
				// home -> order success 
				response.sendRedirect("OrderSuccessPlace.jsp");
	}

	

}
