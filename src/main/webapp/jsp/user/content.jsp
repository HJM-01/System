<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="banner">
<%--                <div class="wrapper">--%>
        <ul class="carousel" id="myCarousel" style="list-style: none; padding-left: 0;" onmouseover="showFooter()" onmouseout="hideFooter()">
            <li><img alt="示例图片1" src="../../image/QQ图片20250603125958(3).jpeg" class="visible" width="1300px" height="650px"></li>
            <li><img alt="示例图片2" src="../../image/QQ图片20250603125958(1).jpeg" class="hidden" width="1300px" height="650px"></li>
            <li><img alt="示例图片3" src="../../image/QQ图片20250603125958(5).jpeg" class="hidden" width="1300px" height="650px"></li>
            <li><img alt="示例图片4" src="../../image/QQ图片20250603125958.jpeg" class="hidden" width="1300px" height="650px"></li>
        </ul>
<%--                </div>--%>
    </div>
</body>
<footer>
</footer>
<script>
    function showFooter() {
        $('#footer1').animate({bottom: '0'}, 500);
    }
    function hideFooter() {
        $('#footer1').animate({bottom: '-100%'}, 500);
    }
</script>
</html>