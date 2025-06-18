<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 6/18/2025
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="home" method="post">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="tomato" name="condiment" value="tomato">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="mustard" name="condiment" value="mustard">
    <label for="sprouts">Sprouts</label>
    <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
    <button type="submit"> OK</button>
</form>
</body>
</html>
