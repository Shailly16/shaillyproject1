<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Admin/Supplier</title>
<style type="text/css">
.for_form {
	/*background-color: white;*/
	padding : 20px 5px 5px 5px;
	border : 2px solid #B22222;
	border-radius: 15px;
	margin-bottom: 15px;
	margin-top : 5px;
}
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}
</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="container for_form">
	<c:choose>
		<c:when test="${add}">
			<c:url var="addAction" value="/manage_supplier_add"></c:url><form:form action="${addAction}" commandName="supplier">
			<table>
		
			<tr>
				<td><form:label path="sid"><spring:message text="ID" />
					</form:label></td>
					<td><form:input path="sid" pattern =".{5,20}" required="true" title="sid should contains 5 to 20 characters" /></td>
					</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>
				<td><form:input path="address" required="true" /></td>
			</tr>
			 
			<td colspan="2"><input type="submit" value="<spring:message text="Add Supplier"/>" /></td> 
			
			  </table> 
			 </form:form>
			 
		</c:when>
		<c:otherwise>
			<c:url var="addAction" value="/manage_supplier_add"></c:url><form:form action="${addAction}" commandName="supplier">
			<table>
		
			<tr>
				<td><form:label path="sid"><spring:message text="ID" />
					</form:label></td>
					<td><form:input path="sid" disabled="true" readonly="true" />
						</td>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>
				<td><form:input path="address" required="true" /></td>
			</tr>
			 
			<td colspan="2"><input type="submit" value="<spring:message text="Edit Supplier"/>" /></td> 
			
			  </table> 
			 </form:form>
			 
			 
	 	</c:otherwise>
	 </c:choose>
	</div>
	<div class="panel panel-success">
		<div class="panel-heading">
		<h3 class="panel-title">SUPPLIERS <span class="badge" style="float:right">${no_of_suppliers}</span></h3>
		</div>
		<div class="panel-body ">
			<div class="form-group">
			    <input type="text" class="search form-control" placeholder="Filter Suppliers">
			</div>
			<table border=1 class="table table-striped table-hover table-responsive results">
				<thead>
				<tr>
					<th style="text-align: center">SUPPLIER ID</th>
					<th style="text-align: center">SUPPLIER NAME</th>
					<th style="text-align: center">SUPPLIER ADDRESS</th>
					<th style="text-align: center" width="100">EDIT</th>
					<th style="text-align: center" width="100">DELETE</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${supplierList}" var="supplier">
						<tr>
						<td><c:out value="${supplier.sid }"></c:out></td>
						<td><c:out value="${supplier.name }"></c:out></td>
						<td><c:out value="${supplier.address }"></c:out></td>
						<td style="text-align: center"><a href='<c:url value='manage_supplier_edit/${supplier.sid}'></c:url>' class="btn btn-info">Edit</a></td>
						<td style="text-align: center"><a href='<c:url value='manage_supplier_remove/${supplier.sid}'></c:url>' class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>