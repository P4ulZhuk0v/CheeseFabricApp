<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding recipe component</title>
</head>
<body>
<h1>Добавить новый компонент к рецепту сыра</h1>
<form:form modelAttribute="recipe" action="add-recipe" method="post">
    Название сыра: <form:input path="cheeseName"/><form:errors path="cheeseName"/> <br>
    Название компонента: <form:select path="materialName" items="${materialsNames}"/><br>
    Количество компонента в ед.(кг, л, т.д.): <form:input path="amountOfMaterialRequired"/><form:errors path="amountOfMaterialRequired"/><br>
    <input type="submit" value="Отправить">
</form:form>

</body>
</html>
