<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping cart</title>
</head>
<body>
// header.jsp
//product_menu.jsp
<c:if test="${!empty logoutMessage}">
<div class="alert alert-success">${logoutMessage}</div>   
</c:if>
<c:if test="${!empty successMsg}">
<div class="alert alert-success">${successMessage}</div>   
</c:if>
<c:if test="${not empty errorMsg}">
<div class="alert alert-error">${errorMessage}</div> 
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
<c:if test="${showLoginPage}">
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
<c:if test="${showRegisterPage}">
<jsp:include page="./Registeration.jsp"></jsp:include>
</c:if>
<c:if test="${isUserClickedHere==true}">
<%@ include file="./Registeration.jsp" %>
</c:if>
<c:if test="${isUserClickedHere==true || invalidCredentials==true}">
<%@ include file="./login1.jsp" %>
</c:if>
<c:if test="${!empty selectedProduct.name}">
<%@ include file="./selectedProduct.jsp" %>
</c:if>
<c:if test="${isAdmin==true}">
<%@ include file="./admin/admin.jsp" %>
</c:if>
<c:if test="${isAdminClickedCategories==true}">
<%@ include file="./admin/admin.jsp" %>
<%@ include file="./admin/category.jsp" %>
</c:if>
<c:if test="${isAdminClickedProducts==true}">
<%@ include file="./admin/admin.jsp" %>
<%@ include file="./admin/product.jsp" %>
</c:if>
<c:if test="${isAdminClickedSuppliers==true}">
<%@ include file="./admin/admin.jsp" %>
<%@ include file="./admin/supplier.jsp" %>
</c:if>
<c:if test="${displayCart==true}">
<%@ include file="./user/cart.jsp" %>
</c:if>

</body>
</html>