<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-5">MY CART</div>
			<div class="col-md-3"></div>
		</div>


		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<sf:form modelAttribute="cart" method="post">


					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>

								<th>Description</th>
								<!-- <th>Category</th> -->

								<th>Price</th>
								<th>Stock</th>
								<th>Total Amount</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${sessionScope.cart.listitem}" var="product">
								<c:set var="sum"
									value="${sum+ product.p.price * product.quantity}"></c:set>
								<tr>
									<td>${product.p.id}</td>
									<td>${product.p.name}</td>
									<%-- 	<td>${product.p.brand}</td> --%>
									<td>${product.p.description}</td>
									<%-- <td>${product.p.category}</td> --%>
									<%-- <td>${product.p.color}</td> --%>
									<td>${product.p.price}</td>
									<td>${product.quantity}</td>
									<td>${product.p.price* product.quantity}</td>
									<td><a class="btn btn-danger"
										href="<c:url value='${session.getContextPath()}/delete/${product.p.id}' />">Delete
											<span class="glyphicon glyphicon-remove-sign"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

							<br>
							<br>
							<td><b>Total Amount::</td>
							<td><b>${sum}</td>
						</tr>
						<tr>
							<td></td>
							<td><input class="btn btn-info" name="_eventId_submit"
								type="submit" value="Next" /></td>
					</table>
					</sf:form>
			</div>

			<br>

			<!-- <div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4"> -->


			<!-- </div>
					</div>
				 -->



			<!-- </div>
			</div>
			 -->

			







			<%-- <form action="/myCart/add/{id}" method="get" commandName="Cart">
<c:set var="imageFolder" value="resources/img/" />
<table>
<tr>
<th align="left" width="80">Cart ID</th>
<th align="left" width="80">Product ID</th>
<th align="left" width="120">Product Name</th>
<th align="left" width="200">Date Added</th>
<th align="left" width="80">Price</th>
<th colspan="2" align="center" width="60">Action</th>

</tr>
<c:forEach items="${CartList}" var="cart">
<tr>
<td align="left">${cart.id}</td>
<td align="left">${cart.pid}</td>
<td align="left">${cart.productName}</td>
<td align="left">${cart.addedDate}</td>
<td align="left">${cart.price}</td>
<td align="left"><a href="<c:url value='/myCart/delete/${cart.id}' />">Delete</a></td>
<img alt="${selectedProduct.name}" src="${imageFolder}${selectedProduct.id}.png">
</tr>
</c:forEach>


</table>
<h2>Total cost : ${totalAmount}</h2>
<br>
 <a href="${session.getContextPath()}/shoppingcart/user/shippingAddress">next</a></div>
<a href="shippingAddress">Checkout</a> --%>
</body>
</html>