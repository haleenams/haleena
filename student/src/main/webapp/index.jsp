<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="log" action="logAction" method="post">
	<table border="1">
		<tr>
		<c:if test="${not empty val}">
					<input type="hidden" name="id" value="${id}">
			</c:if>
    		
			<td>Name</td>
			<td><input type="text" name="name" value="${name}">
			  			
    			</td>
		
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="pass" value="${pass}"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="Enter"></td>
		</tr>
	</table>
	<a href="view">view</a>
</form>
</body>
</html>