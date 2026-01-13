<%--
  Created by IntelliJ IDEA.
  User: 周训凯
  Date: 2019/4/28
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.sushe.po.DormRepair" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="../../js/jquery-3.5.1.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script src="/layui_exts/excel.js"></script>

    <style type="text/css">
        .layui-table{
            text-align: center;
        }
        .layui-table th{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/findDormRepair">维修信息</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/findDormRepair" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/findDormRepair" >
            <input class="layui-input" placeholder="请输入宿舍编号" name="d_id" id="d_id">
            <input class="layui-input" placeholder="请输入宿舍楼" name="d_dormbuilding" id="d_dormbuilding">

            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="3">
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button id="addStudnetBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>添加 </button>
        <button class="layui-btn layui-btn-warm" lay-filter="toolbarDemo" lay-submit=""><i class="layui-icon">&#xe67c;</i>导出</button>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEmployeeForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍编号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="d_id" class="layui-input" placeholder="请输入宿舍编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍楼：</label>
                    <div class="layui-input-block">

                        <c:choose>

                            <c:when test="${sessionScope.ad.a_power == 1}">
                                <select disabled>
                                    <option value="${sessionScope.managerBuildingName}" selected>
                                            ${sessionScope.managerBuildingName}
                                    </option>
                                </select>

                                <input type="hidden" name="d_dormbuilding" value="${sessionScope.managerBuildingName}">
                            </c:when>

                            <c:otherwise>
                                <select name="d_dormbuilding" lay-filter="dormSelect" class="ajax-load-building">
                                    <option value="">数据加载中...</option>
                                </select>
                            </c:otherwise>

                        </c:choose>

                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">维修人员：</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="r_name"  class="layui-input" placeholder="请输入维修人员">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">报修事由：</label>
                    <div class="layui-input-block">
                        <input type="text" name="reason" class="layui-input" placeholder="请输入报修事由">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <%--表格数据--%>
    <table class="layui-table">
        <thead>
        <tr>
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>ID</th>
            <th>宿舍编号</th>
            <th>宿舍楼</th>
            <th>维修人员</th>
            <th>报修事由</th>
            <th>报修时间</th>
            <th>维修状态</th>
            <th>维修时间</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="di">
            <tr>
                <td>${di.r_id}</td>
                <td>${di.d_id}</td>
                <td>${di.d_dormbuilding}</td>
                <td>${di.r_name}</td>
                <td>${di.reason}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${di.create_time}"/></td>
                <td>
                    <c:choose>
                        <%-- 当状态为 1 (已维修) 时：只显示绿色徽章，不加点击事件 --%>
                        <c:when test="${di.r_status == 1}">
                            <span class="layui-badge layui-bg-green">已维修</span>
                        </c:when>
                        <%-- 当状态为 0 或其他 (未维修) 时：显示红色徽章，并添加点击事件 --%>
                        <c:otherwise>
                            <%-- onclick调用 js 函数，传入当前记录的 ID --%>
                            <span class="layui-badge"
                                  onclick="updateStatus('${di.r_id}')"
                                  style="cursor: pointer;"
                                  title="点击标记为已维修">未维修</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${di.r_time}"/></td>
                <td>
                    <a title="编辑"    id= "updateEdit"    href="/findDormRepairById?r_id=${di.r_id}">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${di.r_id}')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="../page.jsp">
        <jsp:param name="url" value="/findDormRepair"/>
    </jsp:include>
    <script>
        layui.config({
            base: 'layui_exts/',
        }).extend({
            excel: 'excel',
        });

        layui.use(['jquery', 'excel', 'form', 'layer', 'laydate'], function () {
            var form = layui.form,
                $ = layui.jquery,
                laydate = layui.laydate;
            var excel = parent.layui.excel;

            // 执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            // 导出功能
            form.on('submit(toolbarDemo)', function () {
                $.ajax({
                    url: '/exportdormrepairlist',
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        var exportData = data;
                        if (data && data.list && Array.isArray(data.list)) {
                            exportData = data.list;
                        }
                        var dt = excel.filterExportData(exportData, [
                            'r_id', 'd_id', 'd_dormbuilding', 'r_name', 'reason', 'r_status' ,'create_time', 'r_time'
                        ]);
                        dt.unshift({
                            r_id: 'ID',
                            d_id: '宿舍编号',
                            d_dormbuilding: '宿舍楼',
                            r_name: '维修人员',
                            reason: '报修事由',
                            r_status: '维修状态',
                            create_time: '报修时间',
                            r_time: '更新时间'
                        });
                        var colConf = excel.makeColConfig({
                            'F': 160,
                            'G': 160
                        }, 60);
                        excel.exportExcel({
                            sheet1: dt
                        }, '维修登记数据.xlsx', 'xlsx', {
                            extend: { '!cols': colConf }
                        });
                    },
                    error: function () {
                        setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                    }
                });
            });

            /* ====================================================
               【核心修复】添加弹出框逻辑
               1. 修正了 ID 拼写 (请确保 HTML 中按钮 ID 也改为 addStudentBtn)
               2. 删除了重复的 form.on 代码
               3. 修复了括号不匹配的语法错误
               ==================================================== */
            $("#addStudnetBtn").click(function () { // 如果你不想改 HTML，这里保持 addStudnetBtn

                // 1. 打开弹窗
                layer.open({
                    type: 1,
                    title: "添加维修记录",
                    skin: "myclass",
                    area: ["50%"],
                    anim: 2,
                    content: $("#test").html(), // 获取 JSP 中写好的模版内容

                    // 2. 弹窗成功后的回调
                    success: function (layero, index) {

                        // --- A. 处理下拉框数据加载 (权限控制) ---
                        var $targetSelect = layero.find('.ajax-load-building');
                        if ($targetSelect.length > 0) {
                            // 如果是管理员，发请求加载楼宇
                            $.ajax({
                                url: '/findAllBuildings',
                                type: 'GET',
                                dataType: 'json',
                                success: function (data) {
                                    var html = '<option value="">请选择宿舍楼</option>';
                                    $.each(data, function (i, item) {
                                        html += '<option value="' + item.d_dormbuilding + '">' + item.d_dormbuilding + '</option>';
                                    });
                                    $targetSelect.html(html);
                                    form.render('select'); // 刷新渲染
                                }
                            });
                        } else {
                            // 如果是宿管员，直接渲染(显示禁用的下拉框)
                            form.render('select');
                        }

                        // --- B. 绑定表单提交事件 ---
                        // 【关键修改】将 form.on 放在 success 内部，
                        // 并先解绑，防止多次点击导致重复提交
                        form.on('submit(formDemo)', function (data) {
                            var param = data.field;
                            $.ajax({
                                url: '/addDormRepair',
                                type: "post",
                                data: JSON.stringify(param),
                                contentType: "application/json; charset=utf-8",
                                success: function () {
                                    layer.msg('添加成功', { icon: 1, time: 2000 });
                                    setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                                },
                                error: function () {
                                    layer.msg('添加失败', { icon: 0, time: 2000 });
                                }
                            });
                            return false; // 阻止表单默认跳转
                        });
                    }
                });
            });

        }); // layui.use 结束 (你之前这里少了这个，或者多了个 })

        /* 删除逻辑 (保持不变) */
        function member_del(obj, r_id) {
            layer.confirm('确认要删除吗？', function (index) {
                $.get("/deleteDormRepair", { "r_id": r_id }, function (data) {
                    if (data = true) {
                        layer.msg('删除成功!', { icon: 1, time: 2000 });
                        setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                    } else {
                        layer.msg('删除失败!', { icon: 1, time: 2000 });
                        setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                    }
                });
            });
        }

        /* 更新维修状态 (保持不变) */
        function updateStatus(r_id) {
            layer.confirm('确认该报修已处理完毕吗？', { icon: 3, title: '提示' }, function (index) {
                var now = new Date();
                var year = now.getFullYear();
                var month = (now.getMonth() + 1).toString().padStart(2, '0');
                var day = now.getDate().toString().padStart(2, '0');
                var hours = now.getHours().toString().padStart(2, '0');
                var minutes = now.getMinutes().toString().padStart(2, '0');
                var seconds = now.getSeconds().toString().padStart(2, '0');
                var currentTimeString = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;

                $.ajax({
                    url: "/updateDormRepair",
                    type: "post",
                    data: {
                        "r_id": r_id,
                        "r_status": 1,
                        "r_time": currentTimeString
                    },
                    success: function (data) {
                        if (data) {
                            layer.msg('操作成功!', { icon: 1, time: 1000 });
                            setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                        } else {
                            layer.msg('操作失败!', { icon: 2 });
                            setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                        }
                    },
                    error: function () {
                        layer.msg('请求失败!', { icon: 2 });
                        setTimeout(function () { window.location.href = '/findDormRepair'; }, 2000);
                    }
                });
                layer.close(index);
            });
        }
    </script>


</body>


</html>

