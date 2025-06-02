<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<script src="js/banner.js"></script>
<body>
<div class="header">
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

          <ul class="nav navbar-nav">
            <li><a href="#">首页</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                宠物知识 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">猫的科普</a></li>
                <li><a class="dropdown-item"   href="#">狗的科普</a></li>
              </ul>
            </li>
            <li><a href="#">领养中心</a></li>
            <li><a href="#">团队展示</a></li>
            <li><a href="#">登录</a></li>
            <li><a href="#" class="active">注册 </a></li>
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

<%--            <div class="search-box">--%>

<%--              <a class="search-btn">--%>
<%--                <span class="glyphicon glyphicon-search-box" aria-hidden="true"></span>--%>
<%--              </a>--%>

<%--              <input type="text" class="search-txt" placeholder="搜索" />--%>

<%--              <div class="search-line"></div>--%>
<%--            </div>--%>

          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>
</div>
</body>
</html>