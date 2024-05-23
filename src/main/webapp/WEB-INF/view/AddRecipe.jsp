<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding recipe</title>
</head>
<body>

<form:form modelAttribute="recipe" action="recipe-added" method="post">
    Cheese name: <form:select path="cheeseName" items="${cheeseNames}"/>
    Material name: <form:select path="materialName" items="${materialsNames}"/>
    Amount of material required: <form:input path="amountOfMaterialRequired"/>
</form:form>

</body>
</html>
