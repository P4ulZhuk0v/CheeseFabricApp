<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Observe Recipe</title>
</head>
<body>

<c:forEach var="name" items="${cheeseNames}">
    <table>
        <tbody>
        <h3>Cheese Name: ${name}</h3>
        <th>Name:</th>
        <th>Amount:</th>
        <tr>
            <c:forEach var="recipe" items="${recipes}">
                <c:if test="${recipe.cheeseName == name}">
                    <td>${recipe.materialName}</td>
                    <td>${recipe.amountOfMaterialRequired}</td>
                </c:if>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</c:forEach>


</body>
</html>
