<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
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
<br>
ID: ${product.id}
<br>
Title: ${product.title}
<br>
Country: ${product.cost}

</body>
</html>