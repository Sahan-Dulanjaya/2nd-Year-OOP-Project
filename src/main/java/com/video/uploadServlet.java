package com.video;

import java.io.InputStream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.http.Part;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 1000, // 1 GB
maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB

public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String foldername = "resources";
		String uploadpath = request.getServletContext().getRealPath("") + foldername;
		
		File dir = new File(uploadpath);
		 if (!dir.exists()) {
             dir.mkdirs();
         }
		 
		Part filePart = request.getPart("filename");
		String videoname = request.getParameter("videoname");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String filename = filePart.getSubmittedFileName();
		String path = foldername + File.separator + filename;
		
		System.out.println("filename: " + filename);
		System.out.println("path: " + uploadpath);
		
		InputStream is = filePart.getInputStream();
		Files.copy(is, Paths.get(uploadpath + File.separator + filename), StandardCopyOption.REPLACE_EXISTING);
		
		boolean isTrue;
		
		isTrue = videoDBUtil.uploadVideo(videoname, filename, path, description, category);
		
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
