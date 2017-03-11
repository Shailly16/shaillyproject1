
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script> 
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- JQuery (for searchCondition-->
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">

<script>

var prod;
var app=angular.module("searchApp",[]).controller("TableCtrl",function($scope)
                    {
            
             $scope.prod=${products};
                    });
 
 



</script>

 <body ng-app="searchApp">
 
 <div class="container" ng-controller="TableCtrl">
  <div class="search"> 
  <div class ="col-sm-8"></div>
  <div class="col-sm-4">
    <input type="search" ng-model="searchText" class="form-control" id="inputSearch" 

placeholder="Search Here" />
</div>
</div>

 <c:if test="${!empty products}"> 
<!-- <!-- <div class="panel-body ">
			<div class="form-group">
			    <input type="text" class="search form-control" placeholder="Filter Products">
			</div> 
			<table border=1 class="table table-striped table-hover table-responsive results"> -->
				
		<table class="tg"  style="padding-left:200px;"> 
			<tr>
				<th width="80">Product ID</th>
				<th width="80">Product Name</th>
				<th width="300">Product Description</th>
				<th width="80">Price</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="60">Stock</th>
				
				
			</tr> 
			  <c:forEach items="${products}" var="product">  --%>
			<table>
			 <tr ng-repeat="product in prod"> 
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.category.name}</td>
					<td>${product.supplier.name}</td>
					<td>${product.stock}</td>
					</tr>
					</tr> 
					</table>
					</c:forEach>
					</table>
					</c:if>
					
