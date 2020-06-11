<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>outbound logistics management</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basic.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/outboundLogistics.js"></script>
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

    <div class="query">
        <form id="select-form" method="post" action="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement/selectOutbound">
            Outbound Receipt: <input type="text" name="receipt"/>
            Supplier: <input type="text" name="supplier"/>
            From: <input type="date" name="startDate"/>
            To: <input type="date" name="endDate"/>
            <button class="formButton" type="submit" value="Search">Search</button>
            <button class="formButton" type="submit" value="Reset">Reset</button>
        </form>
    </div>

    <button id="create-data" class="insertButton" type="button">New</button>

    <!-- Dialogs for Insertion -->
    <div id="outbound-dialog" title="create new data" style="display: none">
        <form id="outboundForm" method="post" action="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement/insertOutbound">
            <p>
                Outbound Receipt:
                <input type="text" name="outboundReceipt">
            </p>
            <p>required
                Outbound Date:
                <input type="date" name="outboundDate">
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
    <div id="outbound-update-dialog" title="create new data" style="display: none">
        <form id="outboundUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement/updateOutbound">
            <p>
                Outbound Receipt:
                <input type="text" name="outboundReceipt" id="outboundReceipt" max="10">
            </p>
            <p>
                Outbound Date:
                <input type="date" name="outboundDate" id="outboundDate">
            </p>
            <p>
                Supplier:
                <input type="text" name="supplier" id="supplier" max="10">
            </p>
            <p>
                recorder:
                <input type="text" name="recorder" id="recorder" max="10">
            </p>
            <p>
                reviewer:
                <input type="text" name="reviewer" id="reviewer" max="10">
            </p>
            <p>
                price:
                <input type="number" name="price"  id="price" step="0.01" max="10000000">
            </p>
            <p>
                Remark:
                <input type="text" name="remark" id="remark" max="10">
            </p>
        </form>
    </div>

</div>

<div id="ListBlock">

    <div id="outboundList">
        <table class="searchList">
            <tr>
                <th>Outbound Receipt</th>
                <th>Outbound Date</th>
                <th>Supplier</th>
                <th>recorder</th>
                <th>reviewer</th>
                <th>price</th>
                <th>remark</th>
                <th>action</th>
            </tr>

            <c:forEach items="${requestScope.outboundList}" var="outboundList">
                <tr>
                    <td>${outboundList.outboundReceipt}</td>
                    <td>${outboundList.outboundDate}</td>
                    <td>${outboundList.supplier}</td>
                    <td>${outboundList.recorder}</td>
                    <td>${outboundList.reviewer}</td>
                    <td>${outboundList.price}</td>
                    <td>${outboundList.remark}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/outboundLogisticsManagement/deleteOutbound?outboundReceipt=${outboundList.outboundReceipt}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateOutbound" type="button"
                                data-outbound-receipt="${outboundList.outboundReceipt}"
                                data-outbound-Date="${outboundList.outboundDate}"
                                data-supplier="${outboundList.supplier}"
                                data-recorder="${outboundList.recorder}"
                                data-reviewer="${outboundList.reviewer}"
                                data-price="${outboundList.price}"
                                data-remark="${outboundList.remark}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>