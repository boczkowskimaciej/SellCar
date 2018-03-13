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
    <div>
        Login: <br>
        <input type="text" name="email" value="insert email">
        <input type="password" name="password" value="insert password">
        <button type="submit" name="loginButton" value="loginButton">Log</button>
    </div>

    <div>
        Or register: <br>
        <button type="submit" name="register" value="register">Register</button>
    </div>
</form>

</body>
</html>
