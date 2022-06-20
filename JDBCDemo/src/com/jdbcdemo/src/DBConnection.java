package com.jdbcdemo.src;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static Connection getConnection(){
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "root");
		}catch(Exception e) {
			
		}
		return conn;
	}
	
}
