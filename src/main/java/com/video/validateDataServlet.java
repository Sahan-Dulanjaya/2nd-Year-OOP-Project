package com.video;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/validateDataServlet")
public class validateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String id = request.getParameter("videoid");
		
		try {
		List<Video> vidDetails = videoDBUtil.validate(id);
		request.setAttribute("vidDetails", vidDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("updateDetailsPage.jsp");
		dis.forward(request, response);
		
		}	
		
	}

 
 