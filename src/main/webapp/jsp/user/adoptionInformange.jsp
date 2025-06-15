<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<%--<%@ taglib uri="https://jakarta.ee/xml/ns/jakartaee/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="https://jakarta.ee/xml/ns/jakartaee/jstl/fmt" prefix="fmt" %>--%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>动物的具体信息</title>
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/adoptionInformage.css"/>" type="text/css"/>
  <link rel="stylesheet" type="text/css" href="../../css/register.css">
  <script src="<c:url value="/js/jquery-3.4.1.min.js"/>"></script>
  <script src="<c:url value="/js/bootstrap.js"/>"></script>
  <script src="<c:url value="/js/jquery.slideBox.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/js/jquery.comment.js"/>"></script>
  <script src="<c:url value="/js/adoptionInformage.js"/>"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="myDiv">
  <div>
    <div class="myDiv">
      <div>
        <h2>待领养的动物</h2>
        <center>
          <div id="demo1" class="slideBox">
            <ul class="items">
              <c:forEach items="${pics}" var="pic">
                <li>
                  <a href=""><img class="my-img" src="/static/images/animal/${pic}"></a>
                </li>
              </c:forEach>
            </ul>
          </div>
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
                  style="float: right;position: relative;left: 150px;bottom: 45px">返回中心
          </button>
        </div>
      </div>

      <!-- 模态框（Modal） -->
<%--      <form action="adoptionInformance" method="post">--%>
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
                <form class="form-horizontal" id="new_adopt_form">
                  <input type="hidden" value="${user.id}" name="id">
                  <div class="form-group">
                    <label for="new_Name" class="col-sm-2 control-label">
                      领养人： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_Name"
                             placeholder="请输入领养人姓名" name="userName" value="${user.userName}" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="new_petName" class="col-sm-2 control-label">
                      宠物名： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_petName"
                             placeholder="请输入宠物的名字" name="petName" value="${pet.petName}" readonly>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="new_Sex" class="col-sm-2 control-label">
                      性别： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_Sex"
                             placeholder="请输入领养人性别" name="sex" value="${user.sex}" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="new_tel" class="col-sm-2 control-label">
                      电话： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_tel"
                             placeholder="请输入领养人电话" name="telephone" value="${user.telephone}" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="new_Email" class="col-sm-2 control-label">
                      邮件： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_Email"
                             placeholder="请输入领养人电话" name="new_Email" value="${user.email}" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="new_Adress" class="col-sm-2 control-label">
                      地址： </label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="new_Adress"
                             placeholder="请输入领养人地址" name="address" value="${user.address}" />
                    </div>
                  </div>
                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="adopt_btn">关闭
                </button>
                <button type="button" class="btn btn-primary" id="submit_btn">提交申请</button>
              </div>
            </div><!-- /.modal-content -->
          </div>
        </div>
<%--        </form>--%>
      </div>
    </div>
  </div>