
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div id="adminHome">
<a href="/manage_categories">Manage Categories</a>&nbsp;&nbsp;
<c:if test="${isAdminClickedCategories==true}">
<%@ include file="./category.jsp" %>
</c:if>


<a href="manage_suppliers">Manage Suppliers</a>&nbsp;&nbsp;


<a href="manage_products">Manage Products</a>&nbsp;&nbsp;
>

</div>

</body>
</html>