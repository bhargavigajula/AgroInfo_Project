<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.Employee"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Near Farmers Details</title>
<link rel="stylesheet" type="text/css" href="backstyle5.css">
</head>
<body>
<div class="bg-image"></div>
	<div class="bg-text">
    <center>
			<h2>Near Farmers Details</h2>
		</center>
	<table border=2 align=center>
		<tr>
			<th>FARMER NAME</th>
			<th>LOCATION</th>
			<th>MANDAL</th>
			<th>DISTRICT</th>
			<th>PRODUCT</th>
			<th>QUANTITY</th>
			<th>MOBILE NUMBER</th>
		</tr>
	    <c:forEach var="employee" items="${empList}">	
		<tr>
			<td>${employee.farmerName}</td>
			<td>${employee.location}</td>
			<td>${employee.mandal}</td>
			<td>${employee.district}</td>
			<td>${employee.product}</td>
			<td>${employee.quantity}</td>
			<td>${employee.farmerMobileNo}</td>
		</tr>
	</c:forEach>
	</table>
	<br>
		<form action="HomePage.html" method="post">
			<input type="submit" value="logout">
		</form>
	</div>
</body>
</html>