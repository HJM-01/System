<%--
  Created by IntelliJ IDEA.
  User: 何嘉敏
  Date: 2025/6/6
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/pet knowledge.css">
    <link rel="stylesheet" type="text/css" href="../../css/register.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="about" id="about">
    <div class="container">
        <h3 class="agile-title">欢迎</h3>
        <div class="about-top w3ls-agile">
            <div class="col-md-6 red">
                <img class="img-responsive" src="/image/about/ab.jpg" alt="">
            </div>
            <div class="col-md-6 come">
                <div class="about-wel">
                    <h5>几句话关于我们的
                        <span>猫狗生活</span>
                    </h5>
                    <p>面对这样可爱的猫和狗谁能不喜爱呢？
                        伤心时，它总是在我身边陪伴着我；
                        开心时，我总会和他一起分享，它成了和我不形影不离的好朋友。</p>
                    <ul>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的健康和关怀</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的美容</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的食物</li>
                        <li>
                            <i class="glyphicon glyphicon-ok"></i>猫和狗的行为</li>
                    </ul>
                </div>
                <div class="button-styles">
                    <a href="#cat" data-toggle="modal" data-target="#Catbtn">养猫注意的地方</a>
                    <a href="#dog" data-toggle="modal" data-target="#Dogbtn">养狗注意的地方</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="gallery" class="gallery">
    <div class="container">
        <h3 class="agile-title">动物介绍</h3>
    </div>
    <div class="agileinfo-gallery-row">
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/c1.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(1).jpeg" alt="" title="Cat Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/d1.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(9).jpeg" alt="" title="Dog Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/c2.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250602202950(2).jpeg" alt="" title="Cat Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/d2.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(12).jpeg" alt="" title="Dog Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/c3.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(13).jpeg" alt="" title="Cat Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/d3.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(14).jpeg" alt="" title="Dog Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/c4.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(15).jpeg" alt="" title="Cat Life Image" width="80%"/>
            </a>
        </div>
        <div class="col-md-3 col-sm-3 col-xs-4 w3gallery-grids">
            <a href="/static/images/about/d4.jpg" class="imghvr-hinge-right figure">
                <img src="/image/QQ图片20250606155055(17).jpeg" alt="" title="Dog Life Image" width="80%"/>
            </a>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<div class="modal fade" id="Catbtn" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">
                    <h4>Cat Life</h4>
                    <img src="/image/about/c2.jpg" alt=" " class="img-responsive" />
                    <p class="para-agileits-w3layouts">
                        我们不能一直将小猫放在家里面养，我们需要时不时的将小猫带出去溜溜,然后，我们在养小猫的时候，还需要多陪小猫玩耍。
                        我们在养小猫的时候，还需要多打理打理它的毛发。
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="Dogbtn" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="modal-info">
                    <h4>Dog Life</h4>
                    <img src="/image/about/d3.jpg" alt=" " class="img-responsive" />
                    <p class="para-agileits-w3layouts">
                        喂食的时间要准，尽量按照在原主人家的习惯喂养，不要喂它们过多的甜食、咸食和刺激性强的食品。
                        刚来的宝宝，主人要亲自喂食，时日积久，便能和爱犬建立起深厚的感情，加深相互信任的程度，
                        主人的另一个重要任务是要帮助小家伙克服离开母亲的痛苦，尽快适应新环境。
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
