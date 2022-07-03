package com.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightsDetailsDao;
import com.flyaway.dao.LoginDao;
import com.flyaway.model.Customer;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isadmin = request.getParameter("isadmin");
		
		if(username != null && password != null && isadmin != null) {
			LoginDao ld = new LoginDao();
			Customer cust = ld.validateUser(Integer.parseInt(isadmin), username, password);
			if(cust != null) {
				request.getSession().setAttribute("userid", cust.getId());
				request.getSession().setAttribute("user", cust.getName());
				request.getSession().setAttribute("isadmin", cust.getIs_admin());
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			    rd.forward(request, response);
			} else {
				request.setAttribute("loginerror", "Invalid Email or Password");
				request.setAttribute("isadmin", isadmin);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			    rd.forward(request, response);	
			}
		} else {
			request.setAttribute("loginerror", "Email or Password Empty");
			request.setAttribute("isadmin", isadmin);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		    rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
