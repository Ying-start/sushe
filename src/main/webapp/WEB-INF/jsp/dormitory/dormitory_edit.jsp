<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/11/14
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="../../js/jquery-3.5.1.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body>

<div class="x-body">
    <form class="layui-form"  id="f_auto" action="/updateDormitory" method="post" >
        <input type="hidden" value="${sessionScope.d.d_id}" name="d_id" id="d_id"/>
        <div class="layui-form-item">
            <label for="s_dormitoryid" class="layui-form-label">
                <span class="">宿舍编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_dormitoryid" name="s_dormitoryid"
                       autocomplete="off" value="${sessionScope.d.s_dormitoryid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="d_dormbuilding" class="layui-form-label">
                <span class="">宿舍楼</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_dormbuilding" name="d_dormbuilding"
                       autocomplete="off" value="${sessionScope.d.d_dormbuilding}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="d_bedtotal" class="layui-form-label">
                <span class="">床位总数</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_bedtotal" name="d_bedtotal"
                       autocomplete="off" value="${sessionScope.d.d_bedtotal}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="d_bed" class="layui-form-label">
                <span class="">已用床位</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_bed" name="d_bed"
                       autocomplete="off" value="${sessionScope.d.d_bed}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="a_name" class="layui-form-label">
                <span class="">管理员姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="a_name" name="a_name"
                       autocomplete="off" value="${sessionScope.d.a_name}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateClass">
                修改
            </button>
        </div>
    </form>
</div>

<style>
    /* 1. 容器样式：让整个区域居中显示，背景微灰（如果body不是灰的） */
    .x-body {
        display: flex;
        justify-content: center;
        align-items: flex-start;
        padding-top: 50px; /* 距离顶部一段距离 */
        min-height: 100vh;
        box-sizing: border-box;
    }

    /* 2. 表单卡片：白色背景、阴影、圆角 */
    #f_auto {
        width: 500px;
        background-color: #fff;
        padding: 40px 50px;
        border-radius: 8px;
        box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08); /* 柔和的悬浮阴影 */
    }

    /* 3. 表单行间距优化 */
    .layui-form-item {
        margin-bottom: 25px; /* 拉大间距，不再拥挤 */
        clear: both;
    }

    /* 4. 标签美化：右对齐、灰色字体 */
    .layui-form-label {
        float: left;
        display: block;
        padding: 10px 15px;
        width: 90px;
        font-weight: 500;
        color: #666;
        text-align: right;
    }

    /* 5. 输入框容器 */
    .layui-input-inline {
        float: left;
        width: 300px; /* 固定宽度，整齐划一 */
        margin-right: 0;
    }

    /* 6. 输入框本体：增高、淡灰背景、过渡动画 */
    .layui-input {
        height: 42px;
        line-height: 42px;
        border-radius: 4px;
        border: 1px solid #e6e6e6;
        background-color: #fafafa; /* 极淡的灰底 */
        transition: all 0.3s;
        padding-left: 12px;
    }

    /* 输入框聚焦效果：绿色边框+光晕 */
    .layui-input:focus {
        border-color: #009688 !important;
        background-color: #fff;
        box-shadow: 0 0 0 3px rgba(0, 150, 136, 0.1);
    }

    /* 7. 按钮区域：居中 + 上方留白 */
    #btn_xg {
        margin-top: 40px;
        text-align: center;
        padding-left: 40px; /* 微调以视觉居中(抵消label宽度带来的偏移) */
    }

    /* 8. 按钮本体：宽大、投影、悬停上浮 */
    .layui-btn {
        width: 200px; /* 宽按钮更易点击 */
        height: 45px;
        line-height: 45px;
        font-size: 16px;
        background-color: #009688;
        border-radius: 30px; /* 半圆角按钮，更现代 */
        box-shadow: 0 4px 10px rgba(0, 150, 136, 0.3);
        border: none;
        cursor: pointer;
        transition: transform 0.2s, opacity 0.2s;
    }

    .layui-btn:hover {
        opacity: 0.9;
        transform: translateY(-2px); /* 鼠标悬停上浮效果 */
    }
</style>
</body>
</html>
