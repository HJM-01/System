<%--
  Created by IntelliJ IDEA.
  User: 何嘉敏
  Date: 2025/6/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>可领养宠物列表</h2>
    <div class="row">
        <c:forEach items="${petList}" var="pet">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/images/pets/${pet.image}"
                         class="card-img-top" alt="${pet.petName}">
                    <div class="card-body">
                        <h5 class="card-title">${pet.petName}</h5>
                        <p class="card-text">
                            品种：${pet.breed}<br>
                            年龄：${pet.age}岁
                        </p>
                        <a href="${pageContext.request.contextPath}/adoption/detail?id=${pet.id}"
                           class="btn btn-primary">查看详情</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
