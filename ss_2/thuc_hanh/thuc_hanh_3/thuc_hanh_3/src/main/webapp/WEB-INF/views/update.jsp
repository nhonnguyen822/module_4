<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/18/2025
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/customers/${customer.id}">
    <label for="id">ID</label>
    <input name="id" id="id" value="${customer.id}">
    <label for="name">NAME</label>
    <input name="name" id="name" value="${customer.name}">
    <label for="email">EMAIL</label>
    <input name="email" id="email" value="${customer.email}">
    <label for="address">ADDRESS</label>
    <input name="address" id="address" value="${customer.address}">
    <button type="submit"> Create</button>
</form>
</body>
</html>
