<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<div>
    <h1>Here u can observe some resources of your shop</h1>
    <hr>
</div>
<div>
    <h3>Cheese</h3>
    <table class="cheese">
        <tbody>
        <tr>
            <th>Name:</th>
            <th>Price:</th>
            <th>Amount:</th>
            <th>Date:</th>
        </tr>

        <c:forEach var="myCheese" items="${cheese}">
            <tr>
                <td>${myCheese.cheeseName}</td>
                <td>${myCheese.price}</td>
                <td>${myCheese.amount}</td>
                <td>${myCheese.dateOfProducing}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <form method="post" action="add-cheese">
        <input type="submit" value="Produce cheese">
    </form>
</div>
<hr>
<div>

    <h3>Materials</h3>
    <table class="mymaterials">
        <tbody>
        <tr>
            <th>Name:</th>
            <th>Buy price:</th>
            <th>Amount left:</th>
            <th>Date:</th>
        </tr>
        <c:forEach var="material" items="${materials}">
            <tr>
                <td>${material.name}</td>
                <td>${material.price}</td>
                <td>${material.amount}</td>
                <td>${material.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="post" action="add-material">
        <input type="submit" value="Buy material">
    </form>
</div>
<hr>
<div>
    <h3>Sells</h3>
    <table class="mysells">
        <tbody>
        <tr>
            <th>Name:</th>
            <th>Amount of sells:</th>
            <th>Date: </th>
        </tr>
        <c:forEach var="sell" items="${sells}">
            <tr>
                <td>${sell.cheeseName}</td>
                <td>${sell.amountOfSells}</td>
                <td>${sell.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="post" action="add-sell">
        <input type="submit" value="Sell">
    </form>
</div>
<hr>
</body>
</html>
