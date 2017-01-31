
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div id="adminHome">
<a href="manage_categories">Manage Categories</a>&nbsp;&nbsp;
<a href="manage_suppliers">Manage Suppliers</a>&nbsp;&nbsp;
<a href="manage_products">Manage Products</a>&nbsp;&nbsp;
</div>
<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="$(logoutUrl}" method="post" id="logoutForm">
<input type="hidden" name="${_csrf.parameterName}" value="$(_csrf.token}"/></form>

       
</body>
</html>