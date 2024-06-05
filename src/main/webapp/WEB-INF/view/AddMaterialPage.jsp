<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a material</title>
</head>
<body>

<h1>Введите данные о принятом на склад сырье</h1>

<form:form action="add-material" method="post" modelAttribute="material">
    Название сырья: <form:input path="name"/><form:errors path="name"/><br>
    Цена за единицу сырья(кг, л, т.д.): <form:input path="price"/><form:errors path="price"/><br>
    Валюта: <form:select path="currencyName" items="${currencies}">
    </form:select><br>
    Количество единиц: <form:input path="amount"/><form:errors path="amount"/><br>
    <input type="submit" value="Отправить">
</form:form>
</body>
</html>
