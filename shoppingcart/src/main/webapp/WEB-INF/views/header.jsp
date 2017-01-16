<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <h5>Bellezza</h5>
    </div>
    <div class="collapse navbar-collapse" id="MyNavbar">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">100% Genuine</a></li>
      <li class="dropdown"><a href="#">Easy Returns</a>
       
      </li>
      <li><a href="#">Best Brands</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <c:if test="${empty loggedInUser}">
      <li><a href="login1"><span class="glyphicon glyphicon-user"></span>Login</a></li>
      </c:if>
       <c:if test="${!empty loggedInUser}">
       <span class="glyphicon glyphicon-shopping-cart"></span>
       <c:if test="${empty isAdmin}">
       <a href="myCart">MyCart</a><i class="fa fa-shopping-cart">${cartSize}</i>
      </c:if>
      </c:if>
      
      <c:if test="${empty loggedInUser}">
      <li><a href="Registeration"><span class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
    </ul>
   </c:if>
    </div>
    </div>
    </nav>
</head>
<body>

</body>
</html>