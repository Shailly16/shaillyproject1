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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Bellezza</a>
    </div>
    <div class="collapse navbar-collapse" id="MyNavbar">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">100% Genuine</a></li>
      <li class="dropdown"><a href="#">Easy Returns</a>
       
      </li>
      <li><a href="#">Best Brands</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
  
      <li><a href="login1"><span class="glyphicon glyphicon-user"></span>Login</a></li>
      <li><a href="Registeration"><span class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
    </ul>
   
    </div>
    </div>
    </nav>



${successMsg}

<c:if test="${not empty errorMsg}">
    ${errorMsg}
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
<c:if test="${showLoginPage}">
<jsp:include page="login1.jsp"></jsp:include>
</c:if>
<c:if test="${showRegisterPage}">
<jsp:include page="Registeration.jsp"></jsp:include>
</c:if>
</body>
</html>