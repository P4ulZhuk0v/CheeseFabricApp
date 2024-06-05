<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your shop</title>
</head>
<body>
<div>
    <h1>Данные магазина</h1>
    <hr>
</div>
<div>
    <h3>Сыры</h3>
    <table class="cheese">
        <tbody>
        <tr>
            <th>Id:                </th>
            <th>Название:              </th>
            <th>Себестоимость(за 1 головку):             </th>
            <th>Наценка(в %): </th>
            <th>Цена с наценкой(за 1 головку):      </th>
            <th>Количество(в головках):            </th>
            <th>Дата производства:              </th>
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

    <h3>Сырье</h3>
    <table class="mymaterials">
        <tbody>
        <tr>
            <th>Id: </th>
            <th>Название:</th>
            <th>Цена закупки(за 1 ед.):</th>
            <th>Валюта: </th>
            <th>Цена в рублях(за 1 ед.): </th>
            <th>Количество на складе:</th>
            <th>Дата получения:</th>
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
    <h3>Продажи</h3>
    <table class="mysells">
        <tbody>
        <tr>
            <th>Id: </th>
            <th>Название сыра:</th>
            <th>Количество проданных головок:</th>
            <th>Цена(за 1 головку): </th>
            <th>Дата: </th>
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
