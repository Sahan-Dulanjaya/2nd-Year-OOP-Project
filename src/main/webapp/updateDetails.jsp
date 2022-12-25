<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
     String id = request.getParameter("id");
     String videoname = request.getParameter("videoname");
     String filename = request.getParameter("filename");
     String path = request.getParameter("path");
     String description = request.getParameter("description");
     String category = request.getParameter("category");
  %>


<form action="update" method=post>

  Video ID <input type="text" name="vidid" value="<%=id %>" readonly><br>
  Video Name <input type="text" name="vidname" value="<%=videoname %>"><br>
  File Name <input type="text" name="filename" value="<%=filename %>"><br>
  Path <input type="text" name="path" value="<%=path %>" readonly><br>
  Description <input type="text" name="description" value="<%=description %>"><br>
  Category <input type="text" name="category" value="<%=category %>"><br>
  
  <input type="submit" name="submit" value="Update Video Data"><br>
  
</form>

</body>
</html>