<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> --%>
 <%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>  --%>

<%@ page session="false" %>
<html>
<head>

<title>Product Page</title>
</head>
<body>
<%@ include file="../header.jsp" %>
	<h1>Add a Product</h1>
	

<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
 
 <c:url var="addAction" value="/manage_product_add"></c:url>
	<f:form action="${addAction}" commandName="product" enctype="multipart/f-data" method="post">
		<table>
			<tr>
				<td><f:label path="id">
						<spring:message text="ID" />
					</f:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><f:input path="id" value="" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><f:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<f:input path="id" hidden="true" />
				<td><f:label path="name">
						<spring:message text="Name" />
					</f:label></td>
				<td><f:input path="name" required="true" /></td>
			</tr>


			<tr>
				<td><f:label path="price">
						<spring:message text="Price" />
					</f:label></td>
				<td><f:input path="price" required="true" /></td>
			</tr>

			<tr>
				<td><f:label path="description">
						<spring:message text="Description" />
					</f:label></td>
				<td><f:input path="description" required="true" /></td>
			</tr>

			<tr>
				<td><f:label path="supplier">
						<spring:message text="Supplier" />
					</f:label></td>
				<td><f:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td><f:label path="category">
						<spring:message text="Category" />
					</f:label></td>
				<td><f:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td align="left"><f:label path="image">
						<spring:message text=" Image" />
					</f:label></td>
				<td align="left"><f:input type="file" name="image" path="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
		
		<input type="hidden" 
             name="${_csrf.parameterName}" 
             value="${_csrf.token}" />
</f:form> 
	<br>

<f:label path="id">
<spring:message text="ID" />
	</f:label>
			

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
					<td><a href="<c:url value='manage_product_edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='manage_product_remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>



