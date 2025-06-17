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
<%--<jsp:include page="header.jsp"/>--%>
<div class="myDiv">
  <div>
    <div class="myDiv">
      <div>
<%--        <h2>待领养的动物</h2>--%>
        <center>
          <div id="demo1" class="slideBox">
            <ul class="items" id="petImages">
              <li>
                <div class="circular-image-container">
                  <a href=""><img src="/image/微信图片_20250606155528(1).png" alt="领养宣传图1"></a>
                </div>
                <div class="circular-image-container">
                  <a href=""><img src="/image/微信图片_20250606160323.jpg" alt="领养宣传图2"></a>
                </div>
                <div class="circular-image-container">
                  <a href=""><img src="/image/微信图片_20250606160345(1).png" alt="领养宣传图3"></a>
                </div>
              </li>
            </ul>
          </div>
          <div class="name">
            <img src="<c:url value="/image/adopt/p1.jpg"/>" height="50px" width="50px">
            <span id="petNameSpan">加载中...</span>
          </div>
        </center>
        <div class="animal">
          <div class="group">
            <div class="animalX1">
              <img src="<c:url value="/image/adopt/p2.jpg"/>"><span>编号</span><br>
              <p id="petId">-</p>
            </div>
            <div class="animalX2">
              <img src="<c:url value="/image/adopt/p3.jpg"/>"><span>生日</span><br>
              <p id="petBirthday">-</p>
            </div>
          </div>
          <div class="group">
            <div class="animalX3">
              <img src="<c:url value="/image/adopt/p4.jpg"/>"><span>品种</span><br>
              <p id="petType">-</p>
            </div>
            <div class="animalX4">
              <img src="<c:url value="/image/adopt/p5.jpg"/>"><span>性别</span><br>
              <p id="petSex">-</p>
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
          <div class="animal_me2"><p id="petDescription">加载中...</p></div>
          <div class="animal_me3"><img src="${path}/image/adopt/p11.jpg" alt=""></div>
        </div>
        <div class="my_btn">
          <button class="btn btn-primary btn-lg" id="pet_adopt_modal_btn"
                  data-toggle="modal" data-target="#myAdopt">想要领养</button>
          <button class="btn btn-primary btn-lg" id="tianchuan_btn"
                  style="float: right;position: relative;left: 150px;bottom: 45px">返回中心
          </button>
        </div>
      </div>

      <!-- 模态框（Modal） -->
      <div class="modal fade" id="myAdopt" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">请确认个人信息</h4>
            </div>
            <div class="modal-body">
              <form class="form-horizontal" id="new_adopt_form">
                <input type="hidden" id="userId" name="id">
                <!-- 表单内容将通过AJAX填充 -->
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
              <button type="button" class="btn btn-primary" id="submit_btn">提交申请</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  $(document).ready(function() {
    // 1. 从URL获取ID参数
    const urlParams = new URLSearchParams(window.location.search);
    const petId = urlParams.get('id');

    // 2. 加载宠物数据
    if(petId) {
      loadPetData(petId);
    } else {
      alert("缺少宠物ID参数");
    }

    // 3. 加载用户数据（用于模态框）
    const userId = '<%= session.getAttribute("userId") %>';
    if(userId && userId !== 'null') {
      loadUserData(userId);
    }
  });

  function loadPetData(petId) {
    $.get("${path}/api/pet?id=" + petId, function(pet) {
      // 更新宠物信息
      $("#petNameSpan").text("我叫 " + pet.petName);
      $("#petId").text(pet.id);
      $("#petBirthday").text(pet.birthday);
      $("#petType").text(pet.petType);
      $("#petSex").text(pet.sex);
      $("#petDescription").text("大家好，我是" + pet.petName + "。" + pet.remark + "。你能带我回家吗？");

      // 更新图片轮播
      const pics = pet.pic.split(",");
      const $slideBox = $('#petImages');
      $slideBox.empty();
      pics.forEach(pic => {
        $slideBox.append(`
                <li>
                    <a href=""><img class="my-img" src="${path}/image/animal/${pic.trim()}"></a>
                </li>
            `);
      });

      // 初始化轮播
      $('#demo1').slideBox({ width: 600, height: 400, speed: 0.5 });

      // 设置模态框宠物名
      $("#new_petName").val(pet.petName);
    }).fail(function() {
      alert("加载宠物信息失败！");
    });
  }

  function loadUserData(userId) {
    $.get("${path}/api/user?id=" + userId, function(user) {
      $("#userId").val(user.id);
      $("#new_Name").val(user.userName);
      $("#new_Sex").val(user.sex);
      $("#new_tel").val(user.telephone);
      $("#new_Email").val(user.email);
      $("#new_Adress").val(user.address);
    });
  }

  // 提交领养申请
  $("#submit_btn").click(function() {
    const formData = new FormData(document.getElementById("new_adopt_form"));
    const petId = new URLSearchParams(window.location.search).get('id');
    formData.append("petId", petId);

    $.ajax({
      url: "${path}/adopt/submit",
      type: "POST",
      data: formData,
      processData: false,
      contentType: false,
      success: function() {
        alert("提交申请成功");
        $("#myAdopt").modal('hide');
      },
      error: function() {
        alert("提交申请失败");
      }
    });
  });

  // 返回中心按钮
  $("#tianchuan_btn").click(function() {
    window.location.href = "${path}/user/adoptionCenter";
  });
</script>
</body>
</html>