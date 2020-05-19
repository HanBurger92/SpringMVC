<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: Bao Han
  Date: 2020/5/3
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Aoxing Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"> <!-- animation CSS from open source -->
</head>
<body id="gradient">

<div id="headerBlock">
<h1 class="animate__animated animate__bounce">Aoxing Management System</h1>
</div>

<div id =loginBlock>
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
