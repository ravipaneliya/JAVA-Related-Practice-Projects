package com.flyaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flyaway.model.Customer;

public class CustomerDao {

	private Connection conn;

	public CustomerDao() {
		conn = DBConfig.getConnection();
	}

	public boolean saveCustomer(Customer cust) {
		try {
			PreparedStatement stat = conn.prepareStatement("insert into customers (name,is_admin,email,password_string,phoneno) values (?,?,?,?,?)");

			stat.setString(1, cust.getName());
			stat.setInt(2, cust.getIs_admin());
			stat.setString(3, cust.getemail());
			stat.setString(4, cust.getPassword_string());
			stat.setString(5, cust.getPhoneno());

			if(stat.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int updatePassword(int customerId, String oldPass, String newPass) {
		try {
			PreparedStatement stat = conn.prepareStatement("update customers set password_string = ? where id = ? and password_string = ?");
			stat.setString(1, newPass);
			stat.setInt(2, customerId);
			stat.setString(3, oldPass);
			return stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
