<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍管理系统 - 登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <%-- 引入 Layui 样式(借用一下，方便统一) --%>
    <link rel="stylesheet" href="/lib/layui/css/layui.css">
    <script src="../../js/jquery-3.5.1.min.js"></script>
    <script src="/lib/layui/layui.js"></script>

    <style>
        /* 覆盖默认样式，创建现代感背景 */
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            font-family: 'Roboto', sans-serif;
        }

        /* 登录卡片容器 */
        .login-container {
            width: 400px;
            padding: 40px;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 10px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        .login-header h2 {
            margin-bottom: 30px;
            color: #333;
            font-weight: 600;
            font-size: 24px;
        }

        /* 输入框美化 */
        .input-group {
            position: relative;
            margin-bottom: 25px;
        }

        .input-group input {
            width: 100%;
            padding: 12px 15px;
            padding-left: 40px; /* 留出图标位置 */
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            outline: none;
            transition: all 0.3s;
        }

        .input-group input:focus {
            border-color: #764ba2;
            box-shadow: 0 0 5px rgba(118, 75, 162, 0.2);
        }

        /* 图标模拟 (使用 Unicode 或 Layui icon) */
        .input-icon {
            position: absolute;
            left: 12px;
            top: 50%;
            transform: translateY(-50%);
            color: #999;
            font-size: 18px;
        }

        /* 按钮美化 */
        .submit-btn {
            width: 100%;
            padding: 12px;
            background: linear-gradient(to right, #667eea, #764ba2);
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: transform 0.2s;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(118, 75, 162, 0.4);
        }

        .error-msg {
            color: #ff4d4f;
            font-size: 14px;
            margin-bottom: 15px;
            display: block;
            height: 20px;
        }

        .footer {
            margin-top: 20px;
            color: #999;
            font-size: 12px;
        }
    </style>
</head>
<body>

<div class="login-container">
    <div class="login-header">
        <h2>宿舍管理系统后台</h2>
    </div>

    <form action="/login" method="post">
        <span class="error-msg">${msg}</span>

        <div class="input-group">
            <i class="layui-icon layui-icon-username input-icon"></i>
            <input type="text" name="a_username" placeholder="请输入管理员账号" required autocomplete="off"/>
        </div>

        <div class="input-group">
            <i class="layui-icon layui-icon-password input-icon"></i>
            <input type="password" name="a_password" placeholder="请输入密码" required />
        </div>

        <button type="submit" class="submit-btn">立即登录</button>
    </form>

    <div class="footer">
        <span>&copy; 2026 宿舍管理系统 | Design by Kim</span>
    </div>
</div>

<script>
    // 简单的抖动效果，如果msg有内容
    $(function(){
        var msg = "${msg}";
        if(msg && msg.trim() !== ""){
            $('.login-container').addClass('layui-anim layui-anim-shake');
        }
    });
</script>
</body>
</html>