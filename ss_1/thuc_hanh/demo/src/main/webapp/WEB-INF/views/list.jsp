<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/17/2025
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach var="customers" items="${customersList}" varStatus="idx">
        <tr>
            <td>${idx.count}</td>
            <td>${customers.name}</td>
            <td>${customers.email}</td>
            <td>${customers.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
