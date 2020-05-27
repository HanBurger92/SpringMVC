<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Aoxing Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body id="gradient">

<div id="headerBlock">
<h1>Aoxing Management System</h1>
</div>

<p id="warning"> Login Failed, Check your username and password</p>

<div id="loginBlock">
<form:form method="post" action="login">
    Username <input name="userName">
    <br/>
    Password &nbsp;<input type="password" name="password">
    <br/>
    <input type="submit" value="login"/>
</form:form>
</div>

</body>
</html>
