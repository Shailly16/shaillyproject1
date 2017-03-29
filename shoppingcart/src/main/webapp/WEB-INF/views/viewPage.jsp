<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="resource/js/bootstrap.min.js"></script>
  <script>
$(window).load(function() {
searchTable($('#search').val());
});

$(document).ready(function() {
$('#search').keyup(function() {
searchTable($(this).val());
});
});

function searchTable(inputVal) {
var table = $('#productList');
table.find('tr').each(function(index, row) {
var allCells = $(row).find('td');
if (allCells.length > 0) {
var found = false;
allCells.each(function(index, td) {
var regExp = new RegExp(inputVal, 'i');
if (regExp.test($(td).text())) {
found = true;
return false;
}
});
if (found == true)
$(row).show();
else
$(row).hide();
}
});
}
</script>
  </head>
  <body>
<section data-ng-app="myApp">
<div class="table responsive">
<div class="table">
<div style="height: 50px; padding-left: 200px; width: 500px;">
<label>Search Element <input type="text" id="search"
data-ng-model="search" value="${param.item}"
data-ng-init="search='${param.item}'"></label>
</div>
<br>
<h3>Product List</h3>

<c:if test="${!empty productList}">

		<table class="tg" border="1" style="padding-left:200px;" id="productList"> 
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="120">Product Category</th>
				<th width="120">Product Supplier</th>
				<th width="60">Stock</th>
				
				
			</tr>
			 <c:forEach items="${productList}" var="product"> 
			<!-- <tr ng-repeat="product in prod|filter:searchText"> -->
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.category.name}</td>
					<td>${product.supplier.name}</td>
					<td>${product.stock}</td>
					

 </tr>
 </c:forEach>
 </table>
 </c:if>
 </div>
 </div>
 </section>
 </body>
 </html>