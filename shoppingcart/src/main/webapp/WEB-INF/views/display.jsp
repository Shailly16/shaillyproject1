<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product - ${product.name}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>

	
	<section class="container">

		<div class="row">
			<div class="col-md-6">
				<img src='<c:url value="/resources/img/${product.name}.png" />' alt="image" height="200" width="100" /> 
			</div>
			<div class="col-md-6">

				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.id}</span>
				</p>
				<p>
					<strong>category</strong> : ${product.category.name}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.stock}
				</p>
				<h4>${product.price}Rupees</h4>
				
					 <%-- <a href="<spring:url value="/myCart/add/${product.id}"/>" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"> </span>Add To Cart
					</a>  --%>
					
					<a href="${session.getContextPath()}/shoppingcart/order/${product.id}">add to cart</a></div>
				
			</div>
		</div>
	</section>
</body>
</html>