package com.video;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String urls = "jdbc:mysql://localhost:3306/videosystem";
	private static String userName = "root";
	private static String passWord = "1234";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(urls, userName, passWord);
			
		}
		
		catch (Exception e) {
			
			System.out.println("Connecting to database failed!");
		}
		
		return con;
	}
}
