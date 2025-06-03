<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025/6/3
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <form action="#" name="registration" method="post">
        <table>
            <tr rowspan="6">
                <td class="td" rowspan="6" colspan="2">
                    <img src="image/loginCat.jpeg" >
                </td>
                <td colspan="2" class="text1">用户注册</td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="username" placeholder="请输入用户名"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="password" placeholder="请输入密码"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="SecondPassword" placeholder="请再次确认密码"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="phoneNumber" placeholder="联系方式"></td>
            </tr>

            <tr>
                <td><input type="submit" name="LoginSubmit" value="登  录"></td>
                <td><input type="submit" name="register" value="注   册"></td>
            </tr>

        </table>
    </form>

</body>
</html>
