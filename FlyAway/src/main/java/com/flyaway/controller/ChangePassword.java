package com.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.flyaway.dao.CustomerDao;

@WebServlet("/changepass")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String retypepass = request.getParameter("retypepass");
		
		int customerid = (int)request.getSession().getAttribute("userid");
		
		CustomerDao cust = new CustomerDao();
		if(newpass.equals(retypepass) && cust.updatePassword(customerid, oldpass, newpass) > 0) {
			request.setAttribute("success", true);
		} else {
			request.setAttribute("fail", true);
		}
		RequestDispatcher rd = request.getRequestDispatcher("changepass.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
