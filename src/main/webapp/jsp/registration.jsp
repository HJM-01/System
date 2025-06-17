<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2025/6/3
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<%--    显示成功与否--%>
    <c:if test="${not empty Message}">
        <div>${Message}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/registrationServlet" method="post">
        <table>
            <tr aria-rowspan="6" > 
                <td class="td" rowspan="6" colspan="2">
                    <img src="${pageContext.request.contextPath}/image/loginCat.jpeg" alt="#">
                </td>
                <td colspan="2" class="text1">用户注册</td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="username" placeholder="请输入名称"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="password" placeholder="请输入密码"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="password" name="SecondPassword" placeholder="请再次输入密码"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="text" name="phoneNumber" placeholder="请输入联系方式"></td>
            </tr>

            <tr>
                <td><input onclick="window.location.href='${pageContext.request.contextPath}/jsp/login.jsp'" type="button" name="LoginSubmit" value="登  录"></td>
                <td><input type="submit" name="register" value="注   册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
