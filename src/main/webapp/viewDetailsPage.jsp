<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="ISO-8859-1">
<title>View Details</title>
</head>
<body>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<%
out.println("<html><body>");  

try 
{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videosystem", "root", "1234");  
    // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
    Statement stmt = con.createStatement();  
    ResultSet rs = stmt.executeQuery("select * from video");    %>
    <table align="center" border=2>  
    <tr><th>Video ID</th><th>Video Name</th><th>File Name</th><th>Path</th><th>Description</th><th>Category</th><tr>
   <% while (rs.next()) 
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
%>

<br><br><br>

<form action="validate" method=post>
<table width="400px" align="center" border=2>
<tr>
     <th align="center" colspan="2">Update Video Details</td>
   </tr>
   <tr>
     <td>Enter Video ID: </td>
     <td>
       <input type="number" name="videoid" required>
     </td>
   </tr>
   <tr>
     <td></td>
     <td>
       <input type="submit" value="submit">
     </td>
   </tr>
</form>
</table>

<br><br><br>

<form action="delete" method=post>
<table width="400px" align="center" border=2>
<tr>
     <th align="center" colspan="2">Delete Video Details</td>
   </tr>
   <tr>
     <td>Enter Video ID: </td>
     <td>
       <input type="number" name="videoid" required>
     </td>
   </tr>
   <tr>
     <td></td>
     <td>
       <input type="submit" value="submit">
     </td>
   </tr>
</form>
</table>
<br><br>
<table align="center">
<tr><th><a href="adminPanel.jsp">Go back to admin panel</a></th></tr>
</table>

</body>
</html>