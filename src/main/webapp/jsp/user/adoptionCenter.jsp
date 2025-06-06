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
    <img src="/static/images/animal/cat.jpg" alt="" />
  </div>
  <div class="w3l-img-side w3l-img-side2">
    <img src="/static/images/animal/dog.jpg" alt="" />
  </div>
</div>
<div class="row">
  <!-- 分页条信息 -->
  <div class="col-md-5" id="page_info_area"></div>
  <div class="col-md-4 myPage" id="page_nav_area"></div>
</div>
</body>
</html>
