package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		System.out.println(firstName);
		System.out.println(email);
		
		boolean isError = false;
		
		if(firstName == null || firstName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("firstNameError", "<font color='red'> Please Enter FirstName </Font>");
		}
		else
		{
			request.setAttribute("firstNameValue", firstName);
		}
		
		if(lastName == null || lastName.trim().length()==0)
		{
			isError = true;
			request.setAttribute("lastNameError", "<font color='red'> Please Enter LastName </Font>");
		}
		else
		{
			request.setAttribute("lastNameValue", lastName);
		}
		
		if(email == null || email.trim().length()==0)
		{
			isError = true;
			request.setAttribute("emailError", "<font color='red'> Please Enter Email </Font>");
		}
		else
		{
			request.setAttribute("emailValue", email);
		}
		
		if(password == null || password.trim().length()==0)
		{
			isError = true;
			request.setAttribute("passwordError", "<font color='red'> Please Enter password </Font>");
		}
		else
		{
			request.setAttribute("passwordValue", password);
		}
		
		if(gender == null)
		{
			isError = true;
			request.setAttribute("genderError", "Please Select Gender </Font>"); 
		}
		else
		{
			request.setAttribute("genderValue", gender);
		}
		
		RequestDispatcher rd = null;
		if(isError==true)
		{
			//go back
			rd = request.getRequestDispatcher("Signup.jsp");
		}
		else
		{
			UserDao userDao = new UserDao();
			
			UserBean userBean = new UserBean();
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userDao.insertUser(userBean);
			// go ahead
			// goto home.jsp
			request.setAttribute("msg","Signup Done" );
			rd = request.getRequestDispatcher("Login.jsp");
		}
		rd.forward(request, response);

		
		//set your data for accessing in next resource 
//		request.setAttribute("firstName", firstName);
//		request.setAttribute("email", email);
//		request.setAttribute("gender", gender);
	
		//goto home.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		
	}
}
		
		


