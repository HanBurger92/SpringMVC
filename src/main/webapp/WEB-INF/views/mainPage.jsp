<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bao Han
  Date: 2020/5/5
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>

    <title>Main Page</title>

    <a href="${pageContext.request.contextPath}/mainPage/basicDataManagement"> Basic data management </a>
    <br/>
    <a href="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement">Inbound logistics management</a>
    <br/>
    <a href="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement">Outbound logistics management</a>
    <br/>
    <a href="${pageContext.request.contextPath}/mainPage/comprehensiveStatement">Comprehensive Statement</a>

</head>
<body>

</body>
</html>
