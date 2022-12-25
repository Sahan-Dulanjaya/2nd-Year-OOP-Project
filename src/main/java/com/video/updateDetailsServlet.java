package com.video;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetailsServlet")
public class updateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("vidid");
		String videoname = request.getParameter("vidname");
		String filename = request.getParameter("filename");
		String path = request.getParameter("path");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		
		boolean isTrue;
		
		isTrue = videoDBUtil.updateVideo(id, videoname, filename, path, description, category);
		
        if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("successful.jsp");
			dis.forward(request, response);
		}
		else {

			RequestDispatcher dis = request.getRequestDispatcher("unsuccessful.jsp");
			dis.forward(request, response);
		}
	}

}
