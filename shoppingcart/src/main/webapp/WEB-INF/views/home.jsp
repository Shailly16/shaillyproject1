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
<a href="login1">Login</a>
<br>
<a href="register">register</a>
${successMsg}
<c:if test="${showRegisterationPage}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${ not empty errorMsg}">
    ${errorMsg}
<jsp:include page="login1.jsp"></jsp:include>
</c:if>


<c:if test="${showLoginPage}">
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
</body>
</html>