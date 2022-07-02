package com.flyaway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightsDetailsDao;
import com.flyaway.model.FlightDetails;

@WebServlet("/searchflights")
public class GetFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String src = request.getParameter("src");
		String dest = request.getParameter("dest");
		String traveldate = request.getParameter("traveldate");
		
		int traveller = 0;
		if(request.getParameter("travellers")!=null) {
			traveller = Integer.parseInt(request.getParameter("travellers"));
		}
		
		if(src != null && dest != null && traveldate != null && traveller > 0) {
			FlightsDetailsDao fdd = new FlightsDetailsDao();
			
			request.setAttribute("availableflights", fdd.getFlights(src,dest));
			RequestDispatcher rd = request.getRequestDispatcher("bookflight.jsp");
		    rd.forward(request, response);
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
