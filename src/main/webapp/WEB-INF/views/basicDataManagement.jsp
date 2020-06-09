<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>basic data management</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basic.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/basicDataManagement.js"></script>

    <script>
        // Cookie is used to lock the selection box when the web page is refresh
        // Show the correspond search list base on the selection box after the web page is refresh
        $(function() {
            var cookie = document.cookie.split(";");
            switch (cookie[0]) {
                case 'selection=Consumer':
                    $('#selection').val('Consumer');
                    $('#Consumer').show();
                    $('#ConsumerList').show();
                    break;
                case 'selection=Supplier':
                    $('#selection').val('Supplier');
                    $('#Supplier').show();
                    $('#SupplierList').show();
                    break;
                case 'selection=Product':
                    $('#selection').val('Product');
                    $('#Product').show();
                    $('#ProductList').show();
                    break;
            }
        })
    </script>
</head>
<body>

<!-- This is used to show messages that are parsed from Server (SUCCESS,FAIL)-->
<input id="message" type="hidden" value="${msg}">
<p>
    msg:${msg};
</p>

<div id="headerBlock">

    <a href="${pageContext.request.contextPath}/mainPage">Main Page</a>

    <select id="selection" class="selection" onchange="displayQueryOption(this)">
        <option value="" disabled selected hidden>N/A</option>
        <option value="Consumer">Consumer</option>
        <option value="Supplier">Supplier</option>
        <option value="Product">Product</option>
    </select>

    <!-- Display query for Consumer -->
   <div id="Consumer" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/consumerSelect">
            Consumer Code <input type="text" name="code"/>
            Consumer Name <input type="text" name="name"/>
            Link Man <input type="text" name="linkmanSearch"/> <!-- to avoid duplicate name attribute,add search -->
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
   </div>

    <!-- Display query for Supplier -->
    <div id="Supplier" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/supplierSelect">
            Supplier Code <input name="code"/>
            Supplier Name <input type="text" name="name"/>
            Link Man<input type="text" name="linkmanSearch"/>
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <!-- Display query for Product -->
    <div id="Product" class="query" style="display: none">
        <form:form method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/productSelect">
            Product Code <input type="text" name="code"/>
            Product Name <input type="text" name="name"/>
            Product Category <input type="text" name="categorySearch">
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <button id="create-data" class="insertButton" type="button">New</button>

    <!-- Dialogs for Insertion -->
    <div id="consumer-dialog" title="create new data" style="display: none">
        <form id="consumerForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/consumerInsert">
            <p>
                Code:
                <input type="text" name="consumerCode">
            </p>
            <p>
                Consumer Name:
                <input type="text" name="consumerName">
            </p>
            <p>
                Consumer Address:
                <input type="text" name="consumerAddress">
            </p>
            <p>
                Contact Number
                <input type="text" name="contactNumber">
            </p>
            <p>
                Fax Number:
                <input type="text" name="faxNumber">
            </p>
            <p>
                Linkman:
                <input type="text" name="linkman">
            </p>
            <p>
                Remark:
                <input type="text" name="remark">
            </p>
        </form>
    </div>

    <div id="product-dialog" title="create new data" style="display: none">
        <form id="productForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/productInsert">
            <p>
                Code:
                <input type="text" name="productCode">
            </p>
            <p>
                Product Name:
                <input type="text" name="productName">
            </p>
            <p>
                Type:
                <input type="text" name="type">
            </p>
            <p>
                Category:
                <input type="number" name="category"  step="0.01">
            </p>
            <p>
                Unit:
                <input type="number" name="unit" step="0.01">
            </p>
            <p>
                Cost
                <input type="text" name="cost">
            </p>
            <p>
                Price
                <input type="text" name="price">
            </p>
            <p>
                Certificate
                <input type="text" name="certificate">
            </p>
            <p>
                Expiration Date
                <input type="date" name="expirationDate">
            </p>
        </form>
    </div>

    <div id="supplier-dialog" title="create new data" style="display: none">
        <form id="supplierForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/supplierInsert">
            <p>
                Code:
                <input type="text" name="supplierCode">
            </p>
            <p>
                Supplier Name:
                <input type="text" name="supplierName">
            </p>
            <p>
                Supplier Address:
                <input type="text" name="supplierAddress">
            </p>
            <p>
                Contact Number
                <input type="text" name="contactNumber">
            </p>
            <p>
                Fax Number:
                <input type="text" name="faxNumber">
            </p>
            <p>
                Linkman:
                <input type="text" name="linkman">
            </p>
            <p>
                Remark:
                <input type="text" name="remark">
            </p>
        </form>
    </div>

    <!-- dialog for update -->
    <div id="consumer-update-dialog" title="Update data" style="display: none">
        <form id="consumerUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/consumerUpdate">
            <p>
                Code:
                <input type="text" name="consumerCode" >
            </p>
            <p>
                Consumer Name:
                <input type="text" name="consumerName">
            </p>
            <p>
                Consumer Address:
                <input type="text" name="consumerAddress">
            </p>
            <p>
                Contact Number
                <input type="text" name="contactNumber">
            </p>
            <p>
                Fax Number:
                <input type="text" name="faxNumber">
            </p>
            <p>
                Linkman:
                <input type="text" name="linkman">
            </p>
            <p>
                Remark:
                <input type="text" name="remark">
            </p>
        </form>
    </div>

    <div id="product-update-dialog" title="Update data" style="display: none">
        <form id="productUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/productUpdate">
            <p>
                Code:
                <input type="text" name="productCode">
            </p>
            <p>
                Product Name:
                <input type="text" name="productName">
            </p>
            <p>
                Type:
                <input type="text" name="type">
            </p>
            <p>
                Category:
                <input type="text" name="category">
            </p>
            <p>
                Unit:
                <input type="text" name="unit">
            </p>
            <p>
                Cost
                <input type="number" name="cost" step="0.01">
            </p>
            <p>
                Price
                <input type="number" name="price" step="0.01">
            </p>
            <p>
                Certificate
                <input type="text" name="certificate">
            </p>
            <p>
                Expiration Date
                <input type="date" name="expirationDate">
            </p>
        </form>
    </div>

    <div id="supplier-update-dialog" title="Update data" style="display: none">
        <form id="supplierUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/basicDataManagement/supplierUpdate">
            <p>
                Code:
                <input type="text" name="supplierCode">
            </p>
            <p>
                Supplier Name:
                <input type="text" name="supplierName">
            </p>
            <p>
                Supplier Address:
                <input type="text" name="supplierAddress">
            </p>
            <p>
                Contact Number
                <input type="text" name="contactNumber">
            </p>
            <p>
                Fax Number:
                <input type="text" name="faxNumber">
            </p>
            <p>
                Linkman:
                <input type="text" name="linkman">
            </p>
            <p>
                Remark:
                <input type="text" name="remark">
            </p>
        </form>
    </div>

</div>

<div id="ListBlock">

    <div id="ConsumerList" style="display: none">
        <table class="searchList">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>Contact Number</th>
                <th>Fax Number</th>
                <th>linkman</th>
                <th>remark</th>
                <th>ACTION</th>
            </tr>

            <c:forEach items="${requestScope.consumerList}" var="consumers">
                <tr>
                    <td>${consumers.consumerCode}</td>
                    <td>${consumers.consumerName}</td>
                    <td>${consumers.consumerAddress}</td>
                    <td>${consumers.contactNumber}</td>
                    <td>${consumers.faxNumber}</td>
                    <td>${consumers.linkman}</td>
                    <td>${consumers.remark}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/basicDataManagement/consumerDelete?consumerCode=${consumers.consumerCode}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateConsumer" type="button"
                                data-consumer-code="${consumers.consumerCode}"
                                data-consumer-name="${consumers.consumerName}"
                                data-consumer-address="${consumers.consumerAddress}"
                                data-contact-number="${consumers.contactNumber}"
                                data-fax-number="${consumers.faxNumber}"
                                data-linkman="${consumers.linkman}"
                                data-remark="${consumers.remark}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="SupplierList" style="display: none">
        <table class="searchList">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>Contact Number</th>
                <th>Fax Number</th>
                <th>linkman</th>
                <th>remark</th>
                <th>ACTION</th>
            </tr>

            <c:forEach items="${requestScope.supplierList}" var="suppliers">
                <tr>
                    <td>${suppliers.supplierCode}</td>
                    <td>${suppliers.supplierName}</td>
                    <td>${suppliers.supplierAddress}</td>
                    <td>${suppliers.contactNumber}</td>
                    <td>${suppliers.faxNumber}</td>
                    <td>${suppliers.linkman}</td>
                    <td>${suppliers.remark}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/basicDataManagement/supplierDelete?supplierCode=${suppliers.supplierCode}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateSupplier" type="button"
                                data-supplier-code="${suppliers.supplierCode}"
                                data-supplier-name="${suppliers.supplierName}"
                                data-supplier-address="${suppliers.supplierAddress}"
                                data-contact-number="${suppliers.contactNumber}"
                                data-fax-number="${suppliers.faxNumber}"
                                data-linkman="${suppliers.linkman}"
                                data-remark="${suppliers.remark}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="ProductList" style="display: none">
        <table class="searchList">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Type</th>
                <th>Category</th>
                <th>Unit</th>
                <th>Cost</th>
                <th>Price</th>
                <th>Certificate</th>
                <th>Expiration Date</th>
                <th>ACTION</th>
            </tr>

            <c:forEach items="${requestScope.productList}" var="products">
                <tr>
                    <td>${products.productCode}</td>
                    <td>${products.productName}</td>
                    <td>${products.type}</td>
                    <td>${products.category}</td>
                    <td>${products.unit}</td>
                    <td>${products.cost}</td>
                    <td>${products.price}</td>
                    <td>${products.certificate}</td>
                    <td>${products.expirationDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/basicDataManagement/productDelete?productCode=${products.productCode}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateProduct" type="button"
                                data-product-code="${products.productCode}"
                                data-product-name="${products.productName}"
                                data-type="${products.type}"
                                data-category="${products.category}"
                                data-unit="${products.unit}"
                                data-cost="${products.cost}"
                                data-price="${products.price}"
                                data-certificate="${products.certificate}"
                                data-expiration-date="${products.expirationDate}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>


</body>
</html>
