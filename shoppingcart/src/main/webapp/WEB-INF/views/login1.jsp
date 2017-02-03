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
</head>
<body>
Please Login
<br>
<c:url var="action" value="/validate"></c:url>
<%--<c:url var="action" value="/j_spring_security_check'> --%>
<form name='loginForm' action="${action}" method="post">

<div class="input-group margin-bottom-sm">
<span class="input-group-addon">
<i class="fa fa-envelope-o fa-fw"></i></span>
<input class="form-control" type="text" name="username" placeholder="User ID">
</div>
<div class="input-group">
<span class="input-group-addon">
<i class="fa fa-key fa-fw"></i></span>
<input class="form-control" type="password" name="password" placeholder="Password">
</div>
<input type="hidden" name="${_csrf.parameterName}"
value="${_csrf.token}"/><input type="submit"
class="btn btn-default" value="login">
</form>


