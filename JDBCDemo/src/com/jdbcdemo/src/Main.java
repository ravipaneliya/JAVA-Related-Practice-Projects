package com.jdbcdemo.src;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		System.out.println("Getting Connection..");
		Connection conn = DBConnection.getConnection();
		System.out.println("Connection Done..");
		Main m = new Main();
		m.readRecords(conn);
	}

	void readRecords(Connection conn) {
		try {
			PreparedStatement ps= conn.prepareStatement("insert into users (user) values(?)");
			ps.setString(1, "D");
			int res = ps.executeUpdate();
			System.out.println("Result : " + res);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	void insertRecord() {

	}
}
