<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>basic data management</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basicDataManagement.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
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
            Consumer Code <input type="text" name="code"/>
            Consumer Name <input type="text" name="name"/>
            Link Man <input type="text" name="linkman"/>
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
   </div>

    <!-- Display query for Supplier -->
    <div id="Supplier" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/consumerSelect">
            Supplier Code <input name="code"/>
            Supplier Name <input type="text" name="name"/>
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <!-- Display query for Product -->
    <div id="Product" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/consumerSelect">
            Product Code <input type="text" name="code"/>
            Product Name <input type="text" name="name"/>
            Product Category <input type="text" name="category">
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <div id="insert">
        <button id="create-data" class="insertButton" type="button">New</button>
    </div>

    <div id="dialog-form" title="Create new user" style="display: none">
        <p class="validateTips">All form fields are required.</p>

        <form>
            <fieldset>
                <label for="name">Name</label>
                <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all">
                <label for="email">Email</label>
                <input type="text" name="email" id="email" class="text ui-widget-content ui-corner-all">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="text ui-widget-content ui-corner-all">
                <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
            </fieldset>
        </form>
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

    <div id="SupplierList">

    </div>

    <div id="ProductList">

    </div>

</div>


</body>
</html>
