<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>inbound logistics management</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basic.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/inboundLogistics.js"></script>
</head>
<body>

<!-- JSP code: Check Login Status, To prevent user jump through login in stage with URL -->
<%
    String name = (String)session.getAttribute("username");
    if (name==null){
        response.sendRedirect("/");
    }
%>

<!-- This is used to show messages that are parsed from Server (SUCCESS,FAIL)-->
<input id="message" type="hidden" value="${msg}">
<p>
    msg:${msg};
</p>

<div id="headerBlock">

    <a href="${pageContext.request.contextPath}/mainPage">Main Page</a>

    <div id="search-query" class="query">
        <form:form method="post" action="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement/selectInbound">
            Inbound Receipt <input type="text" name="inboundReceipt"/>
            Supplier <input type="text" name="supplier"/>
            From: <input type="date" name="startDate"/>
            To: <input type="date" name="endDate"/>
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <button id="create-data" class="insertButton" type="button">New</button>

    <!-- Dialogs for Insertion -->
    <div id="inbound-dialog" title="create new data" style="display: none">
        <form id="inboundForm" method="post" action="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement/insertInbound">
            <p>
                Inbound Receipt:
                <input type="text" name="inboundReceipt">
            </p>
            <p>
                Inbound Date:
                <input type="date" name="inboundDate">
            </p>
            <p>
                Supplier:
                <input type="text" name="supplier">
            </p>
            <p>
                recorder:
                <input type="text" name="recorder">
            </p>
            <p>
                reviewer:
                <input type="text" name="reviewer">
            </p>
            <p>
                price:
                <input type="number" name="price" step="0.01">
            </p>
            <p>
                Remark:
                <input type="text" name="remark">
            </p>
        </form>
    </div>

    <!-- Dialogs for Insertion -->
    <div id="inbound-update-dialog" title="create new data" style="display: none">
        <form id="inboundUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement/updateInbound">
            <p>
                Inbound Receipt:
                <input type="text" name="inboundReceipt" id="inboundReceipt">
            </p>
            <p>
                Inbound Date:
                <input type="date" name="inboundDate" id="inboundDate">
            </p>
            <p>
                Supplier:
                <input type="text" name="supplier" id="supplier">
            </p>
            <p>
                recorder:
                <input type="text" name="recorder" id="recorder">
            </p>
            <p>
                reviewer:
                <input type="text" name="reviewer" id="reviewer">
            </p>
            <p>
                price:
                <input type="number" name="price"  id="price" step="0.01">
            </p>
            <p>
                Remark:
                <input type="text" name="remark" id="remark">
            </p>
        </form>
    </div>

</div>

<div id="ListBlock">

    <div id="inboundList">
        <table class="searchList">
            <tr>
                <th>Inbound Receipt</th>
                <th>Inbound Date</th>
                <th>Supplier</th>
                <th>recorder</th>
                <th>reviewer</th>
                <th>price</th>
                <th>remark</th>
                <th>action</th>
            </tr>

            <c:forEach items="${requestScope.inboundList}" var="inboundList">
                <tr>
                    <td>${inboundList.inboundReceipt}</td>
                    <td>${inboundList.inboundDate}</td>
                    <td>${inboundList.supplier}</td>
                    <td>${inboundList.recorder}</td>
                    <td>${inboundList.reviewer}</td>
                    <td>${inboundList.price}</td>
                    <td>${inboundList.remark}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/inboundLogisticsManagement/deleteInbound?inboundReceipt=${inboundList.inboundReceipt}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateInbound" type="button"
                                data-inbound-receipt="${inboundList.inboundReceipt}"
                                data-inbound-Date="${inboundList.inboundDate}"
                                data-supplier="${inboundList.supplier}"
                                data-recorder="${inboundList.recorder}"
                                data-reviewer="${inboundList.reviewer}"
                                data-price="${inboundList.price}"
                                data-remark="${inboundList.remark}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>
