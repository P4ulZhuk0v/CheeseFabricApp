<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 01.06.2024
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    Телефон: <input type="tel" name="username"><br>
    Пароль: <input type="password" name="password">
    <input type="hidden" name="_csrf" value="${_csrf.token}"><br>
    <input type="submit" value="Войти">
</form>


<button onclick="window.location.href='/registration'">Регистрация</button>

</body>
</html>
