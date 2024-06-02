<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Observe Recipe</title>
</head>
<body>
<h1>Observe cheese's recipes
</h1>

<c:forEach var="name" items="${cheeseNames}">
    <table>
        <tbody>
        <h3>Cheese Name: ${name}</h3>
        <th>Name:</th>
        <th>Amount:</th>
            <c:forEach var="recipe" items="${recipes}">
        <tr>
                <c:if test="${recipe.cheeseName == name}">
                    <td>${recipe.materialName}</td>
                    <td>${recipe.amountOfMaterialRequired}</td>
                </c:if>
        </tr>
            </c:forEach>
        </tbody>
    </table>
</c:forEach>

<button onclick="window.location.href='/recipes/add-recipe'">Добавить рецепт</button>

<button onclick="window.location.href='/recipes/delete-recipe'">Удалить рецепт</button>


</body>
</html>
