<%--
  Created by IntelliJ IDEA.
  User: 何嘉敏
  Date: 2025/6/6
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>领养中心</title>
  <%--实现响应式布局（适配手机、平板、PC 等不同屏幕尺--%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content=""/>
  <!-- css files -->
  <link rel="stylesheet" href="/css/bootstrap.css" type="text/css" media="all">
  <link rel="stylesheet" type="text/css" href="../../css/register.css">
  <!-- Owl-Carousel-CSS -->
  <link rel="stylesheet" href="/css/adoptionCenter.css" type="text/css" media="all" />
  <script SRC="/js/adpotionCenter.js"></script>
  <script src="/js/jquery-3.4.1.min.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/easing.js"></script>
  <script src="/js/move-top.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="services" id="services">
  <div class="container">
    <h3 class="agile-title">领养中心</h3>
    <div class="w3_agile_services_grids">

    </div>
  </div>

  <div class="w3l-img-side">
    <img src="/image/animal/cat.jpg" alt="" />
  </div>
  <div class="w3l-img-side w3l-img-side2">
    <img src="/image/animal/dog.jpg" alt="" />
  </div>
</div>
<li>
<%--<div id="demo1" class="slideBox">--%>
<%--  <ul class="items">--%>
<%--    <li>--%>
<%--      <div class="circular-image-container">--%>
<%--        <a href=""><img src="/image/微信图片_20250606155528(1).png" alt="领养宣传图1"></a>--%>
<%--      </div>--%>
<%--      <div class="circular-image-container">--%>
<%--        <a href=""><img src="/image/微信图片_20250606160323.jpg" alt="领养宣传图2"></a>--%>
<%--      </div>--%>
<%--      <div class="circular-image-container">--%>
<%--        <a href=""><img src="/image/微信图片_20250606160345(1).png" alt="领养宣传图3"></a>--%>
<%--      </div>--%>
<%--    </li>--%>
<%--  </ul>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--  <!-- 分页条信息 -->--%>
<%--  <div class="col-md-5" id="page_info_area"></div>--%>
<%--  <div class="col-md-4 myPage" id="page_nav_area"></div>--%>
<%--</div>--%>
<jsp:include page="adoptionInformange.jsp"/>
</body>
</html>
