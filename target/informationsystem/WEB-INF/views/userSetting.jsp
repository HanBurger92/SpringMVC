<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>user setting</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basic.css">
    <script src="${pageContext.request.contextPath}/webjars/jquery/1.12.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userSetting.js"></script>
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
        <form:form method="post" action="${pageContext.request.contextPath}/mainPage/userSetting/selectUser">
            ID <input type="number" name="id"/>
            Username <input type="text" name="userName"/>
            Role: <input type="text" name="role"/>
            <div class="button">
                <button class="formButton" type="submit" value="Search">Search</button>
                <button class="formButton" type="reset" value="Reset">Reset</button>
            </div>
        </form:form>
    </div>

    <button id="create-data" class="insertButton" type="button">New</button>

    <!-- Dialogs for Insertion -->
    <div id="user-dialog" title="create new data" style="display: none">
        <form id="userForm" method="post" action="${pageContext.request.contextPath}/mainPage/userSetting/insertUser">
            <p>
                User Name
                <input type="text" name="userName"/>
            </p>
            <p>
                Password
                <input type="text" name="password"/>
            </p>
            <p>
                Role:
                <select id="roleSelection" name="role">
                    <option value="admin">Admin</option>
                    <option value="manager">Manager</option>
                    <option value="employee">Employee</option>
                </select>
            </p>
        </form>
    </div>

    <!-- Dialogs for update -->
    <div id="user-update-dialog" title="create new data" style="display: none">
        <form id="userUpdateForm" method="post" action="${pageContext.request.contextPath}/mainPage/userSetting/updateUser">
            <p>
                UID
                <input type="number" name="id"/>
            </p>
            <p>
                User Name
                <input type="text" name="userName" id="username"/>
            </p>
            <p>
                Password
                <input type="text" name="password" id="password"/>
            </p>
            <p>
                Role:
                <select id="roleUpdate" name="role">
                    <option value="admin">Admin</option>
                    <option value="manager">Manager</option>
                    <option value="employee">Employee</option>
                </select>
            </p>
        </form>
    </div>

</div>

<div id="ListBlock">

    <div id="userList">
        <table class="searchList">
            <tr>
                <th>userID</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>action</th>
            </tr>

            <c:forEach items="${requestScope.userList}" var="userList">
                <tr>
                    <td>${userList.id}</td>
                    <td>${userList.userName}</td>
                    <td>${userList.password}</td>
                    <td>${userList.role}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/mainPage/userSetting/deleteUser?userID=${userList.id}">
                            <button class="deleteButton" type="button">
                                DELETE
                            </button>
                        </a>
                        |
                        <button class="updateUser" type="button"
                                data-id="${userList.id}"
                                data-username="${userList.userName}"
                                data-password="${userList.password}"
                                data-role="${userList.role}">EDIT</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>