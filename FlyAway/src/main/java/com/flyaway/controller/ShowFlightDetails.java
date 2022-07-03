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
import com.flyaway.dao.FlightsDetailsDao;
import com.flyaway.model.FlightDetails;
import com.flyaway.model.Ticket;

@WebServlet("/showflights")
public class ShowFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isadmin = (int)request.getSession().getAttribute("isadmin");
		if(isadmin == 1) {
			FlightsDetailsDao fdd = new FlightsDetailsDao();
			ArrayList<FlightDetails> flights = fdd.getAllFlights();
			request.setAttribute("flights", flights);
			RequestDispatcher rd = request.getRequestDispatcher("showflights.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
