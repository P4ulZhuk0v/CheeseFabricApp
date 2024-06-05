<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление рецепта</title>
</head>
<body>
<form method="post" action="delete-recipe" >
    Название сыра: <input type="text" name="cheese" placeholder="enter cheese name">
    Название компонента: <input type="text" name="material" placeholder="enter material name">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
