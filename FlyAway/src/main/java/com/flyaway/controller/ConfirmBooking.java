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

@WebServlet("/confirmbooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightid = Integer.parseInt(request.getParameter("fid"));
		double seatprice = Double.parseDouble(request.getParameter("seatclass"));
		String traveldate = request.getParameter("traveldate");
		int travellers = Integer.parseInt(request.getParameter("travellers"));
		int customerid = (int)request.getSession().getAttribute("userid");
		
		Ticket tkt = null;
		BookinDetailsDao bdd = new BookinDetailsDao();
		if(bdd.insertBookingDetails(flightid, seatprice, traveldate, travellers, customerid)) {
			tkt = bdd.getLastBooking(customerid);
			request.setAttribute("ticket", tkt);
			RequestDispatcher rd = request.getRequestDispatcher("showbookings.jsp");
		    rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
