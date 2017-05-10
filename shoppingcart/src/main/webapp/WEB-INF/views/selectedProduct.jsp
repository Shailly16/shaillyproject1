<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>selected products</title>
</head>
<body>

<c:set var="imagefolder" value="/resource/images/" />
<table>
<tr>
<td><img alt="${selectedProduct.name}" src="${imageFolder}${selectedProduct.id}.jpg"></td>
<td><a class="col-xs-offset-5 btn btn-lg btn-success" href="cart_checkout">Checkout</a></td>
</tr>
<tr>
<td>Price:${selectedProduct.price}</td>
</tr>
<tr>
<td><a class="icon-shopping-cart" href="myCart/add/${selectedProduct.id}">Add To Cart</a></td>
</tr>
</table>

</body>
</html>