package com.logindemo.src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String username = request.getParameter("usr");
		String password = request.getParameter("pwd");
		
		PrintWriter out= response.getWriter();
		
		if(username.equalsIgnoreCase("ravi") && password.equals("123")) {
			out.print("LOGGED IN Successfully...<br>");
			
			HttpSession hs = request.getSession();
			hs.setAttribute("usr", username);
			
			response.sendRedirect("dashboard");
		} else {
			out.print("<b>WRONG PASSWORD...</b>");
			RequestDispatcher dispatch= request.getRequestDispatcher("index.html");
			dispatch.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
