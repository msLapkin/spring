<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<h2>Input product Form</h2>
<form:form action="result" modelAttribute="product">
    ID: <form:input path="id" />
    <br>
    TITLE: <form:input path="title" />
    <br>
    COST:  <form:input path="cost" />
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>