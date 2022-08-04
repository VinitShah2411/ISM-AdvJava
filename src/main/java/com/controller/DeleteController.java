package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartid = Integer.parseInt(request.getParameter("userid"));
		UserDao userDao = new UserDao();
		if(userDao.deleteUser(cartid))
		{
			request.setAttribute("msg","Deleted User Successfully");
		}
		else
		{
			request.setAttribute("msg","Some error Occured in Dao");
		}
		request.getRequestDispatcher("ListUserController").forward(request, response);
	}
}
		
