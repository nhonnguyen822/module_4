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
<a href="customers/create">create</a>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customers" items="${customersList}" varStatus="idx">
        <tr>
            <td>${idx.count}</td>
            <td>${customers.name}</td>
            <td>${customers.email}</td>
            <td>${customers.address}</td>
            <td>
                <a href="customers/detail?id=${customers.id}">detail</a>
                <a href="customers/delete?id=${customers.id}">delete</a>
                <a href="customers/update/${customers.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${not empty message}">
        <p> ${message}</p>
    </c:if>
</table>
</body>
</html>
