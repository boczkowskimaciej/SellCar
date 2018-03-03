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

    <br>
    <%--<div>--%>
        <%--<input type="text" name="searchByBrandValue" value="search by brand">--%>
        <%--<button type="submit" name="searchByBrand" value="searchByBrandValue">search</button>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<input type="text" name="searchByModelValue" value="search by model">--%>
        <%--<button type="submit" name="searchByModel" value="searchByModelValue">search</button>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<button type="submit" name="search" value="search">search</button>--%>
    <%--</div>  --%>

    <div>
        Brand<br>
        <select name="brand">
            <option value="all">all</option>
            <option value="honda">honda</option>
            <option value="renault">renault</option>
            <option value="skoda">skoda</option>
            <option value="vw">vw</option>
            <option value="fiat">fiat</option>
        </select>
    </div>
    <div>
        Model<br>
        <select name="model">
            <option value="all">all</option>
            <option value="civic">civic</option>
            <option value="accord">accord</option>
            <option value="clio">clio</option>
            <option value="megane">megane</option>
            <option value="octavia">octavia</option>
            <option value="fabia">fabia</option>
            <option value="golf">golf</option>
            <option value="polo">polo</option>
            <option value="panda">panda</option>
            <option value="tipo">tipo</option>
        </select>
    </div>
    <div>
        <button type="submit" name="search" value="search">search</button>
    </div>
    <br>



    <c:forEach items="${allCars}" var="car">
        <li>${car.brand} ${car.model} ${car.year}
            <a href="${car.link}">photo this ${car.brand}</a>
        </li>
    </c:forEach>



</form>

</body>
</html>
