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
        <span class="glyphicon glyphicon-search">
          <a href="#">
            <span class="glyphicon glyphicon-search-box" aria-hidden="true"></span>
          </a>
          <div class="search">
            <from class="navbar-form" action="/animals_search">
              <input type="text" class="form-control" name="keyword">
              <button type="submit" class="btn btn-default" aria-label="left Align">搜索</button>
            </from>
          </div>
        </span>
      </div>
    </div>
  </div>
</div>
<div class="banner">
  <div class="wrapper">
    <ul class="carousel" id="carousel">
      <li><img src="./image/QQ图片20250602202950(1).jpeg" width="1300" height="700" class="visible"></li>
      <li><img src="./image/QQ图片20250602202950(2).jpeg" width="1300" height="700" class="hidden"></li>
      <li><img src="./image/QQ图片20250602202950(4).jpeg" width="1300" height="700" class="hidden"></li>
      <li><img src="./image/QQ图片20250602202950(5).jpeg" width="1300" height="700" class="hidden"></li>
    </ul>
  </div>
</body>
</html>