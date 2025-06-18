<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/18/2025
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="home" method="post">
    <div style="display: flex">
        <label for="num1">Number 1</label>
        <input id="num1" name="num1" type="number" required>
        <label for="num2">Number 2</label>
        <input id="num2" name="num2" type="number" required>
    </div>
    <div>
        <button type="submit" name="operator" value="add">Addition(+)</button>
        <button type="submit" name="operator" value="sub">Subtraction(-)</button>
        <button type="submit" name="operator" value="mul">Multiplication(X)</button>
        <button type="submit" name="operator" value="div">Division(/)</button>
    </div>
</form>
<p> Result:${result}</p>
</body>
</html>
