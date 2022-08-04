package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.UserDao;

public class DeleteCartController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		CartDao cartDao = new CartDao();
		if(cartDao.deletecartitem(cartId))
		{
			request.setAttribute("msg","Deleted cart Successfully");
		}
		else
		{
			request.setAttribute("msg","Some error Occured in Dao");
		}
		request.getRequestDispatcher("ViewCartController").forward(request, response);
	}
}
