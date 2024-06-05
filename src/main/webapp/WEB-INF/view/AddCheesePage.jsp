<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add cheese</title>
</head>
<body>
<h1>Введите данные о произведенном сыре</h1>

<form:form action="add-cheese" method="post" modelAttribute="cheese">
    Название сыра: <form:select path="cheeseName" items="${recipes}"/><br>
    Количество в головках: <form:input path="amount"/><form:errors path="amount"/><br>
    Наценка: <form:input path="markUp"/><form:errors path="markUp"/><br>
    <input type="submit" value="Отправить">
</form:form>
</body>
</html>
