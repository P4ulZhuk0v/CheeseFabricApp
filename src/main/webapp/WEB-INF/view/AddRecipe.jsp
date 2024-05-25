<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding recipe component</title>
</head>
<body>
<h1>Add new component to a recipe of cheese</h1>
<form:form modelAttribute="recipe" action="recipe-added" method="post">
    Cheese name: <form:select path="cheeseName" items="${cheeseNames}"/><br>
    Material name: <form:select path="materialName" items="${materialsNames}"/><br>
    Amount of material required: <form:input path="amountOfMaterialRequired"/><form:errors path="amountOfMaterialRequired"/><br>
    <input type="submit" value="Add component">
</form:form>

</body>
</html>
