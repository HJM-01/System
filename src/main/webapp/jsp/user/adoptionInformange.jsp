<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>动物的具体信息</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" href="/css/adoptionCenter.css" type="text/css" media="all" />
    <link rel="stylesheet" href="<c:url value="/css/adoptionInformage.css"/>" type="text/css"/>
    <script src="<c:url value="/js/jquery-3.4.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/js/jquery.slideBox.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/jquery.comment.js"/>"></script>
    <script src="<c:url value="/js/adoptionInformage.js"/>"></script>

    <style>
        /* 新增的样式确保模态框输入框可见 */
        #myAdopt .modal-body {
            padding: 20px !important;
            overflow: visible !important;
        }

        #myAdopt .form-group {
            margin-bottom: 15px !important;
            clear: both !important;
        }

        #myAdopt .form-control {
            display: block !important;
            width: 100% !important;
            height: 34px !important;
            padding: 6px 12px !important;
            font-size: 14px !important;
            line-height: 1.42857143 !important;
            color: #555 !important;
            background-color: #fff !important;
            background-image: none !important;
            border: 1px solid #ccc !important;
            border-radius: 4px !important;
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075) !important;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s !important;
        }

        #myAdopt label.control-label {
            padding-top: 7px !important;
            margin-bottom: 0 !important;
            text-align: right !important;
        }

        /* 确保列布局正确 */
        @media (min-width: 768px) {
            #myAdopt .col-sm-2 {
                width: 16.66666667% !important;
                float: left !important;
            }
            #myAdopt .col-sm-10 {
                width: 83.33333333% !important;
                float: left !important;
            }
        }

        /* 修正模态框宽度 */
        #myAdopt .modal-dialog {
            width: 600px !important;
            max-width: 90% !important;
        }
    </style>
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="myDiv">
    <div>
        <div class="myDiv">
            <div>
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
                <center>
                    <div class="name">
                        <img src="<c:url value="/image/adopt/p1.jpg"/>" height="50px" width="50px">
                        <span>我叫 ${pet.petName}</span>
                    </div>
                </center>
                <div class="animal">
                    <div class="group">
                        <div class="animalX1">
                            <img src="<c:url value="/image/adopt/p2.jpg"/>"><span>编号</span><br>
                            <p>${pet.id}</p>
                        </div>
                        <div class="animalX2">
                            <img src="<c:url value="/image/adopt/p3.jpg"/>"><span>生日</span><br>
                            <p>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${pet.birthday}"/>
                            </p>
                        </div>
                    </div>
                    <div class="group">
                        <div class="animalX3">
                            <img src="<c:url value="/image/adopt/p4.jpg"/>"><span>品种</span><br>
                            <p>${pet.petType}</p>
                        </div>
                        <div class="animalX4">
                            <img src="<c:url value="/image/adopt/p5.jpg"/>"><span>性别</span><br>
                            <p>${pet.sex}</p>
                        </div>
                    </div>
                </div>
                <div class="animal_me">
                    <div class="animal_me1">
                        <img src="<c:url value="/image/adopt/p6.jpg"/>">
                        <img src="<c:url value="/image/adopt/p7.jpg"/>">
                        <img src="<c:url value="/image/adopt/p8.jpg"/>">
                        <img src="<c:url value="/image/adopt/p9.jpg"/>">
                        <img src="<c:url value="/image/adopt/p10.jpg"/>">
                    </div>
                    <div class="animal_me2"><p>大家好，我是${pet.petName}。${pet.remark}。你能带我回家吗？</p></div>
                    <div class="animal_me3"><img src="/image/adopt/p11.jpg"></div>
                </div>
                <div class="my_btn">
                    <button class="btn btn-primary btn-lg" id="pet_adopt_modal_btn"
                            data-toggle="modal" data-target="#myAdopt">想要领养</button>
                    <button class="btn btn-primary btn-lg" id="tianchuan_btn"
                            style="float: right;position: relative;left: 150px;bottom: 45px"
                            onclick="returnToCenter()" class="btn btn-primary">返回中心</button>
                </div>
            </div>

            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myAdopt" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                请确认个人信息
                            </h4>
                        </div>

                        <div class="modal-body">
                            <form action="/adopt/simple-submit" class="form-horizontal" id="new_adopt_form"  method="post">
                                <input type="hidden" value="${user.id}" name="id">

                                <div class="form-group">
                                    <label for="new_Name" class="col-sm-2 control-label">
                                        领养人： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_Name"
                                               placeholder="请输入领养人姓名" name="userName" value="${user.userName}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="new_petName" class="col-sm-2 control-label">
                                        宠物名： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_petName"
                                               placeholder="请输入宠物的名字" name="petName" value="${pet.petName}" >
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="new_Sex" class="col-sm-2 control-label">
                                        性别： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_Sex"
                                               placeholder="请输入领养人性别" name="sex" value="${user.sex}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="new_tel" class="col-sm-2 control-label">
                                        电话： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_tel"
                                               placeholder="请输入领养人电话" name="telephone" value="${user.telephone}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="new_Email" class="col-sm-2 control-label">
                                        邮件： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_Email"
                                               placeholder="请输入领养人邮箱" name="email" value="${user.email}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="new_Adress" class="col-sm-2 control-label">
                                        地址： </label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="new_Adress"
                                               placeholder="请输入领养人地址" name="address" value="${user.address}">
                                    </div>
                                </div>

                            </form>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" id="adopt_btn">关闭</button>
                            <button type="submit" class="btn btn-primary" form="new_adopt_form">提交申请</button>
<%--                            <button type="submit" class="btn btn-primary">提交申请</button>--%>
<%--                            <input type="submit" value="提交">--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function returnToCenter() {
        window.location.href = '${pageContext.request.contextPath}/adoption/list';
    }

    $(document).ready(function() {
        // 确保模态框已注册
        $('#myAdopt').modal({
            show: false, // 初始不显示
            backdrop: 'static' // 点击外部不关闭
        });
        document.getElementById('next_pet_btn').addEventListener('click', function() {
            var currentPetId = ${pet.id};
            window.location.href = '/pet/detail?id=' + (currentPetId + 1) + '&next=true';

        // 点击申请按钮弹出模态框
        $("#pet_adopt_modal_btn").click(function () {
            try {
                // 预填充表单数据
                $("#new_Name").val("${user.userName}");
                $("#new_Sex").val("${user.sex}");
                $("#new_tel").val("${user.telephone}");
                $("#new_Email").val("${user.email}");
                $("#new_Adress").val("${user.address}");
            } catch (e) {
                console.error("Error opening adoption form:", e);
                alert("初始化表单失败，请刷新页面重试");
            }
        });

        // 点击保存，保存到申请表
        $("#submit_btn").click(function () {
            var formData = new FormData(document.getElementById("new_adopt_form"));

            $.ajax({
                url: "${path}/adopt/submit",
                type: "POST",
                data: formData,
                processData: false,  // 告诉jQuery不要去处理发送的数据
                contentType: false,  // 告诉jQuery不要去设置Content-Type请求头
                success: function (result) {
                    alert("提交申请成功");
                    $("#myAdopt").modal('hide');
                },
                error: function (result) {
                    console.log(result);
                    alert("提交申请失败");
                }
            });
        });
            document.addEventListener('DOMContentLoaded', function() {
                // 确保按钮和表单存在
                const submit_btn = document.getElementById('submit_btn');
                const form = document.getElementById('new_adopt_form');

                if (submit_btn && form) {
                    // 绑定点击事件（使用箭头函数确保this指向正确）
                    submit_btn.addEventListener('click', () => {
                        // 表单验证（示例：检查必填字段）
                        const userName = document.getElementById('new_Name').value;
                        const petName = document.getElementById('new_petName').value;
                        if (!userName || !petName) {
                            alert('请填写领养人和宠物名称');
                            return;
                        }

                        // 序列化表单数据
                        const formData = new FormData(form);

                        // 发送数据到管理系统页面（使用POST请求）
                        fetch('/adopt/simple-submit', {
                            method: 'POST',
                            body: formData
                        })
                            .then(response => {
                                if (!response.ok) {
                                    throw new Error('网络请求失败');
                                }
                                return response.text();
                            })
                            .then(html => {
                                // 提交成功提示
                                alert('申请提交成功！');

                                // 关闭模态框（使用Bootstrap API）
                                const modal = new bootstrap.Modal(document.getElementById('myAdopt'));
                                modal.hide();

                                // 刷新当前页面或跳转到管理系统
                                // location.href = 'admin-agree.jsp'; // 如需跳转可取消注释
                            })
                            .catch(error => {
                                console.error('提交失败:', error);
                                alert('提交申请失败，请稍后重试');
                            });
                    });
                } else {
                    console.warn('未找到提交按钮或表单元素');
                }
            });
        });
    });
</script>
</body>
</html>