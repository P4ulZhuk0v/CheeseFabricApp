<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a material</title>
</head>
<body>

<h1>Please, enter a data u want to save about material</h1>

<form:form action="material-added" method="post" modelAttribute="material">
    Material name: <form:input path="name"/><form:errors path="name"/><br>
    Material price: <form:input path="price"/><form:errors path="price"/><br>
    Price currency: <form:select path="currencyName" items="${currencies}">
    </form:select><br>
    Material amount: <form:input path="amount"/><form:errors path="amount"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
