<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
   这是一个通用的分页组件
   使用方法：
   <jsp:include page="../page.jsp">
       <jsp:param name="url" value="/users/findAll"/>
   </jsp:include>
--%>

<div id="pagesData" style="text-align: center; margin-top: 10px;"></div>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script>

    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage
            , layer = layui.layer;

        // 接收父页面传递过来的基础URL，例如 /users/findAll
        var baseUrl = "${param.url}";

        // 渲染分页
        laypage.render({
            elem: 'pagesData'
            , count: ${pageInfo.total} // 数据总数
            , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            , limit: ${pageInfo.pageSize} // 每页显示的条数
            , limits: [5, 10, 15] // 每页条数的选择项
            , curr: ${pageInfo.pageNum} // 当前页
            , jump: function (obj, first) {
                // 首次不执行，防止死循环
                if (!first) {
                    // 获取搜索框的值 (假设父页面都有一个 id="key" 的输入框)
                    var keyVal = $("#key").val();
                    if(keyVal == undefined) keyVal = "";

                    // 构建跳转 URL
                    // 注意：这里为了通用，搜索参数名可能需要根据实际情况调整
                    // 原代码写的是 productName，建议后端统一用 keyword，或者这里判断一下
                    var finalUrl = baseUrl + "?page=" + obj.curr + "&limit=" + obj.limit;

                    if(keyVal !== ""){
                        finalUrl += "&productName=" + keyVal; // 这里如果不同页面参数名不同，建议改为 &keyword=...
                    }

                    location.href = finalUrl;
                }
            }
        });
    });
</script>