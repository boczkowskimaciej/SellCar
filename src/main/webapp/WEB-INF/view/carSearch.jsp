<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciek
  Date: 14.02.18
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" >

    <c:forEach items="${allCars}" var="car">
        <li>${car.brand} ${car.model} ${car.year}
            <a href="${car.link}">photo this ${car.brand}</a>
        </li>
    </c:forEach>

    <br>
    <div>
        <input type="text" name="searchByBrandValue" value="search by brand">
        <button type="submit" name="searchByBrand" value="searchByBrand">search</button>
    </div>
    <br>

</form>

</body>
</html>
