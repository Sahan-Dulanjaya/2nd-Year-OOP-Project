<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload a Video</title>
</head>
<body>
 <br><br><br><br>
 
 <form action="upload" method=post enctype="multipart/form-data">
 
 <table width="400px" align="center" border=2>
 
   <tr>
     <td align="center" colspan="2">Form Details</td>
   </tr>
   <tr>
     <td>Video Name </td>
     <td>
       <input type="text" name="videoname" required>
     </td>
   </tr>
   <tr>
     <td>Description </td>
     <td>
       <input type="text" name="description" required>
     </td>
   </tr>
   <tr>
     <td>Category </td>
     <td>
       <input type="text" name="category" required>
     </td>
   </tr>
   <tr>
     <td>Select Video </td>
     <td>
       <input type="file" name="filename" required>
     </td>
   </tr>
   <tr>
     <td></td>
     <td>
       <input type="submit" value="submit">
     </td>
   </tr>
   
 </table>
 
 </form> 
 
 <br>


</body>
</html>