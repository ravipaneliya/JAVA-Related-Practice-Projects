package com.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.CustomerDao;
import com.flyaway.dao.FlightsDetailsDao;
import com.flyaway.model.Customer;
import com.flyaway.model.FlightDetails;

@WebServlet("/registercustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String phoneno = request.getParameter("phoneno");
		
		if(pass1.equals(pass2)) {
			Customer c = new Customer(fname, 0, email, pass1, phoneno);
			CustomerDao cd = new CustomerDao();
			
			if (cd.saveCustomer(c)) {
				request.setAttribute("result", 1);
			} else {
				request.setAttribute("result", 2);
			}
		} else {
			request.setAttribute("result", 3);
		}
		RequestDispatcher rd = request.getRequestDispatcher("registercustomer.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
