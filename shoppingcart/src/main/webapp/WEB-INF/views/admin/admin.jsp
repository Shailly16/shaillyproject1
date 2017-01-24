<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<body>
<div id="adminHome">
<a href="manageCategories">Manage Categories</a>&nbsp;&nbsp;
<a href="manageSuppliers">Manage Suppliers</a>&nbsp;&nbsp;
<a href="manageProducts">Manage Products</a>&nbsp;&nbsp;
</div>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="$(logoutUrl}" method="post" id="logoutForm">
<input type="hidden" name="${_csrf.parameterName}" value="$(_csrf.token}"/></form>

       
</body>
</html>