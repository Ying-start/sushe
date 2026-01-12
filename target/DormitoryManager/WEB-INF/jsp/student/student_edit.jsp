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
    <form class="layui-form" action="/updateStudent" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.s_id}" name="s_id" id="s_id"/>
        <!-- 学号 只读 可提交 -->
        <div class="layui-form-item">
            <label for="s_studentid" class="layui-form-label">
                <span class="f_sp">学号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_studentid" name="s_studentid"
                       autocomplete="off" value="${sessionScope.s.s_studentid}" class="layui-input" readonly>
            </div>
        </div>

        <!-- 姓名 只读 可提交 -->
        <div class="layui-form-item">
            <label for="s_name" class="layui-form-label">
                <span class="f_sp">姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_name" name="s_name"
                       autocomplete="off" value="${sessionScope.s.s_name}" class="layui-input" readonly>
            </div>
        </div>

        <!-- 性别 只读 可提交（显示radio且disabled，实际提交hidden） -->
        <div class="layui-form-item">
            <label for="s_sex" class="layui-form-label">
                <span class="f_sp">性别</span>
            </label>
            <div class="layui-input-inline" id="s_sex">
                <input type="radio" name="fake_s_sex" id="s_male" value="男" title="男"
                       <c:if test="${sessionScope.s.s_sex=='男'}">checked</c:if> disabled>
                <input type="radio" name="fake_s_sex" id="s_female" value="女" title="女"
                       <c:if test="${sessionScope.s.s_sex=='女'}">checked</c:if> disabled>
                <!-- 真正提交的隐藏域 -->
                <input type="hidden" name="s_sex" value="${sessionScope.s.s_sex}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_age" class="layui-form-label">
                <span class="f_sp">年龄</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_age" name="s_age"
                       autocomplete="off" value="${sessionScope.s.s_age}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_phone" class="layui-form-label">
                <span class="f_sp">电话</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_phone" name="s_phone"
                       autocomplete="off" value="${sessionScope.s.s_phone}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">*</span>班级编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classid" name="s_classid"
                       autocomplete="off" value="${sessionScope.s.s_classid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">*</span>班级名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classname" name="s_classname"
                       autocomplete="off" value="${sessionScope.s.s_classname}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_dormitoryid" class="layui-form-label">
                <span class="">*</span>寝室编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_dormitoryid" name="s_dormitoryid"
                       autocomplete="off" value="${sessionScope.s.s_dormitoryid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>

<script>
    layui.use(['form','layer','laydate'], function(){
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;
        form.on('submit(updateForm)', function(data) {
            $.ajax({
                url: '/updateStudent',
                type: "post",
                contentType: 'application/json',
                data: JSON.stringify(data.field),
                success: function(response){
                    if(response.code == 200){
                        layer.msg('修改成功', {icon: 1, time: 2000}, function(){
                            window.location.href = '/findStudent';
                        });
                    } else {
                        // 显示后端返回的详细错误信息
                        layer.msg(response.msg || '修改失败', {icon: 2, time: 3000});
                    }
                },
                error:function(xhr){
                    // xhr.responseText 里可能有后端抛出的text信息
                    var msg = '修改失败';
                    if(xhr.responseText){
                        try {
                            var json = JSON.parse(xhr.responseText);
                            msg = json.msg || msg;
                        } catch(e){}
                    }
                    layer.msg(msg, {icon: 2, time: 3000});
                }
            });
            return false;
        });
    });

</script>
</body>
</html>
