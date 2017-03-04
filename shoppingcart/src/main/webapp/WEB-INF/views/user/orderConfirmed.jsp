<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Order Confirmed</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">

 <div class="content">
 <div class="container">
 <div class="jumbotron">
 <h1> Order Confirmed,Product will be delivered shortly.</h1>
 Order # ${order.orderID}<br>
 Shipping Address : ${order.shippingAddress}<br>
 Billing Address : ${order.billingAddress}<br>
 <form:form><input type="submit" name="_eventId_toHome" value="Home"></input>
 </form:form>
 </div>
 </div>
 </div>
</div>

</body>
</html>