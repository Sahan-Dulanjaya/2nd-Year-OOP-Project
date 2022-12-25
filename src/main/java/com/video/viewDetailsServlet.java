package com.video;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*; 


@WebServlet("/viewDetails")
public class viewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter out = res.getWriter();  
        res.setContentType("text/html");  
        out.println("<html><body>");  
        
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videosystem", "root", "1234");  
            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from video");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Video ID</th><th>Video Name</th><th>File Name</th><th>Path</th><th>Description</th><th>Category</th><tr>");  
            while (rs.next()) 
            {  
                int n = rs.getInt("id");  
                String nm = rs.getString("videoname");  
                String s = rs.getString("filename");
                String ss = rs.getString("path"); 
                String sss = rs.getString("description"); 
                String ssss = rs.getString("category"); 
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + ss + "</td><td>" + sss + "</td><td>" + ssss + "</td></tr>");   
            }  
            out.println("</table>");
           
            con.close();  
            
            out.println("<form></form>"); 
            
            out.println("</html></body>"); 
            
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
        
	}
	
	
}


