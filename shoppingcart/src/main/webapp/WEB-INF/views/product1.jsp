<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-10">

<h1>

    Add a Product
</h1>
<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
<form:form action="${addAction}" commandName="product" modelAttribute="product" enctype="multipart/form-data" method="POST">
<table>
    
    
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            
            <c:when test="${!empty product.id}">
						<td><form:input path="id" value="" disabled="true" readonly="true" />
						</td>
					</c:when>
            
        </td> 
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
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
    
    
     </table> 
 </form:form>
<br>
<h3>Product List</h3>
<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.category.name}</td>
					<td>${product.supplier.name}</td>
                    <td><a href="<c:url value='/manage_product_edit/${product.id}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_product_remove/${product.id}' />">Delete</a></td>
				</tr>
        </tbody>
    </c:forEach>
    </table>
 </c:if>  
 </div>
 </div>
 </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
 <script src="resource/bootstrap/js/bootstrap.min.js"></script>


 