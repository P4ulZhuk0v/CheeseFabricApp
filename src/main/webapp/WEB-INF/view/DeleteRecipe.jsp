<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 27.05.2024
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete recipe</title>
</head>
<body>
<form method="post" action="recipe-deleted" >
    Название сыра: <input type="text" name="cheese" placeholder="enter cheese name">
    Название компонента: <input type="text" name="material" placeholder="enter material name">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
