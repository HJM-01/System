<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
  <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="../../css/register.css">
<script src="../../js/banner.js"></script>
<body>
<div class="header">
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

          <ul class="nav navbar-nav">
            <li><a href="home.jsp">首页</a></li>

<%--            <li class="dropdown">--%>
              <li>
<%--              <a href="pet%20knowledge.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">--%>
                  <a href="pet%20knowledge.jsp">相处小知识
<%--                  <span class="caret"></span>--%></a>
<%--              <ul class="dropdown-menu">--%>
<%--                <li><a class="dropdown-item" href="#">猫的科普</a></li>--%>
<%--                <li><a class="dropdown-item"   href="#">狗的科普</a></li>--%>
<%--              </ul>--%>
            </li>

            <li><a href="${path}/pet/detail" class="text-primary font-medium">领养中心</a></li>
<%--            <li><a href="#">团队展示</a></li>--%>
            <li><a href="../login.jsp">登录/注册</a></li>
            <li>
              <div class="header-info">
<%--                <div class="header-right">--%>
                  <span class="glyphicon glyphicon-search"></span>
<%--                  <a href="#">--%>
<%--                    <span class="glyphicon glyphicon-search-box" aria-hidden="true"></span>--%>
<%--                  </a>--%>
<%--            </li>--%>

<%--            <li>--%>
<%--                  <div class="search">--%>
<%--                    <form class="navbar-form" action="#" >--%>
                      <input type="text" class="form-control" name="keyword" placeholder="请输入关键词"/>
<%--                      <button type="submit" class="btn btn-default" aria-label="left Align">搜索</button>--%>
<%--                    </form>--%>
<%--                  </div>--%>
<%--                </div>--%>
              </div>
            </li>

          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>
</div>
</body>
</html>