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
  <style>
  </style>
</head>
<body>
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="icon-toggle"></span>
</button>
<a class="navbar-brand" href="#">Bellezza</a>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav navbar-right">
<li class="dropdown">
<a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
<ul id="account-menu" class="dropdown-menu" role="menu">
<li><a href="#">My Profile</a></li>
</ul>
</li>
<li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
</ul>
</div>
</div>
</div>
<div class="container">
<div class="row">
<div class="col-md-3">
<a href="#"><strong></i>Menu</strong></a>  
<hr>
<ul class="list-unstyled">
<li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
<h5>Settings <i class="glyphicon glyphicon-chevron-down"></i></h5>
</a>
<ul class="list-unstyled collapse in" id="userMenu">
<li class="active"> <a href="#"><i class="glyphicon glyphicon-home"></i> Home</a></li>
<li><a href="#"><i class="glyphicon glyphicon-envelope"></i> Messages <span class="badge badge-info">0</span></a></li>
<li><a href="#"><i class="glyphicon glyphicon-user"></i> Members <span class="badge badge-info">0</span></a></li>               
<li><a href="#"><i class="glyphicon glyphicon-flag"></i> Transactions</a></li>
<li><a href="#"><i class="glyphicon glyphicon-mail"></i> Mail</a></li>
<li><a href="#"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
</ul>
</li>
<li class="nav-header">
<a href="#" data-toggle="collapse" data-target="#menu3">
<h5>Social Media <i class="glyphicon glyphicon-chevron-right"></i></h5>
</a>
<ul class="list-unstyled collapse" id="menu3">
<li><a href="#"><i class="glyphicon glyphicon-circle"></i> Facebook</a></li>
<li><a href="#"><i class="glyphicon glyphicon-circle"></i> Twitter</a></li>
</ul>
</li>
<li class="nav-header">
<a href="#" data-toggle="collapse" data-target="#menu3">
<h5>Addition<i class="glyphicon glyphicon-chevron-right"></i></h5>
</a>
<ul class="list-unstyled collapse" id="admin_manage">
<li><a href="manage_categories"><i class="glyphicon glyphicon-circle"></i>ManageCategories</a></li>
<li><a href="manage_product"><i class="glyphicon glyphicon-circle"></i>ManageProduct</a></li>
<li><a href="manage_supplier"><i class="glyphicon glyphicon-circle"></i>ManageSupplier</a></li>
</ul>
</li>
</ul>
</div>
<div class="col-md-9">
<ul class="list-inline pull-right">
<li><a href="#"><i class="glyphicon glyphicon-cog"></i></a></li>
<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-comment"></i><span class="count">0</span></a><ul class="dropdown-menu" role="menu"><li></li></ul></li>
<li><a href="#"><i class="glyphicon glyphicon-user"></i></a></li>
<li><a title="Add Widget" data-toggle="modal" href="#addWidgetModal"><span class="glyphicon glyphicon-plus-sign"></span> Add Widget</a></li>
</ul>
<a href="#"><strong><i class="glyphicon glyphicon-dashboard"></i> My Profile</strong></a>  
<hr>
<div class="row">
<div class="col-md-6">
<div class="well">Inbox Messages <span class="badge pull-right">0</span></div>
<hr>
</div>           
</div>         
</body>
</html>