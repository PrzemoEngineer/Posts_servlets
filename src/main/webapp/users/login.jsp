<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22.08.2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath/login}}" method="post">
        <div>
            <label for="login">Login:</label>
            <input type="text" name="login" id="login"/>
        </div>
        <div>
            <label for="password">Hasło:</label>
            <input type="text" name="password" id="password"/>
        </div>
        <div>
            <input type="submit" value="Zaloguj"/>
        </div>
    </form>
</div>
<div>
    <a href="${pageContext.request.contextPath/registration}">Zarejestruj</a>
</div>
</body>
</html>
