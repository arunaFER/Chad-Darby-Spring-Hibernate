package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
	
	public static void main(String[] args) {
		
		//url format = jdbc:mysql://mysql.db.server:3306/my_database?useSSL=false&serverTimezone=UTC
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String username = "hbstudent";
		String password = "hbstudent";
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection conn =
					DriverManager.getConnection(jdbcUrl, username, password);
			
			System.out.println("Connection successful!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
