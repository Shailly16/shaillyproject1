
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<body>

<div id="adminHome">
<a href="manageCategories">Manage Categories</a>&nbsp;&nbsp;



<a href="manageSuppliers">Manage Suppliers</a>&nbsp;&nbsp;


<a href="manageProducts">Manage Products</a>&nbsp;&nbsp;


</div>
<c:url value="j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>