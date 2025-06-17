<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<%-- 显示错误消息 --%>
<c:if test="${not empty errorMessage}">
    <div>${errorMessage}</div>
</c:if>

<form action="${pageContext.request.contextPath}/jsp/admin/loginServlet" method="post">
    <table>
        <tr aria-rowspan="6">
            <td class="td" rowspan="6" colspan="2">
                <img src="${pageContext.request.contextPath}/image/loginCat.jpeg" alt="#">
            </td>
            <td colspan="2" class="text1">用户登录</td>
        </tr>

        <tr>
            <td colspan="2"><input type="text" name="username" placeholder="请输入用户名" required></td>
        </tr>

        <tr>
            <td colspan="2"><input type="password" name="password" placeholder="请输入密码" required></td>
        </tr>

        <tr>
            <td><input type="submit" value="登   录"></td>
            <td><input onclick="window.location.href='${pageContext.request.contextPath}/jsp/registration.jsp'" type="button" value="注  册"></td>
        </tr>
    </table>
</form>
</body>
</html>