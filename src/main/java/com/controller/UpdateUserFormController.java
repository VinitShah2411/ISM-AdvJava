package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

@WebServlet("/UpdateUserFormController")
public class UpdateUserFormController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userid"));
		UserDao userDao = new UserDao();
		UserBean user = userDao.getUserByUserID(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
	}
}