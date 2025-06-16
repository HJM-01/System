<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lynnlyt
  Date: 2025/6/5
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%--<%@ page import="Pet" %>--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>添加猫咪 - 管理系统</title>
  <!-- Tailwind CSS -->
  <script src="https://cdn.tailwindcss.com"></script>
  <!-- Font Awesome -->
  <link href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" rel="stylesheet">

  <!-- Tailwind配置 -->
  <script>
    tailwind.config = {
      theme: {
        extend: {
          colors: {
            primary: '#ffa000',
            secondary: '#3b82f6',
            accent: '#60a5fa',
            neutral: '#f3f4f6',
            success: '#10b981',
            warning: '#f59e0b',
            danger: '#ef4444',
            info: '#06b6d4',
          },
          fontFamily: {
            sans: ['Inter', 'system-ui', 'sans-serif'],
          },
        },
      }
    }
  </script>

  <!-- 自定义工具类 -->
  <style type="text/tailwindcss">
    @layer utilities {
      .content-auto {
        content-visibility: auto;
      }
      .animate-fadeIn {
        animation: fadeIn 0.3s ease-in-out;
      }
      @keyframes fadeIn {
        from { opacity: 0; transform: translateY(10px); }
        to { opacity: 1; transform: translateY(0); }
      }
    }
  </style>
</head>
<body class="bg-gray-50 font-sans antialiased text-gray-800">
<div class="flex h-screen overflow-hidden">

  <!-- 主内容区 -->
  <div class="flex-1 flex flex-col overflow-hidden">
    <!-- 顶部导航 -->
    <header class="bg-white shadow-sm z-10">
      <div class="flex items-center justify-between p-4">
        <div class="flex items-center">
          <button id="toggle-sidebar" class="mr-4 text-gray-500 hover:text-gray-700 md:hidden">
            <i class="fa fa-bars"></i>
          </button>
          <div class="relative">
              <span class="absolute inset-y-0 left-0 flex items-center pl-3">
                <i class="fa fa-search text-gray-400"></i>
              </span>
            <input type="text" placeholder="搜索..." class="pl-10 pr-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary w-64">
          </div>
        </div>

        <div class="flex items-center space-x-6">
          <button class="relative text-gray-500 hover:text-gray-700">
            <i class="fa fa-bell-o text-xl"></i>
            <span class="absolute -top-1 -right-1 bg-danger text-white text-xs rounded-full h-4 w-4 flex items-center justify-center">3</span>
          </button>

          <button class="relative text-gray-500 hover:text-gray-700">
            <i class="fa fa-envelope-o text-xl"></i>
            <span class="absolute -top-1 -right-1 bg-secondary text-white text-xs rounded-full h-4 w-4 flex items-center justify-center">5</span>
          </button>

          <div class="hidden md:block">
            <div class="flex items-center space-x-2">
              <img src="https://picsum.photos/id/1005/200/200" alt="用户头像" class="w-8 h-8 rounded-full object-cover">
              <span>管理员</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- 内容区域 -->
    <main class="flex-1 overflow-y-auto bg-gray-50 p-6 animate-fadeIn">
      <div class="max-w-7xl mx-auto">
        <!-- 页面标题和导航 -->
        <div class="mb-6 flex justify-between items-center">
          <div>
            <h2 class="text-xl font-bold text-gray-800">添加新猫咪</h2>
            <p class="text-gray-500 mt-1">填写以下信息以添加</p>
          </div>
          <div>
            <a href="admin-3.jsp" class="inline-flex items-center text-primary hover:text-primary/80 transition-colors">
              <i class="fa fa-arrow-left mr-2"></i> 返回猫咪列表
            </a>
          </div>
        </div>

        <!-- 用户表单 -->
        <div class="bg-white rounded-xl shadow p-6 mb-6 transform transition-all duration-300 hover:shadow-lg">
          <form id="CatForm" action="Pet" method="post" enctype="multipart/form-data">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
              <!-- 左侧表单区域 -->
              <div>

                <!-- 猫名 -->
                <div class="mb-4">
                  <label for="petName" class="block text-sm font-medium text-gray-700 mb-1">猫名</label>
                  <input type="text" id="petName" name="petName" required
                         class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all" placeholder="请输入猫名">
                </div>
                <%--品种--%>
                <div class="mb-4">
                  <label for="petType" class="block text-sm font-medium text-gray-700 mb-1">品种</label>
                  <input type="text" id="petType" name="petType" required
                         class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all" placeholder="请输入品种">
                </div>

                <!-- 性别 -->
                <div class="mb-4">
                  <label for="sex" class="block text-sm font-medium text-gray-700 mb-1">性别</label>
                  <select id="sex" name="sex" required
                          class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all">
                    <option value="">请选择状态</option>
                    <option value="male">雄性</option>
                    <option value="female">雌性</option>
                  </select>
                </div>

                <!-- 发现日期 -->
                <div class="mb-4">
                  <label for="birthday" class="block text-sm font-medium text-gray-700 mb-1">发现日期</label>
                  <input type="date" id="birthday" name="birthday" required
                         class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all" placeholder="请输入发现日期">
                </div>


              </div>
              <!-- 右侧表单区域 -->
              <div>
                <!-- 领养状态 -->
                <div class="mb-4">
                  <label for="state" class="block text-sm font-medium text-gray-700 mb-1">领养状态</label>
                  <select id="state" name="state" required
                          class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all">
                    <option value="">请选择领养状态</option>
                    <option value="1">无领养申请</option>
                    <option value="2">被申请领养</option>
                    <option value="1">已被领养</option>

                  </select>
                </div>

                <div class="mb-4">
                  <label for="remark" class="block text-sm font-medium text-gray-700 mb-1">添加描述</label>
                  <input type="text" id="remark" name="remark" required
                         class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary transition-all" placeholder="请输入描述">
                </div>
                <!-- 猫咪照片上传 -->
                <div class="mb-4">
                  <label class="block text-sm font-medium text-gray-700 mb-1">照片</label>
                  <div class="flex items-center justify-center w-full">
                    <label for="petPic" class="flex flex-col items-center justify-center w-full h-40 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 hover:bg-gray-100 transition-colors">
                      <div class="flex flex-col items-center justify-center pt-5 pb-6">
                        <i class="fa fa-cloud-upload text-3xl text-gray-400 mb-2"></i>
                        <p class="mb-2 text-sm text-gray-500"><span class="font-semibold">点击上传头像</span> 或拖放文件</p>
                        <p class="text-xs text-gray-500">支持 JPG, PNG 格式，最大 2MB</p>
                      </div>
                      <input id="petPic" name="petPic" type="file" accept="image/*" class="hidden" />
                    </label>
                  </div>
                  <div id="previewContainer" class="mt-2 hidden">
                    <img id="avatarPreview" src="" alt="头像预览" class="w-20 h-20 rounded-full object-cover border-2 border-primary/20 shadow-sm">
                  </div>
                </div>
              </div>
            </div>

            <!-- 表单按钮 -->
            <div class="mt-6 flex justify-end space-x-3">
              <button type="button" onclick="resetForm()" class="px-4 py-2 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50 transition-colors shadow-sm hover:shadow">
                <i class="fa fa-refresh mr-2"></i>重置
              </button>
              <button type="submit" class="px-4 py-2 bg-primary text-white rounded-lg hover:bg-primary/90 transition-colors shadow-sm hover:shadow">
                <i class="fa fa-save mr-2"></i>保存
              </button>
            </div>
          </form>
        </div>
      </div>
    </main>
  </div>
</div>

<!-- 移动端侧边栏遮罩 -->
<div id="sidebar-overlay" class="fixed inset-0 bg-gray-900 bg-opacity-50 z-10 hidden md:hidden"></div>

<!-- JavaScript -->
<script>
  // 页面加载完成后执行
  document.addEventListener('DOMContentLoaded', function() {

    // 头像预览功能
    const avatarInput = document.getElementById('petPic');
    const previewContainer = document.getElementById('previewContainer');
    const avatarPreview = document.getElementById('avatarPreview');

    avatarInput.addEventListener('change', function() {
      const file = this.files[0];
      if (file) {
        const reader = new FileReader();

        reader.addEventListener('load', function() {
          avatarPreview.setAttribute('src', this.result);
          previewContainer.classList.remove('hidden');
          // 添加预览图出现的动画
          avatarPreview.classList.add('animate-fadeIn');
        });

        reader.readAsDataURL(file);
      } else {
        previewContainer.classList.add('hidden');
      }
    });

    // 侧边栏交互
    const toggleSidebar = document.getElementById('toggle-sidebar');
    const closeSidebar = document.getElementById('close-sidebar');
    const sidebar = document.getElementById('sidebar');
    const sidebarOverlay = document.getElementById('sidebar-overlay');

    toggleSidebar.addEventListener('click', () => {
      sidebar.classList.toggle('hidden');
      sidebarOverlay.classList.toggle('hidden');
      document.body.classList.toggle('overflow-hidden');
    });

    closeSidebar.addEventListener('click', () => {
      sidebar.classList.add('hidden');
      sidebarOverlay.classList.add('hidden');
      document.body.classList.remove('overflow-hidden');
    });

    sidebarOverlay.addEventListener('click', () => {
      sidebar.classList.add('hidden');
      sidebarOverlay.classList.add('hidden');
      document.body.classList.remove('overflow-hidden');
    });
  });

  // 重置表单
  function resetForm() {
    document.getElementById('userForm').reset();
    document.getElementById('userId').value = '';
    document.getElementById('previewContainer').classList.add('hidden');
    generateUserId();

    // 重置表单元素的样式
    const formInputs = document.querySelectorAll('#userForm input, #userForm select');
    formInputs.forEach(input => {
      input.classList.remove('focus:ring-2', 'focus:ring-primary/50', 'focus:border-primary');
    });
  }
</script>
</body>
</html>
