<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"> <!-- animation CSS from open source -->
</head>
<body id="gradient">

<div id="headerBlock">
    &nbsp; Hello!&nbsp; ${sessionScope.username}
    Your Identity is &nbsp;${sessionScope.role}
    <a href="${pageContext.request.contextPath}/"> Log Out </a>
</div>

<div id="basicDataManagement" class="animate__animated animate__bounceIn">
    <a href="${pageContext.request.contextPath}/mainPage/basicDataManagement"> <img border="0" width="50%" src="${pageContext.request.contextPath}/images/basicDataManagement.png"></a>
    <br/>
    Basic Data Management
</div>

<div id="inboundLogisticsManagement" class="animate__animated animate__bounceIn">
    <a href="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement"> <img border="0" width="50%" src="${pageContext.request.contextPath}/images/inboundLogistics.png"> </a>
    <br/>
    Inbound Logistics Management
</div>

<div id="outboundLogisticsManagement" class="animate__animated animate__bounceIn">
    <a href="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement"> <img border="0" width="50%" src="${pageContext.request.contextPath}/images/outboundLogistics.png"> </a>
    <br/>
    Outbound Logistics Management
</div>

<div id="comprehensiveStatement" class="animate__animated animate__bounceIn">
    <a href="${pageContext.request.contextPath}/mainPage/comprehensiveStatement"> <img border="0" width="50%" src="${pageContext.request.contextPath}/images/comprehensiveStatement.png">  </a>
    <br/>
    Comprehensive Statement
</div>

<div id="footer">
    &nbsp; Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
</div>
</body>
</html>
