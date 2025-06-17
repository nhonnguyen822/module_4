<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/17/2025
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/search">
    <label> Tra Cứu</label>
    <input id="search" name="search" type="text" required placeholder="Nhập từ tiếng Anh">
    <button type="submit">Tra Cứu </button>
</form>
<p> Result : ${result}</p>
</body>
</html>
