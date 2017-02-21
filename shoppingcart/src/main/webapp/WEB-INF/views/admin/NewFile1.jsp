<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body >
<ul class="nav nav-pills" role="tablist">
	<c:forEach items="${categoryList}" var="category">
	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
     <ul class="dropdown-menu" role="menu">
     <c:out value="${product.getCategory().getName()}"></c:out>
     
     <c:forEach items="${product.getCategory().getName()}" var="product">
     
     <li><a href="manage_product/get/${product.id}">${product.name}</a></li> 
     </c:forEach>
     </ul>
     </li>
     </c:forEach>
     </ul>
     </body>
     </html>