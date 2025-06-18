<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/18/2025
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<ol>Condiments
<c:forEach var="condiment" items="${condiment}">
    <li>${condiment}</li>
</c:forEach>
</ol>
<a href="home">Back</a>
</body>
</html>
