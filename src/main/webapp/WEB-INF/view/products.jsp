<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
<%--<link href=<c:url value="product/resources/css/main.css"/> rel="stylesheet">--%>
<style>
    ul#menu li{
        display:inline-block;
    }
</style>
<ul id="menu">
    <li><a href="${pageContext.request.contextPath}/products/all">Main Page</a></li>
    <li><a href="${pageContext.request.contextPath}/products/add">Add product</a></li>
</ul>
<h2>Product Form Result</h2>
<table>
    <tr><th>ID</th><th>Title</th><th>Cost</th></tr>
<c:forEach var="product" items="${products}">
    <tr><th><a href="${pageContext.request.contextPath}/products/showProductById?id=${product.id}">${product.id}</a></th><th>${product.title}</th><th>${product.cost}</th></tr>
</c:forEach>
</table>
</body>
</html>