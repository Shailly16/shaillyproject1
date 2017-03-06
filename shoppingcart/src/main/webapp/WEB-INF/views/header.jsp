<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
 <a class="navbar-brand" href="#">Bellezza</a>
    </div>
    <div class="collapse navbar-collapse" id="MyNavbar">
    <ul class="nav navbar-nav">
    <li class="active"><a href="home">Home</a></li>
    <li class="active"><a href="contact">ContactUs</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <c:if test="${empty loggedInUser}">
      <li><a href="login1"><span class="glyphicon glyphicon-user"></span>Login</a></li>
      </c:if>
       <c:if test="${!empty loggedInUser}">
       <span class="glyphicon glyphicon-shopping-cart"></span>
       <c:if test="${isAdmin==false}">
      <li><a href="cart_checkout"><span class="glyphicon glyphicon-shopping-cart"></span>${cartSize}</a></li>
      </c:if>
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
     <!-- <li><a href=j_spring_security_logout><span class="glyphicon glyphicon-log-out"></span>Logout</a></li> -->
       </c:if>
      
      
      <li><a href="register"><span class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
      
     
    </ul>
   
    </div>
    </div>
    </nav>
</body>
</html>