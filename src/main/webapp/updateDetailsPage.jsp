<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
   <table align="center" border=2>
   <c:forEach var="vid" items="${vidDetails}">
   
   <c:set var="id" value="${vid.id}"/>
   <c:set var="videoname" value="${vid.videoname}"/>
   <c:set var="filename" value="${vid.filename}"/>
   <c:set var="path" value="${vid.path}"/>
   <c:set var="description" value="${vid.description}"/>
   <c:set var="category" value="${vid.category}"/>
   
   <tr>
     <td>Video ID</td>
     <td>${vid.id}</td>
   </tr>
   <tr>
     <td>Video Name</td>
     <td>${vid.videoname}</td>
   </tr>
   <tr>
     <td>File Name</td>
     <td>${vid.filename}</td>
   </tr>
   <tr>
     <td>Path</td>
     <td>${vid.path}</td>
   </tr>
   <tr>
     <td>Description</td>
     <td>${vid.description}</td>
   </tr>
   <tr>
     <td>Category</td>
     <td>${vid.category}</td>
   </tr>
   
   </c:forEach>
   </table>
   
   <c:url value="updateDetails.jsp" var="vidupdate">   
      <c:param name="id" value="${id}"/>
      <c:param name="videoname" value="${videoname}"/>
      <c:param name="filename" value="${filename}"/>
      <c:param name="path" value="${path}"/>
      <c:param name="description" value="${description}"/>
      <c:param name="category" value="${category}"/>
   </c:url>
   
   
   <a href="${vidupdate}">
   <tr><td></td><td><input type="button" name="update" value="Update Video Data"></td></tr>
   </a>
   </table>

</body>
</html>