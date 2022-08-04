package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.ProductDao;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productname = request.getParameter("productname");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int price = Integer.parseInt(request.getParameter("price"));
		String url = request.getParameter("imgUrl");
	//	System.out.println(productname);
		ProductDao productDao = new ProductDao();
		ProductBean productBean = new ProductBean();
		productBean.setProductname(productname);
		productBean.setQty(qty);
		productBean.setPrice(price);
		productBean.setImgUrl(url);
		System.out.print("product");
		productDao.insertProduct(productBean);
		request.setAttribute("msg","Product added");
		
		RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
		rd.forward(request, response);
	}
}
	
	
