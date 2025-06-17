<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2025/6/18
  Time: 00:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>用户系统</title>

  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../../css/admin.css">

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
</head>

<body class="bg-gray-50 font-sans antialiased text-gray-800">

<div class="flex h-screen overflow-hidden">
  <!-- 侧边栏导航 -->
  <aside id="sidebar" class="bg-gray-105 shadow-lg w-64 flex-shrink-0 hidden md:block transition-all duration-300 ease-in-out z-20">

    <div class="flex items-center justify-between p-4 border-b">
      <div class="flex items-center space-x-2">
        <i class="fa fa-cogs text-primary text-2xl"></i>
        <h1 class="text-xl font-bold text-primary">用户系统</h1>
      </div>
      <button id="close-sidebar" class="md:hidden text-gray-500 hover:text-gray-700">
        <i class="fa fa-times"></i>
      </button>
    </div>

    <%--      主导航和系统设置--%>
    <nav class="p-4">
      <div class="space-y-1">
        <p class="text-xs font-semibold text-gray-400 uppercase tracking-wider mb-2">系统设置</p>

        <a href="UserLogin.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
          <i class="fa fa-file-text-o"></i>
          <span>个人资料</span>
        </a>

        <a href="UserLogin.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
          <i class="fa fa-heart-o"></i>
          <span>收养申请</span>
        </a>

        <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
          <i class="fa fa-bell-o"></i>
          <span>我的消息</span>
        </a>
      </div>
    </nav>

    <%--      左下角账户显示--%>
    <div class="absolute bottom-0 w-full p-4 border-t">
      <div class="flex items-center space-x-3">
        <img src="https://picsum.photos/id/1005/200/200" alt="用户头像" class="w-10 h-10 rounded-full object-cover">
        <div>
          <p class="font-medium">${user.userName}</p>
          <p class="text-xs text-gray-500">admin@example.com</p>
        </div>
        <button onclick="window.location.href='http://localhost:8080/System_war/jsp/user/home.jsp'" class="ml-auto text-gray-500 hover:text-gray-700">
          <i class="fa fa-sign-out"></i>
        </button>
      </div>
    </div>

  </aside>

  <!-- 主内容区 -->
  <div class="flex-1 flex flex-col overflow-hidden">
    <!-- 顶部导航 -->
    <header class="primary shadow-sm z-10">
      <div class="flex items-center justify-between p-4">
        <div class="flex items-center space-x-6">
        </div>
      </div>
    </header>

    <!-- 内容区域 -->
    <main class="flex-1 overflow-y-auto bg-gray-50 p-6 animate-fadeIn">
      <!-- 操作区域 -->
      <div class="max-w-7xl mx-auto">
        <div class="bg-white rounded-xl shadow p-6 mb-6">
          <h2 class="text-xl font-bold text-gray-800 mb-4">个人信息</h2>

          <div class="mt-4 flex justify-between items-center">
<%--            <button onclick="window.location.href='http://localhost:8080/System_war/jsp/admin/PetServlet'" class="px-4 py-2 bg-primary text-white rounded-lg hover:bg-primary/90 transition-colors">--%>
<%--              <i class="fa fa-search mr-2"></i>申请--%>
<%--            </button>--%>

            <button  onclick="window.location.href='#'" class="px-4 py-2 bg-success text-white rounded-lg hover:bg-success/90 transition-colors">
              <i class="fa fa-plus mr-2"></i>申请
            </button>
          </div>
        </div>

        <!-- 数据展示区域 -->
        <div class="bg-white rounded-xl shadow mb-6">
<%--          列表名--%>
          <div class="p-6 border-b flex justify-between items-center">
            <h3 class="font-semibold text-lg">申请列表</h3>
            <%--            <span class="text-sm text-gray-500">共 <strong>256</strong> 条记录</span>--%>
          </div>

<%--          列表--%>
          <div class="overflow-x-auto">
            <table class="min-w-full divide-y divide-gray-200">
              <tbody class="bg-white divide-y divide-gray-200">
              <%--          标题行--%>
              <thead class="bg-gray-50">
              <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">用户ID</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">用户名</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">电话号码</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">性别</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"></th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
              </tr>
              </thead>
<%--              列表项--%>
              <c:forEach items="${AdminList}" var="item">
                <tr class="hover:bg-gray-50 transition-colors">
                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${item.id}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">${item.adminName}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${item.telephone}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${item.sex}</td>
                    <%--                            <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"></td>--%>
                  <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                    <a href="#" class="text-primary hover:text-primary/80 mr-3">查看</a>
                    <a href="#" class="text-gray-600 hover:text-gray-900 mr-3">编辑</a>
                    <a href="#" class="text-danger hover:text-danger/80">删除</a>
                  </td>
                </tr
              </c:forEach>
              </tbody>
            </table>
          </div>

        </div>
      </div>
    </main>
  </div>
</div>

<!-- 移动端侧边栏遮罩 -->
<div id="sidebar-overlay" class="fixed inset-0 bg-gray-900 bg-opacity-50 z-10 hidden md:hidden"></div>

<!-- JavaScript -->
<script>
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

  // 初始化页面加载动画
  document.addEventListener('DOMContentLoaded', () => {
    // 这里可以添加页面加载完成后的动画或初始化逻辑
  });
</script>
</body>
</html>
