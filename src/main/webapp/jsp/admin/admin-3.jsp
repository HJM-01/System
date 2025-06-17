<%--
  Created by IntelliJ IDEA.
  User: Lynnlyt
  Date: 2025/6/3
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理系统</title>
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
                <h1 class="text-xl font-bold text-primary">管理系统</h1>
            </div>
            <button id="close-sidebar" class="md:hidden text-gray-500 hover:text-gray-700">
                <i class="fa fa-times"></i>
            </button>
        </div>

        <nav class="p-4">
            <div class="space-y-1">
                <p class="text-xs font-semibold text-gray-400 uppercase tracking-wider mb-2">主导航</p>

                <a href="admin-agree.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg sidebar-item-active">
                    <i class="fa fa-tachometer"></i>
                    <span>同意收养列表</span>
                </a>

                <a href="admin-disagree.jsp" class=" flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-users"></i>
                    <span>不同意收养列表</span>
                </a>

                <a href="Adoption_Application.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-heart-o"></i>
                    <span>收养申请管理</span>
                </a>

                <a href="admin-3.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-id-card"></i>
                    <span>流浪猫信息管理</span>
                </a>

                <a href="admin-4.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-file-text-o"></i>
                    <span>志愿者申请</span>
                </a>
            </div>

            <div class="space-y-1 mt-8">
                <p class="text-xs font-semibold text-gray-400 uppercase tracking-wider mb-2">系统设置</p>

                <a href="admin-1.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-cog"></i>
                    <span>用户管理</span>
                </a>

                <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-user-circle-o"></i>
                    <span>个人设置</span>
                </a>
            </div>
        </nav>

        <div class="absolute bottom-0 w-full p-4 border-t">
            <div class="flex items-center space-x-3">
                <img src="https://picsum.photos/id/1005/200/200" alt="用户头像" class="w-10 h-10 rounded-full object-cover">
                <div>
                    <p class="font-medium">管理员</p>
                    <p class="text-xs text-gray-500">admin@example.com</p>
                </div>
                <button class="ml-auto text-gray-500 hover:text-gray-700">
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
                <!-- 查询条件区域 -->
                <div class="bg-white rounded-xl shadow p-6 mb-6">
                    <h2 class="text-xl font-bold text-gray-800 mb-4">流浪猫信息查询</h2>

                    <div class="grid grid-cols-1 md:grid-cols-3 gap-4">
                        <div class="relative">
                    <span class="absolute inset-y-0 left-0 flex items-center pl-3">
                        <i class="fa fa-search text-gray-400"></i>
                    </span>
                            <input type="text" placeholder="搜索猫ID/名称"
                                   class="pl-10 pr-4 py-2 w-full rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary/50 focus:border-primary">
                        </div>
                    </div>

                    <div class="mt-4 flex justify-between items-center">
                        <button onclick="window.location.href='http://localhost:8080/System_war/jsp/admin/PetServlet'" class="px-4 py-2 bg-primary text-white rounded-lg hover:bg-primary/90 transition-colors">
                            <i class="fa fa-search mr-2"></i>查询
                        </button>

                        <button  onclick="window.location.href='admin-3add.jsp'" class="px-4 py-2 bg-success text-white rounded-lg hover:bg-success/90 transition-colors">
                            <i class="fa fa-plus mr-2"></i>新增记录
                        </button>
                    </div>
                </div>

                <!-- 数据展示区域 -->
                <div class="bg-white rounded-xl shadow mb-6">
                    <div class="p-6 border-b flex justify-between items-center">
                        <h3 class="font-semibold text-lg">流浪猫信息列表</h3>
                        <span class="text-sm text-gray-500">共 <strong>128</strong> 条记录</span>
                    </div>

                    <div class="overflow-x-auto">
                        <table class="min-w-full divide-y divide-gray-200">


                            <tbody class="bg-white divide-y divide-gray-200">
<%--                            <jsp:useBean id="petlist" scope="request" type="java.util.List"/>--%>
<thead class="bg-gray-50">
<tr>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">猫ID</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">名称</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">品种</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">性别</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">发现日期</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">照片</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">领养状态</th>
    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">描述</th>
    <th scope="col" class="px-6 py-3 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
</tr>
</thead>
<c:forEach items="${pets}" var="Pet">
    <tr class="hover:bg-gray-50 transition-colors">
        <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${Pet.id}$</td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">${Pet.petName}</td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${Pet.petType}</td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${Pet.sex}</td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${Pet.birthday}</td>
        <td class="px-6 py-4 whitespace-nowrap">
            <img src="${Pet.pic}" alt="猫照片" class="w-10 h-10 rounded-full object-cover">
        </td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${Pet.state}</td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${Pet.remark}</td>
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

                    <!-- 分页控件 -->
                    <div class="px-6 py-4 border-t flex items-center justify-between">
                        <div class="text-sm text-gray-700">
                            显示 <span class="font-medium">1</span> 到 <span class="font-medium">4</span> 条，共 <span class="font-medium">128</span> 条记录
                        </div>
                        <div class="flex space-x-2">
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">上一页</button>
                            <button class="px-3 py-1 border border-primary bg-primary text-white rounded-md">1</button>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">2</button>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">3</button>
                            <span class="px-3 py-1 text-gray-700">...</span>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">32</button>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">下一页</button>
                        </div>
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

