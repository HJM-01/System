<%--
  Created by IntelliJ IDEA.
  User: Lynnlyt
  Date: 2025/6/3
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理系统</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/admin.css">

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

                <a href="admin.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg sidebar-item-active">
                    <i class="fa fa-tachometer"></i>
                    <span>数据分析</span>
                </a>

                <a href="admin-1.jsp" class=" flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-users"></i>
                    <span>账户管理</span>
                </a>

                <a href="admin-2.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
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

                <a href="admin-5.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-cog"></i>
                    <span>论坛管理</span>
                </a>

                <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-user-circle-o"></i>
                    <span>个人设置</span>
                </a>

                <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-bell-o"></i>
                    <span>通知中心</span>
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


