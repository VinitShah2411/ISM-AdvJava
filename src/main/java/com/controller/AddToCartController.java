package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import dao.CartDao;


public class AddToCartController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId =Integer.parseInt(request.getParameter("productId"));
		
		HttpSession session = request.getSession(); 
		int userId = (Integer) session.getAttribute("userId");
	//	System.out.println(userId);
		
		CartBean cart = new CartBean();
		cart.setProductId(productId);
		cart.setUserId(userId);
		
		CartDao cartDao = new CartDao();
		cartDao.AddToCart(cart);
		
		response.sendRedirect("ListProductController");
	}

}
