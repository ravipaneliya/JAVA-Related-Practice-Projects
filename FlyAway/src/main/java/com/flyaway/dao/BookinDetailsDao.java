package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flyaway.model.Ticket;

public class BookinDetailsDao {
	private Connection conn;

	public BookinDetailsDao() {
		conn = DBConfig.getConnection();
	}

	public boolean insertBookingDetails(int flightid, double seatprice, String traveldate, int travellers, int customerid) {
		try {
			String sql = " INSERT INTO booking_details "
					+ " (`flight_id`, `booking_class`, `travel_date`, `no_of_passanger`, `total_fare`, `customer_id`) "
					+ " SELECT id, IF(economy_fare = ?,'Economy',IF(premium_fare = ?,'Premium',IF(business_fare = ?,'Business',NULL))), ?, ?, ?, ? "
					+ " FROM flight_details WHERE id = ?;";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setDouble(1, seatprice);
			stat.setDouble(2, seatprice);
			stat.setDouble(3, seatprice);
			stat.setString(4, traveldate);
			stat.setInt(5, travellers);
			stat.setDouble(6, seatprice*travellers);
			stat.setInt(7, customerid);
			stat.setInt(8, flightid);
			
			if(stat.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public Ticket getLastBooking(int customerid) {
		Ticket tkt = null;
		try {
			PreparedStatement stat = conn.prepareStatement("SELECT bd.id, c.name, c.phoneno, bd.booking_class, bd.travel_date, "
					+ " bd.booking_date, bd.no_of_passanger, bd.total_fare "
					+ " FROM booking_details bd "
					+ " JOIN customers c ON c.id = bd.customer_id "
					+ " WHERE c.id = ? "
					+ " ORDER BY bd.id DESC LIMIT 1;");
			stat.setInt(1, customerid);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				tkt = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tkt;
	}
	
	public ArrayList<Ticket> getAllBokings(int customerid, int isadmin) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		String condition = "";
		if(isadmin == 0) {
			condition = " WHERE c.id = " + customerid + " ";
		}
		try {
			PreparedStatement stat = conn.prepareStatement("SELECT bd.id, c.name, c.phoneno, bd.booking_class, bd.travel_date, "
					+ " bd.booking_date, bd.no_of_passanger, bd.total_fare "
					+ " FROM booking_details bd "
					+ " JOIN customers c ON c.id = bd.customer_id "
					+ condition + " ORDER BY bd.id DESC;");
			
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				Ticket tkt = new Ticket(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8));
				tickets.add(tkt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
}
