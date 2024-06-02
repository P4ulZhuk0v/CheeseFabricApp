<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 31.05.2024
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form modelAttribute="user" action="/perform_registration" method="post">
    Телефон: <form:input path="phoneNumber"/>
    Пароль: <form:input path="password" />
    <input type="hidden" name="_csrf" value="${_csrf.token}"><br>
    <input type="submit" value="Зарегистрироваться">
</form:form>

</body>
</html>
