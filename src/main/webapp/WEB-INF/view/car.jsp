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
           <button type="submit" name="removeCar" value="${car.id}">remove car</button>
    </li>
</c:forEach>
    <br>
    <div>
        <button type="submit" name="searchByBrand" value="searchByBrand">search</button>
    </div>
    <br>

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
        Year<br>
        <select name="year">
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
            <option value="2015">2015</option>
            <option value="2014">2014</option>
            <option value="2013">2013</option>
            <option value="2012">2012</option>
            <option value="2011">2011</option>
            <option value="2010">2010</option>
            <option value="2009">2009</option>
            <option value="2008">2008</option>
            <option value="2007">2007</option>
        </select>
    </div>
    <div>
        <input type="text" name="link" value="insert link into photo car">
    </div>
    <br>
    <button type="submit" name="addCar" value="addCar">add Car</button>
    <br>



</form>

</body>
</html>
