package com.flyaway.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.BookinDetailsDao;
import com.flyaway.model.Ticket;

@WebServlet("/showbookings")
public class ShowBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int customerid = (int)request.getSession().getAttribute("userid");
    	int isadmin = (int)request.getSession().getAttribute("isadmin");
		
		BookinDetailsDao bdd = new BookinDetailsDao();
		ArrayList<Ticket> tickets = bdd.getAllBokings(customerid, isadmin);
		request.setAttribute("tickets", tickets);
		RequestDispatcher rd = request.getRequestDispatcher("showbookings.jsp");
	    rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
