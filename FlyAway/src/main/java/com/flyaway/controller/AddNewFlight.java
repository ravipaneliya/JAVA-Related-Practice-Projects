package com.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightsDetailsDao;
import com.flyaway.model.FlightDetails;

@WebServlet("/addnewflight")
public class AddNewFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flightnumber = Integer.parseInt(request.getParameter("flightnumber"));
		String airline = request.getParameter("airline");
		String src_code = request.getParameter("src_code");
		String dest_code = request.getParameter("dest_code");
		double ef = 0, pf = 0, bf = 0;

		if (request.getParameter("ecfare") != null && request.getParameter("ecfare").trim().length() > 0) {
			ef = Double.parseDouble(request.getParameter("ecfare"));
		}

		if (request.getParameter("prfare") != null && request.getParameter("prfare").trim().length() > 0) {
			pf = Double.parseDouble(request.getParameter("prfare"));
		}

		if (request.getParameter("bufare") != null && request.getParameter("bufare").trim().length() > 0) {
			bf = Double.parseDouble(request.getParameter("bufare"));
		}

		String weekdays = "";
		for (int i = 0; i <= 6; i++) {
			String key = "" + i;
			if (request.getAttribute(key) != null) {
				weekdays += i + ",";
			}
		}

		FlightDetails fd = new FlightDetails(flightnumber, airline, weekdays, src_code, dest_code, ef, pf, bf);
		FlightsDetailsDao fdd = new FlightsDetailsDao();
		
		if (fdd.addFlight(fd)) {
			request.setAttribute("success", true);
		} else {
			request.setAttribute("fail", true);
		}
		RequestDispatcher rd = request.getRequestDispatcher("addflight.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
