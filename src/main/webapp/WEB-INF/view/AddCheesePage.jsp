<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add cheese</title>
</head>
<body>
<h1>Please, enter a data u want to save about cheese</h1>

<form:form action="cheese-added" method="post" modelAttribute="cheese">
    Cheese name: <form:select path="cheeseName" items="${recipes}"/><br>
    Cheese amount: <form:input path="amount"/><form:errors path="amount"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
