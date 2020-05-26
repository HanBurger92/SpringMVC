<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bao Han
  Date: 2020/5/5
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>basic data management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basicDataManagement.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/basicDataManagement.js"></script>
</head>
<body>

<div id="headerBlock">

    <select id="selection" class="selection" onchange="displayQueryOption(this)">
        <option value="none" selected disabled hidden>
            N/A
        </option>
        <option value="Consumer">Consumer</option>
        <option value="Supplier">Supplier</option>
        <option value="Product">Product</option>
    </select>

    <!-- Display query for Consumer -->
   <div id="Consumer" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/consumerSelect">
            Consumer Code <input name="code">
            Consumer Name <input name="name">
            Link Man <input name="linkman">
        </form:form>
   </div>

    <!-- Display query for Supplier -->
    <div id="Supplier" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/consumerSelect">
            Supplier Code <input name="code">
        </form:form>
    </div>

    <!-- Display query for Product -->
    <div id="Product" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/consumerSelect">
            Product Code <input name="code">
        </form:form>
    </div>

</div>

<div id="ListBlock">

    <div id="ConsumerList">
        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
            </tr>
        </table>
    </div>

    <div id="SupllierList">

    </div>

    <div id="ProductList">

    </div>

</div>


</body>
</html>
