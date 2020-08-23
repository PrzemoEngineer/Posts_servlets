<%@ page import="pl.sda.domain.user.post.Post" %>
<%@ page import="pl.sda.domain.user.post.PostService" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22.08.2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts page</title>
</head>
<body>
<%--    <%--%>
<%--        List<Post> posts = (List<Post>) request.getAttribute("posts");--%>
<%--        request.setAttribute("posts", posts) TEGO NIE MUSI BYć;--%>
<%--    %>--%>

    <form action="${pageContext.request.contextPath}/posts" method="post">
        <div>
            <label for="content">Treść</label>
            <input type="text" name="content" id="content">
        </div>
        <div>
            <input type="submit" value="Dodaj post"/>
        </div>
    </form>

    <table>
    <thead>
    <tr>
        <td>Autor</td>
        <td>Treść</td>
        <td>Data utworzenia</td>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.author.userName}</td>
                <td>${post.content}</td>
                <td>${post.createdAt}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>
