package com.flyaway.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.CustomerDao;
import com.flyaway.model.Customer;
import com.mysql.cj.Session;

@WebServlet("/saveCustomer")
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerDao dao= new CustomerDao();
		String name= request.getParameter("name");
		int isAdmin = Integer.parseInt(request.getParameter("is_admin"));
		String email= request.getParameter("email");
		String password_string= request.getParameter("password_string");
		String phoneno= request.getParameter("phoneno");
		
		Customer cust = new Customer(name, isAdmin, email, password_string, phoneno);
		
		if(dao.saveCustomer(cust) >0)
		{
			HttpSession session= request.getSession();
			session.setAttribute("user", cust);
			response.sendRedirect("success.jsp");
		}
		else
			response.sendRedirect("error.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
