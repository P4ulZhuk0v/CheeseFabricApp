<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Sell</title>
</head>
<body>
<h1>Please, enter a data u want to save about cheese</h1>

<form:form action="add-sell" method="post" modelAttribute="sell">
    Название сыра: <form:select path="cheeseName" items="${cheeseNames}"/><br>
    Количество продаж в головках: <form:input path="amountOfSells"/><form:errors path="amountOfSells"/><br>
    <input type="submit" value="Отправить">
</form:form>

</body>
</html>
