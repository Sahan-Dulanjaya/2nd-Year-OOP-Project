package com.video;

import java.sql.ResultSet;

import java.sql.DriverManager;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class videoDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Video> validate(String id){
		
		int convertedID = Integer.parseInt(id); 
		
		ArrayList<Video> vid = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
			String sql = "select * from video where id='"+convertedID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int idnew = rs.getInt(1);
				String videonamenew = rs.getString(2);
				String filenamenew = rs.getString(3);
				String pathnew = rs.getString(4);
				String descriptionnew = rs.getString(5);
				String categorynew = rs.getString(6);
				
				Video v = new Video(idnew, videonamenew, filenamenew, pathnew, descriptionnew, categorynew);
				vid.add(v);
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return vid;
	}
	
	
	
	
	public static boolean uploadVideo(String videoname, String filename, String path, String description, String category) {
		
		boolean isSuccess = false;
		PreparedStatement ps;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into video values(0,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, videoname);
			ps.setString(2, filename);
			ps.setString(3, path);
			ps.setString(4, description);
			ps.setString(5, category);
			
			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	
	
	public static boolean updateVideo(String id, String videoname, String filename, String path, String description, String category) {
		
		boolean isSuccess = false;
		
		
		try {
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
			String sql = "update video set videoname='"+videoname+"',filename='"+filename+"',description='"+description+"',category='"+category+"'"+ "where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public static boolean deleteVideo(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
			String sql = "delete from video where id='"+convertedID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}