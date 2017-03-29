<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.min.js"></script>
<title>Insert title here</title>
<%@ include file="../header.jsp" %> 


<br>
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
var table = $('#products');
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


 
<h1>Add a product</h1>







<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
<form:form action="${addAction}" commandName="product" enctype="multipart/form-data" method="post">
		<table>
		
		<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose> 
					 <c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					 </c:otherwise>
				</c:choose>
				</tr>
         <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td> <form:input path="name" /></td>
            <td><form:errors path="name" cssStyle="color:#00ff00;"/></td>
      
    </tr>
    <tr>
     <td>
           
    
            <form:label path="price">
                <spring:message text="Price"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td>
         <td><form:errors path="price" cssStyle="color:#00ff00;"/></td>
    </tr>
    
     
    
    
    
    
    <tr>
        <td>
            <form:label path="description">
                <spring:message text="Description"/>
            </form:label>
        </td>
        <td>
            <form:input path="description" />
        </td>
         <td><form:errors path="description" cssStyle="color:#00ff00;"/>
        </td>
    </tr>
     <tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
 
     <tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
					<td><form:select path="supplier.name" items="${supplierList}"
					itemValue="name" itemLabel="name" /></td>
     </tr> 
     
     
     
        <tr>
           <td>
            <form:label path="stock">
                <spring:message text="stock"/>
            </form:label>
        </td>
        <td>
            <form:input path="stock" />
        </td>
         <td><form:errors path="stock" cssStyle="color:#00ff00;"/>
        </td>
    </tr>
    
    
     <tr>
        <td>
            <form:label path="image">
                <spring:message text="Photo to upload"/>
            </form:label>
        </td>
        <td>
            <form:input type="file" path="image" />
        </td><td></td>
        
    </tr>
    <tr>
				 <td colspan="2"><c:if test="${!empty product.name}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Edit Product"/>"/> 
					 </c:if>  <c:if test="${empty product.name}">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if>
			</tr>
    
    
     </table> 
 </form:form>
<br>
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

		<table class="tg" border="1" style="padding-left:200px;" id="products"> 
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="120">Product Category</th>
				<th width="120">Product Supplier</th>
				<th width="60">Stock</th>
				<th width="120">Product Image</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
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
					
					<td><img src="<c:url value='/resources/img/${product.getName()}.png'/>" height="50" width="50"/></td>
                     <td><a href="<c:url value='/manage_product_edit/${product.id}' />">Edit</a></td> 
					
					<td><a href="<c:url value='/manage_product_remove/${product.id}' />">Delete</a></td>
					</tr>
				
        </tbody>
    </c:forEach> 
  </table>
   
 </c:if>

 </div>
</div>    
</section>
  
 <br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file="../Footer.jsp" %>

 
       
        


</html>