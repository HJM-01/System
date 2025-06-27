`<%--
  Created by IntelliJ IDEA.
  User: Lynnlyt
  Date: 2025/6/2
  Time: 23:52
  To change this template use File | Settings | File Templates.
  没啥用,不用展示
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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

                <a href="admin-1.jsp" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-cog"></i>
                    <span>用户管理</span>
                </a>

                <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">
                    <i class="fa fa-user-circle-o"></i>
                    <span>个人设置</span>
                </a>

<%--                <a href="#" class="flex items-center space-x-3 px-4 py-3 rounded-lg hover:bg-gray-100 transition-colors">--%>
<%--                    <i class="fa fa-bell-o"></i>--%>
<%--                    <span>通知中心</span>--%>
<%--                </a>--%>
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
                <!-- 页面标题 -->
                <div class="mb-6">
                    <h2 class="text-2xl font-bold text-gray-800">仪表盘概览</h2>
                    <p class="text-gray-600 mt-1">欢迎回来，管理员！这是您的系统概览。</p>
                </div>

                <!-- 统计卡片 -->
<%--                <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">--%>
<%--                    <div class="bg-white rounded-xl shadow p-6 card-hover">--%>
<%--                        <div class="flex items-center">--%>
<%--                            <div class="p-3 bg-primary/10 rounded-lg text-primary">--%>
<%--                                <i class="fa fa-users text-xl"></i>--%>
<%--                            </div>--%>
<%--                            <div class="ml-4">--%>
<%--                                <p class="text-gray-500 text-sm">网站总用户</p>--%>
<%--                                <p class="text-2xl font-bold">3</p>--%>
<%--                            </div>--%>
<%--                            <div class="ml-auto">--%>
<%--                  <span class="text-success text-sm flex items-center">--%>
<%--                    <i class="fa fa-arrow-up mr-1"></i> 12.5%--%>
<%--                  </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="bg-white rounded-xl shadow p-6 card-hover">--%>
<%--                        <div class="flex items-center">--%>
<%--                            <div class="p-3 bg-secondary/10 rounded-lg text-secondary">--%>
<%--                                <i class="--%>
<%--                                fa fa-heart-o text-xl"></i>--%>
<%--                            </div>--%>
<%--                            <div class="ml-4">--%>
<%--                                <p class="text-gray-500 text-sm">流浪猫总数（已发现）</p>--%>
<%--                                <p class="text-2xl font-bold">30</p>--%>
<%--                            </div>--%>
<%--                            <div class="ml-auto">--%>
<%--                  <span class="text-success text-sm flex items-center">--%>
<%--                    <i class="fa fa-arrow-up mr-1"></i> 8.3%--%>
<%--                  </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="bg-white rounded-xl shadow p-6 card-hover">--%>
<%--                        <div class="flex items-center">--%>
<%--                            <div class="p-3 bg-success/10 rounded-lg text-success">--%>
<%--                                <i class="fa fa-credit-card text-xl"></i>--%>
<%--                            </div>--%>
<%--                            <div class="ml-4">--%>
<%--                                <p class="text-gray-500 text-sm">？？</p>--%>
<%--                                <p class="text-2xl font-bold">？？</p>--%>
<%--                            </div>--%>
<%--                            <div class="ml-auto">--%>
<%--                  <span class="text-success text-sm flex items-center">--%>
<%--                    <i class="fa fa-arrow-up mr-1"></i> 15.2%--%>
<%--                  </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="bg-white rounded-xl shadow p-6 card-hover">--%>
<%--                        <div class="flex items-center">--%>
<%--                            <div class="p-3 bg-warning/10 rounded-lg text-warning">--%>
<%--                                <i class="fa fa-cubes text-xl"></i>--%>
<%--                            </div>--%>
<%--                            <div class="ml-4">--%>
<%--                                <p class="text-gray-500 text-sm">猫粮库存</p>--%>
<%--                                <p class="text-2xl font-bold">468</p>--%>
<%--                            </div>--%>
<%--                            <div class="ml-auto">--%>
<%--                  <span class="text-danger text-sm flex items-center">--%>
<%--                    <i class="fa fa-arrow-down mr-1"></i> 3.1%--%>
<%--                  </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <!-- 图表区域 -->
                <div class="grid grid-cols-1 lg:grid-cols-3 gap-6 mb-8">
                    <div class="bg-white rounded-xl shadow p-6 lg:col-span-2">
                        <div class="flex items-center justify-between mb-6">
                            <h3 class="font-semibold text-lg">领养状态</h3>
                            <div class="flex space-x-2">
                                <button class="px-3 py-1 text-xs rounded-full bg-primary/10 text-primary">周</button>
                                <button class="px-3 py-1 text-xs rounded-full bg-gray-100 text-gray-600 hover:bg-primary/10 hover:text-primary transition-colors">月</button>
                                <button class="px-3 py-1 text-xs rounded-full bg-gray-100 text-gray-600 hover:bg-primary/10 hover:text-primary transition-colors">年</button>
                            </div>
                        </div>
                        <div class="h-64">
                            <!-- 图表将在这里显示 -->
                            <div class="flex items-center justify-center h-full text-gray-400">
                                <i class="fa fa-bar-chart text-5xl"></i>
                            </div>
                        </div>
                    </div>

                    <div class="bg-white rounded-xl shadow p-6">
                        <div class="flex items-center justify-between mb-6">
                            <h3 class="font-semibold text-lg">领养情况</h3>
                            <button class="text-gray-400 hover:text-gray-600">
                                <i class="fa fa-ellipsis-v"></i>
                            </button>
                        </div>
                        <div class="h-64">
                            <!-- 图表将在这里显示 -->
                            <div class="flex items-center justify-center h-full text-gray-400">
                                <i class="fa fa-pie-chart text-5xl"></i>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="bg-white rounded-xl shadow mb-8">
                    <div class="p-6 border-b">
                        <div class="flex items-center justify-between">
                            <h3 class="font-semibold text-lg">流浪猫近况（绝育/未绝育/待绝育/死亡/生病）</h3>
                            <button class="text-primary hover:text-primary/80 text-sm font-medium">查看全部</button>
                        </div>
                    </div>

                    <div class="overflow-x-auto">
                        <table class="min-w-full divide-y divide-gray-200">
                            <thead class="bg-gray-50">
                            <tr>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">流浪猫ID</th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">流浪猫名字</th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">发现日期</th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">健康状况</th>
                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">绝育状态</th>
                                <th scope="col" class="px-6 py-3 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">操作</th>
                            </tr>
                            </thead>
                            <tbody class="bg-white divide-y divide-gray-200">
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">#ORD-12345</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="flex items-center">
                                        <div class="flex-shrink-0 h-10 w-10">
                                            <img class="h-10 w-10 rounded-full object-cover" src="https://picsum.photos/id/1001/200/200" alt="用户头像">
                                        </div>
                                        <div class="ml-4">
                                            <div class="text-sm font-medium text-gray-900">糊糊</div>
                                            <div class="text-sm text-gray-500">zhangsan@example.com</div>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">2023-06-01</td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">健康</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">已完成</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                </td>
                            </tr>
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">#ORD-12346</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="flex items-center">
                                        <div class="flex-shrink-0 h-10 w-10">
                                            <img class="h-10 w-10 rounded-full object-cover" src="https://picsum.photos/id/1002/200/200" alt="用户头像">
                                        </div>
                                        <div class="ml-4">
                                            <div class="text-sm font-medium text-gray-900">垃圾桶</div>
                                            <div class="text-sm text-gray-500">lisi@example.com</div>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">2023-06-01</td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">健康</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-blue-100 text-blue-800">已发绝育</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                    <a href="#" class="text-primary hover:text-primary/80">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">#ORD-12347</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="flex items-center">
                                        <div class="flex-shrink-0 h-10 w-10">
                                            <img class="h-10 w-10 rounded-full object-cover" src="https://picsum.photos/id/1003/200/200" alt="用户头像">
                                        </div>
                                        <div class="ml-4">
                                            <div class="text-sm font-medium text-gray-900">7v</div>
                                            <div class="text-sm text-gray-500">wangwu@example.com</div>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">2023-05-31</td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">健康</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-yellow-100 text-yellow-800">处理中</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                    <a href="#" class="text-primary hover:text-primary/80">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">#ORD-12348</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="flex items-center">
                                        <div class="flex-shrink-0 h-10 w-10">
                                            <img class="h-10 w-10 rounded-full object-cover" src="https://picsum.photos/id/1004/200/200" alt="用户头像">
                                        </div>
                                        <div class="ml-4">
                                            <div class="text-sm font-medium text-gray-900">玛吉</div>
                                            <div class="text-sm text-gray-500">zhaoliu@example.com</div>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">2023-05-30</td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">健康</td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-red-100 text-red-800">已取消</span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                    <a href="#" class="text-primary hover:text-primary/80">查看</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="px-6 py-4 border-t flex items-center justify-between">
                        <div class="text-sm text-gray-700">
                            显示 <span class="font-medium">1</span> 到 <span class="font-medium">4</span> 条，共 <span class="font-medium">24</span> 条记录
                        </div>
                        <div class="flex space-x-2">
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">上一页</button>
                            <button class="px-3 py-1 border border-primary bg-primary text-white rounded-md">1</button>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">2</button>
                            <button class="px-3 py-1 border border-gray-300 rounded-md text-gray-700 bg-white hover:bg-gray-50">3</button>
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

