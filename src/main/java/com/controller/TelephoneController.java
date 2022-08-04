package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TelephoneBean;

public class TelephoneController extends HttpServlet {
	
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void Choice()
	{
		Scanner sc = new Scanner(System.in);
		 int Choice=0;
	
		System.out.println("1. Add new Contact");
		System.out.println("2. Edit Contact");
		System.out.println("3 Search Contact ");
		System.out.println("4 Remove Contact");
		System.out.println("5 Exit From App");
		System.out.println("----------------------");
		System.out.println("Enter Choice");
		Choice = sc.nextInt();
		switch (Choice) 
		{
			case 1:
				//String firstName = request.getParameter("firstName");
				//String lastName = request.getParameter("lastName");
				
				ArrayList<TelephoneBean> tb = new  ArrayList<>();
			//	tb.
				
				break;
	
			default:
				break;
		}
		
	}
}
