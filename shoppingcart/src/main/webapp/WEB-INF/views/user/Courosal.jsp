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
  <link rel="stylesheet"  href="css/NewFile.css"> 
  <style>
   .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
     margin:auto;
    max-height: 300px;} 
</style>
</head>
<body>
 <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

   
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="C:\Users\pavelion\Desktop\ekart project pictures\imp symbols\sun.png" alt="haircare" >
      </div>

      <div class="item">
        <img src="C:\Users\pavelion\Desktop\ekart project pictures\imp symbols\beauty.jpg" alt="lotions" >
      </div>
    
      <div class="item">
        <img src="C:\Users\pavelion\Desktop\ekart project pictures\imp symbols\best.jpg" alt="pefume">
      </div>
      
      <div class="item">
        <img src="C:\Users\pavelion\Desktop\ekart project pictures\imp symbols\lakme.jpg" alt="pefume">
      </div>
   

    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
      </a>
  </div>
  
</body>
</html>