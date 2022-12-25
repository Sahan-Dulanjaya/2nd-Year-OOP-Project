package com.video;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteDetailsServlet")
public class deleteDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("videoid");
		
		boolean isTrue;
		
		isTrue = videoDBUtil.deleteVideo(id);
		
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
