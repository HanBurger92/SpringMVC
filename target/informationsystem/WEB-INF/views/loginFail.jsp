<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bao Han
  Date: 2020/5/12
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aoxing Management System</title>
</head>
<body>
<h1>Aoxing Management System</h1>

<p style="color: red"> Login Failed, Check your username and password </p>

<form:form method="post" action="login">
    Username <input name="userName">
    <br/>
    Password <input type="password" name="password">
    <input type="submit" value="login"/>
</form:form>

</body>
</body>
</html>
