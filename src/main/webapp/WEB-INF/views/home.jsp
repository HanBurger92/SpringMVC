<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: Bao Han
  Date: 2020/5/3
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aoxing Management System</title>
</head>
<body>

<h1>Aoxing Management System</h1>

<form:form method="post" action="login">
   Username <input name="userName">
    <br/>
   Password <input type="password" name="password">
    <input type="submit" value="login"/>
</form:form>
</body>
</html>
