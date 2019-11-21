<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student List</h1>  
<table border="1">  
<tr><th>id<th>Name</th><th>pass</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="list" items="${list}">   
   <tr>
   <td>${list.id}</td>    
   <td>${list.name}</td>  
   <td>${list.pass}</td>    
   <td><a href="editlist/${list.id}">Edit</a></td>  
   <td><a href="deletelist/${list.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="index">Add New student</a>  
</body>
</html>