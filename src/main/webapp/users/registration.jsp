<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.08.2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User add</title>
</head>
<body>
<h1>Zarejestruj się</h1>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <div>
        <label for="username">Nazwa użytkownika: </label>
        <input type="text" name="username" id="username">
        <label for="password">Hasło: </label>
        <input type="text" name="password" id="password">
    </div>
    <div>
        <input type="submit" value="Dodaj użytkownika"/>
    </div>
</form>
</body>
</html>
