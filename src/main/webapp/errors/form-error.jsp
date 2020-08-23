<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 23.08.2020
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<p>Wystąpił następujący błąd: ${message}</p>
<a href="${header.get("Referer")}">Wróć</a>
</body>
</html>
