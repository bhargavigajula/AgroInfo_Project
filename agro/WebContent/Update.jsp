<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trmandalansitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update details</title>
<link rel="stylesheet" type="text/css" href="backstyle6.css">
</head>
<body>
<div class="bg-image"></div>
	<div class="bg-text">
<form action="UpdateServlet" method = "post">
<center>
        <center>
			<h2>Update Details</h2>
		</center>
	farmerName: &nbsp;<input type = "text" name = "farmerName" value=${employee.farmerName}><br/><br/>
	location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "location" value=${employee.location}><br/> <br/>
	mandal: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "mandal" value=${employee.mandal}><br/><br/>
	district: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "district" value=${employee.district}><br/><br/>
	product: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "product" value=${employee.product}><br/><br/>
	quantity: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "quantity" value=${employee.quantity}><br/><br/>
	MobileNo: &nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" name = "farmerMobileNo" value=${employee.farmerMobileNo}><br/><br/>
	
	<input type="submit" value="Update">
	</center>
	</form>
	<br>
		<form action="HomePage.html" method="post">
			<input type="submit" value="logout">
		</form>
</div>
</body>
</html>