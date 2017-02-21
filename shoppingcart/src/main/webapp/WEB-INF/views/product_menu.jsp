<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	
	

	 <%-- <ul class="nav nav-pills" role="tablist">
	<c:forEach items="${categoryList}" var="category">
	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
     <ul class="dropdown-menu" role="menu">
     
						<c:forEach items="${product.getCategory().getName()}" var="product">
						<c:if test="${category.name}.equals(product.getCategory_id())"></c:if>
						<li><a href="manage_products/get/${product.id}">${product.name}</a></li>
						<c:out value="${product.name}"></c:out>
						</c:forEach>
					 </ul> 
			</c:forEach> 
     

									
							
					
					</ul>
			 --%>
			 
 

			 
           
		
	</div>
	<hr color="blue" width="100" >
	${category.products}

</body>
</html>

	