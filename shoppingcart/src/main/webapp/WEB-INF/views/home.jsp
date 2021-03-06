<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bezzella:Beauty Shop</title>
<style>
body
{
    background: url('${pageContext.request.contextPath}/resources/img/background.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}

</style>
</head>
<body >
<%@ include file="./header.jsp" %>
<%@ include file="./Courosal.jsp"%>
<br>
<br>

   <div class="container">
  
<c:forEach items="${categoryList}" var="category">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> ${category.name} <span class="caret"></span></a>
   <ul class="dropdown-menu" role="menu">
     
						<c:forEach items="${productList}" var="product">
						<c:if test="${(product.category_id).equals (category.cid)}">
						
						<li><a href="<spring:url value="/display/${product.id}"/>">${product.name}</a></li>
						</c:if>
						</c:forEach>
						
					 </ul> 
			</c:forEach> 
     </div>
    <hr color="black" width="100" >
	${category.products}
	 
<c:if test="${!empty logoutMessage}">
<div class="alert alert-success">${logoutMessage}</div>   
</c:if>
<c:if test="${!empty successMsg}">
<div class="alert alert-success">${successMessage}</div>   
</c:if>
<c:if test="${!empty errorMessage}">
<div class="alert alert-error">${errorMessage}</div> 
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
<c:if test="${!empty selectedProduct.name}">
<%@ include file="./selectedProduct.jsp" %>
</c:if>
<c:if test="${isUserClickedRegisterHere==true}">
<%@ include file="./register.jsp" %>
</c:if>
<c:if test="${isUserClickedLoginHere==true || invalidCredentials==true}">
<div id="error">${errorMessage}</div>
<%@ include file="./login1.jsp" %>
</c:if>
 <c:if test="${isAdmin==true}">
<%@ include file="./admin/adminHome.jsp" %>
</c:if> 
<c:if test="${isAdminClickedCategories==true}">
<%@ include file="./admin/adminHome.jsp" %>
<%@ include file="./admin/category.jsp" %>
</c:if>
<c:if test="${isAdminClickedProducts==true}">
<%@ include file="./admin/adminHome.jsp" %>
<%@ include file="./admin/product.jsp" %>
</c:if> 
<c:if test="${isAdminClickedSuppliers==true}">
<%@ include file="./admin/adminHome.jsp" %>
<%@ include file="./admin/supplier.jsp" %>
</c:if>
 <%@ include file="./Footer.jsp" %>
</body>
</html>