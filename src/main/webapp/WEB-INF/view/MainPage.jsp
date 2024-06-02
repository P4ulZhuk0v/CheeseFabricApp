<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your shop</title>
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
            <th>Id:                </th>
            <th>Name:              </th>
            <th>Price:             </th>
            <th>Markup percentage: </th>
            <th>Markup price:      </th>
            <th>Amount:            </th>
            <th>Date:              </th>
        </tr>

        <c:forEach var="myCheese" items="${cheese}">
            <tr>
                <td>${myCheese.id}</td>
                <td>${myCheese.cheeseName}</td>
                <td>${myCheese.price}</td>
                <td>${myCheese.markUp}</td>
                <td>${myCheese.markUpPrice}</td>
                <td>${myCheese.amount}</td>
                <td>${myCheese.dateOfProducing}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <button onclick="window.location.href='/shop/add-cheese'">Произвести сыр</button>
</div>
<hr>
<div>

    <h3>Materials</h3>
    <table class="mymaterials">
        <tbody>
        <tr>
            <th>Id: </th>
            <th>Name:</th>
            <th>Buy price:</th>
            <th>Currency name: </th>
            <th>Rub price: </th>
            <th>Amount left:</th>
            <th>Date:</th>
        </tr>
        <c:forEach var="material" items="${materials}">
            <tr>
                <td>${material.id}</td>
                <td>${material.name}</td>
                <td>${material.price}</td>
                <td>${material.currencyName}</td>
                <td>${material.rub_price}</td>
                <td>${material.amount}</td>
                <td>${material.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button onclick="window.location.href='/shop/add-material'">Принять сырье</button>
</div>
<hr>
<div>
    <h3>Sells</h3>
    <table class="mysells">
        <tbody>
        <tr>
            <th>Id: </th>
            <th>Name:</th>
            <th>Amount of sells:</th>
            <th>Price: </th>
            <th>Date: </th>
        </tr>
        <c:forEach var="sell" items="${sells}">
            <tr>
                <td>${sell.id}</td>
                <td>${sell.cheeseName}</td>
                <td>${sell.amountOfSells}</td>
                <td>${sell.price}</td>
                <td>${sell.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button onclick="window.location.href='/shop/add-sell'">Продать сыр</button>
</div>
<hr>
<button onclick="window.location.href='/shop/observe-recipes'">Рецепты</button><hr>

<button onclick="window.location.href='/logout'">Выйти</button>
</body>
</html>
