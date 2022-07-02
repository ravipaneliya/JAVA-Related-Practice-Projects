package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flyaway.model.FlightDetails;

public class FlightsDetailsDao {
	private Connection conn;

	public FlightsDetailsDao() {
		conn = DBConfig.getConnection();
	}

	public ArrayList<FlightDetails> getAllFlights() {
		ArrayList<FlightDetails> flightList = new ArrayList();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from flight_details;");
			flightList = executeQuery(stat);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return flightList;
	}
	
	public ArrayList<FlightDetails> getFlights(String src, String dest) {
		ArrayList<FlightDetails> flightList = new ArrayList();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from flight_details where src_airport_code = ? and dest_airport_code = ?;");
			stat.setString(1, src);
			stat.setString(2, dest);
			
			flightList = executeQuery(stat);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return flightList;
	}
	
	public ArrayList<FlightDetails> executeQuery(PreparedStatement stat) {
		ArrayList<FlightDetails> flightList = new ArrayList();
		try {
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				FlightDetails fd = new FlightDetails(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9));
				fd.setId(rs.getInt(1));
				flightList.add(fd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return flightList;
	}
}
