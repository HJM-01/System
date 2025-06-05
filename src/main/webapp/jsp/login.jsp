
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025/6/2
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
    <form action="login" name="#" method="post">
        <table>
            <tr rowspan="4">
                <td class="td" rowspan="4" colspan="2">
                    <img src="../image/loginCat.jpeg" >
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
                <td><input type="button" name="register" value="注   册"></td>
            </tr>

        </table>
    </form>
</body>
</html>
