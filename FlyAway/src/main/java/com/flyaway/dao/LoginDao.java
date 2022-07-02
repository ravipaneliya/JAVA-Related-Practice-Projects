package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flyaway.model.Customer;
import com.flyaway.model.FlightDetails;

public class LoginDao {
	private Connection conn;

	public LoginDao() {
		conn = DBConfig.getConnection();
	}

	public Customer validateUser(int isadmin, String email, String pass) {
		try {
			PreparedStatement stat = conn.prepareStatement("select * from customers where is_admin = ? and email = ? and password_string = ?;");
			stat.setInt(1, isadmin);
			stat.setString(2, email);
			stat.setString(3, pass);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				Customer c = new Customer(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
				c.setId(rs.getInt(1));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
}
