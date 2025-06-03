<%--
  Created by IntelliJ IDEA.
  User: 何嘉敏
  Date: 2025/6/2
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<footer>

    <div class="footer">
        <p>
            <a href="#">联系我们</a>|
            <a href="#">在线留言</a>|
            <a href="https://www.cmse.gov.cn/">友情链接</a>
        </p>
    </div>
    <script>
        function build_page_findByName(result,userName) {
            //page_nav_area
            $("#page_nav_area").empty();
            var ul = $("<ul></ul>").addClass("pagination");

            //构建元素
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
            var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
            if (result.extend.pageInfo.hasPreviousPage == false) {
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            } else {
                //为元素添加点击翻页的事件
                firstPageLi.click(function () {
                    to_findByNamePage(1, userName);
                });
                prePageLi.click(function () {
                    to_findByNamePage(result.extend.pageInfo.pageNum - 1);
                });
            }
        }
    </script>
</footer>
</body>
</html>
