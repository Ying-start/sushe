<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍管理系统 - 管理中心</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">

    <script type="text/javascript" src="../../js/jquery-3.5.1.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>

    <style>
        /* --- 局部样式覆盖，美化界面 --- */

        /* 1. 顶部导航栏升级 */
        .container {
            background-color: #393D49 !important; /*由纯黑改为Layui经典的深空蓝灰*/
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .container .logo a {
            color: #fff;
            font-weight: bold;
        }

        /* 2. 左侧菜单美化 */
        .left-nav {
            background-color: #2F4056; /* 深色侧边栏 */
        }
        .left-nav #nav li a {
            color: rgba(255,255,255,0.7);
        }
        .left-nav #nav li a:hover, .left-nav #nav li a.active {
            color: #fff;
            background-color: #009688; /* 选中高亮 */
        }

        /* 3. 右侧主体内容区域 */
        .page-content {
            background-color: #f2f2f2; /* 浅灰底色，区分层级 */
        }

        /* 4. 欢迎页(我的桌面) 专属样式 */
        .welcome-panel {
            padding: 20px;
        }

        /* 顶部欢迎横幅 */
        .welcome-header {
            background: white;
            padding: 20px;
            border-radius: 4px;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            box-shadow: 0 1px 2px rgba(0,0,0,0.05);
        }
        .welcome-header h2 {
            font-size: 20px;
            color: #333;
        }
        .welcome-time {
            color: #888;
            margin-left: 10px;
            font-size: 14px;
        }

        /* 数据统计卡片 */
        .layui-card {
            border-radius: 4px;
            box-shadow: 0 1px 2px rgba(0,0,0,0.05);
        }
        .data-card-body {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
        }
        .data-icon {
            font-size: 40px;
            color: #009688;
        }
        .data-text h3 {
            font-size: 28px;
            font-weight: bold;
            color: #333;
        }
        .data-text p {
            color: #999;
            font-size: 12px;
        }

        /* 个人信息卡片优化 */
        .profile-card-header {
            background: linear-gradient(to right, #393D49, #2F4056);
            color: white;
            padding: 15px;
            border-radius: 4px 4px 0 0;
        }
        .profile-list p {
            padding: 12px 0;
            border-bottom: 1px solid #eee;
            color: #555;
            font-size: 14px;
        }
        .profile-list p:last-child {
            border-bottom: none;
        }
        .profile-list b {
            display: inline-block;
            width: 80px;
            color: #333;
        }

        /* 退出登录按钮文字颜色改为黑色 */
        .layui-nav-child dd a p {
            color: #000 !important;
        }
        .layui-nav-child dd a:hover p {
            color: #000 !important;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="logo"><a href="#">宿舍管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <%-- 假设有头像，如果没有用默认图标 --%>
                <img src="/images/avatar_default.png" class="layui-nav-img" onerror="this.src='//t.cn/RCzsdCq'">
                ${sessionScope.ad.a_username}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="/loginOut"><p>退出登录</p></a></dd>
            </dl>
        </li>
    </ul>
</div>
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>学生管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findStudent"><i class="iconfont">&#xe6a7;</i><cite>学生信息</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>班级管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findClass"><i class="iconfont">&#xe6a7;</i><cite>班级列表</cite></a></li>
                    <li><a _href="/findClassStudent"><i class="iconfont">&#xe6a7;</i><cite>班级学生</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#59095;</i>
                    <cite>宿舍管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findDormitory"><i class="iconfont">&#xe6a7;</i><cite>宿舍列表</cite></a></li>
                    <li><a _href="/findDormitoryStudent"><i class="iconfont">&#xe6a7;</i><cite>人员信息</cite></a></li>
                    <li><a _href="/findDormRepair"><i class="iconfont">&#xe6a7;</i><cite>维修登记</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#59042;</i>
                    <cite>卫生管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findDormClean"><i class="iconfont">&#xe6a7;</i><cite>宿舍卫生</cite></a></li>
                    <li><a _href="/findStudentClean"><i class="iconfont">&#xe6a7;</i><cite>学生卫生</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe613;</i>
                    <cite>访客管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findVisitor"><i class="iconfont">&#xe6a7;</i><cite>访客列表</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/findAdmin"><i class="iconfont">&#xe6a7;</i><cite>管理员列表</cite></a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show welcome-panel">

                <div class="welcome-header layui-anim layui-anim-fadein">
                    <div>
                        <h2>早安，${sessionScope.ad.a_name}！</h2>
                        <span class="welcome-time">今天是 <span id="currentDate"></span>，祝你工作愉快。</span>
                    </div>
                </div>

                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md3">
                        <div class="layui-card">
                            <div class="data-card-body">
                                <div class="data-text">
                                    <h3>${studentInfo.total}</h3>
                                    <p>在校学生总数</p>
                                </div>
                                <i class="iconfont data-icon">&#xe6b8;</i>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3">
                        <div class="layui-card">
                            <div class="data-card-body">
                                <div class="data-text">
                                    <h3>${dormitoryInfo.total}</h3>
                                    <p>宿舍房间数</p>
                                </div>
                                <i class="iconfont data-icon">&#xe62e;</i>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3">
                        <div class="layui-card">
                            <div class="data-card-body">
                                <div class="data-text">
                                    <h3>12</h3>
                                    <p>待处理报修</p>
                                </div>
                                <i class="iconfont data-icon" style="color:#FF5722">&#xe6b2;</i>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3">
                        <div class="layui-card">
                            <div class="data-card-body">
                                <div class="data-text">
                                    <h3>5</h3>
                                    <p>今日访客</p>
                                </div>
                                <i class="iconfont data-icon" style="color:#1E9FFF">&#xe613;</i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-row layui-col-space15" style="margin-top: 10px;">
                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="profile-card-header">
                                <i class="layui-icon">&#xe66f;</i> 当前用户信息
                            </div>
                            <div class="layui-card-body profile-list">
                                <p><b>用户名：</b> ${sessionScope.ad.a_username}</p>
                                <p><b>姓名：</b> ${sessionScope.ad.a_name}</p>
                                <p><b>联系电话：</b> ${sessionScope.ad.a_phone}</p>
                                <p><b>权限级别：</b> <span class="layui-badge layui-bg-blue">${sessionScope.ad.a_describe}</span></p>
                            </div>
                        </div>
                    </div>

                    <div class="layui-col-md6">
                        <div class="layui-card">
                            <div class="profile-card-header" style="background: linear-gradient(to right, #009688, #5FB878);">
                                <i class="layui-icon">&#xe66e;</i> 系统公告
                            </div>
                            <div class="layui-card-body" style="height: 145px; overflow: hidden;">
                                <div style="color: #666; line-height: 24px;">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="page-content-bg"></div>

<script>
    layui.config({
        base: 'layui_exts/',
    }).extend({
        excel: 'excel',
    });

    // 简单的日期显示脚本
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    document.getElementById("currentDate").innerText = year + "年" + month + "月" + day + "日";
</script>
</body>
</html>