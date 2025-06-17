<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <%-- 显示错误消息 --%>
    <% if(request.getAttribute("errorMessage") != null) { %>
    <div class="error-message"><%= request.getAttribute("errorMessage") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/jsp/admin/loginServlet" method="post">
        <table>
            <tr aria-rowspan="6">
                <td class="td" rowspan="6" colspan="2">
                    <img src="${pageContext.request.contextPath}/image/loginCat.jpeg" alt="#">
                </td>
                <td colspan="2" class="text1">登录</td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="username" placeholder="请输入名称" required></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="password" placeholder="请输入密码" required></td>
            </tr>

            <tr>
                <td><label for="admin">管理员</label>
                <input type="radio" name="identity" id="admin" value="admin"></td>

                <td><label for="user">用户</label>
                <input type="radio" name="identity" id="user" value="user"></td>
            </tr>

            <tr>
                <td><input type="submit" value="登   录"></td>
                <td><input onclick="window.location.href='${pageContext.request.contextPath}/jsp/registration.jsp'" type="button" value="注  册"></td>
            </tr>
        </table>
    </form>
</body>
</html>