<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/19/2025
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="settingForm" type=""--%>
<form:form method="post" action="setting" modelAttribute="settingForm">
    <form:select path="language">
        <form:options items="${languages}"/>
        <%--        <form:option value="vn">Vietnamese</form:option>--%>
        <%--        <form:option value="jv">Japanese</form:option>--%>
        <%--        <form:option value="chi">Chinese</form:option>--%>
        <%--        <form:option value="en">English</form:option>--%>
    </form:select><br>

    <form:select path="size">
        <form:options items="${pageSizes}"/>

        <%--        <form:option value="5">5</form:option>--%>
        <%--        <form:option value="10">10</form:option>--%>
        <%--        <form:option value="15">15</form:option>--%>
        <%--        <form:option value="25">25</form:option>--%>
        <%--        <form:option value="50">50</form:option>--%>
        <%--        <form:option value="100">100</form:option>--%>
    </form:select><br>

    <form:radiobutton path="spamsFilter" value="true"/>Enable spams filter<br>
    <form:textarea path="signNature" cols="30" rows="4"/><br>
    <button type="submit">Update</button>
</form:form>
</body>
</html>
