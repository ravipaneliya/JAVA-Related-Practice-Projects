package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
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
	
	public boolean addFlight(FlightDetails fd) {
		try {
			PreparedStatement stat = conn.prepareStatement("INSERT INTO flight_details (`flight_number`, `airline`, `weekdays`, `src_airport_code`, `dest_airport_code`, `economy_fare`, `premium_fare`, `business_fare`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			stat.setInt(1, fd.getFlight_number());
			stat.setString(2, fd.getAirline());
			stat.setString(3, fd.getWeekdays());
			stat.setString(4, fd.getSrc_airport_code());
			stat.setString(5, fd.getDest_airport_code());
			
			if(fd.getEconomy_fare() > 0)
				stat.setDouble(6, fd.getEconomy_fare());
			else
				stat.setNull(6,java.sql.Types.NULL);
			
			if(fd.getPremium_fare() > 0)
				stat.setDouble(7, fd.getPremium_fare());
			else
				stat.setNull(7,java.sql.Types.NULL);
			
			if(fd.getBusiness_fare() > 0)
				stat.setDouble(8, fd.getBusiness_fare());
			else
				stat.setNull(8,java.sql.Types.NULL);
			
			if(stat.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
