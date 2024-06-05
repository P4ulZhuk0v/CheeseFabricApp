<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form modelAttribute="user" action="/registration" method="post">
    Телефон: <form:input path="phoneNumber"/>
    Пароль: <form:input path="password" />
    Отдел: <form:checkboxes path="roles" items="${rolesMap}"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"><br>
    <input type="submit" value="Зарегистрироваться">
</form:form>

</body>
</html>
