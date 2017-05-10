<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category Page</title>

</head>
<body>
<%@ include file="../header.jsp" %>
	<h1>Add a Category</h1>
	<c:url var="addAction" value="/manage_category_add"></c:url>
	<form:form action="${addAction}" commandName="category"  method="post">
		<table>
			<tr>
				<td><form:label path="cid"> <spring:message text="ID" />	</form:label></td>
				<c:choose>
					<c:when test="${!empty category.cid}">
						<td><form:input path="cid" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="cid" pattern=".{5,20}" required="true"
								title="cid should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
				
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.name}">
					    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg" border="1" style="padding-left:200px;">
			<tr>
				<th width="120">Category ID</th>
				<th width="120">Category Name</th>
				<th width="250">Category Description</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.cid}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='/manage_category_edit/${category.cid}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_category_remove/${category.cid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file="../Footer.jsp" %>
</body>
</html>






