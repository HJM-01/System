<!-- admin-3edit.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>编辑猫咪信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        h2 {
            margin-top: 0;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .grid {
            display: grid;
            grid-template-columns: 1fr;
            gap: 15px;
        }

        @media (min-width: 600px) {
            .grid {
                grid-template-columns: 1fr 1fr;
            }
        }

        .buttons {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            margin-top: 20px;
        }

        button {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-cancel {
            background-color: #f0f0f0;
            color: #333;
            border: 1px solid #ddd;
        }

        .btn-save {
            background-color: #ffa000;
            color: white;
        }

        .btn-save:hover {
            background-color: #ffa000;
        }

        .btn-cancel:hover {
            background-color: #e0e0e0;
        }

        img {
            border-radius: 50%;
            width: 80px;
            height: 80px;
            object-cover: cover;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>编辑猫咪信息</h2>

    <form action="${pageContext.request.contextPath}/petUpdate" method="post">
        <input type="hidden" name="id" value="${pet.id}">

        <div class="grid">
            <div class="form-group">
                <label>猫名</label>
                <input type="text" name="petName" value="${pet.petName}" required>
            </div>

            <div class="form-group">
                <label>品种</label>
                <input type="text" name="petType" value="${pet.petType}" required>
            </div>

            <div class="form-group">
                <label>性别</label>
                <select name="sex" required>
                    <option value="公" ${pet.sex == '公' ? 'selected' : ''}>公</option>
                    <option value="母" ${pet.sex == '母' ? 'selected' : ''}>母</option>
                </select>
            </div>

            <div class="form-group">
                <label>发现日期</label>
                <input type="date" name="birthday" value="${pet.birthday}" required>
            </div>

            <div class="form-group">
                <label>领养状态</label>
                <select name="state" required>
                    <option value="1" ${pet.state == 1 ? 'selected' : ''}>无领养申请</option>
                    <option value="2" ${pet.state == 2 ? 'selected' : ''}>被申请领养</option>
                    <option value="3" ${pet.state == 3 ? 'selected' : ''}>已被领养</option>
                </select>
            </div>

            <div class="form-group">
                <label>描述</label>
                <textarea name="remark" rows="3">${pet.remark}</textarea>
            </div>

            <div class="form-group">
                <label>当前照片</label>
                <img src="${pet.pic}" alt="猫照片">
            </div>
        </div>

        <div class="buttons">
            <button type="button" onclick="history.back()" class="btn-cancel">取消</button>
            <button type="submit" class="btn-save">保存修改</button>
        </div>
    </form>
</div>
</body>
</html>
