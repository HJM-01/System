<%--
  Created by IntelliJ IDEA.
  User: 何嘉敏
  Date: 2025/6/1
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
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
                <li><a href="#">登陆</a></li>
                <li><a href="#" class="active">注册 </a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        <div class="header-info">
          <div class="header-right ">
            <span class="glyphicon glyphicon-search"></span>
          </div>
        </div>
      </div>
    </div>
  
  </body>
</html>
