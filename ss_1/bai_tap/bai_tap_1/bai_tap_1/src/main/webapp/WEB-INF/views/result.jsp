<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/17/2025
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="post">
    <label for="vnd">Nhập số tiền VND:</label>
    <input type="number" name="vnd" id="vnd" required/>
    <button type="submit">Chuyển đổi</button>
</form>
<p> Số tiền VND ${vnd}</p>
<p> Số tiền USD chuyển đổi ${usd}</p>
</body>
</html>
