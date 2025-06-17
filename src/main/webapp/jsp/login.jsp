
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025/6/2
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>登录</title>
<%--    <link rel="stylesheet" type="text/css" href="../css/login.css">--%>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../css/register.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script SRC="/js/banner.js"></script>
</head>
<body>
<jsp:include page="user/header.jsp"/>
    <form  action="/jsp/login" name="#" method="post">
        <table>
            <tr aria-rowspan="4">
                <td class="td" rowspan="4" colspan="2">
                    <img src="../image/loginCat.jpeg"  alt="#">
                </td>
                <td colspan="2" class="text1">用户登录</td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="username" placeholder="请输入用户名"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="password" placeholder="请输入密码"></td>
            </tr>

            <tr>
                <td><input type="submit" name="LoginSubmit" value="登  录"></td>
                <td><input onclick="window.location.href='registration.jsp'" type="button" name="register" value="注   册"></td>
            </tr>

        </table>
    </form>
</body>
</html>
