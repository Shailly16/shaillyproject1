<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style >
body
{
    background: url('${pageContext.request.contextPath}/resources/img/login wallpaper.jpg') fixed;
    background-size: cover;
    
    padding: 0;
    margin: 0;
}
</style>
</head>
<body>
<%@ include file="./header.jsp" %>


<c:url var="action" value="/validate"></c:url>
<%-- //<c:url var="action" value="/j_spring_security_check'>  --%>
<form name='loginForm' action="${action}" method="post">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Login</h1>
        </div>
         <div class="modal-body">
             <div class="form-group">
             <input class="form-control" type="text" name="username" placeholder="User ID">
             </div>

             <div class="form-group">
                 <input class="form-control" type="password" name="password" placeholder="Password">
             </div>

             <div class="form-group">
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Login"/>
                 <span class="pull-right"><a href="register">Register</a></span>
             </div>
         </div>
    </div>
 </div>
</form>
<br>
<br>
<%@ include file="./Footer.jsp" %>

</body>
</html>


