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

        // 接收父页面传递过来的基础URL
        var baseUrl = "${param.url}";

        laypage.render({
            elem: 'pagesData'
            , count: ${pageInfo.total}      // 数据总数
            , limit: ${pageInfo.pageSize}   // 每页显示的条数
            , limits: [ 3, 5, 10, 15]        // 条数选择
            , curr: ${pageInfo.pageNum}     // 当前页
            , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            , jump: function (obj, first) {
                // 首次不执行，防止死循环
                if (!first) {

                    // 1. 获取当前浏览器地址栏的参数
                    var currentSearch = window.location.search;
                    var params = {};

                    // 2. 解析参数字符串
                    if (currentSearch.indexOf("?") !== -1) {
                        var str = currentSearch.substring(1);
                        var strs = str.split("&");
                        for (var i = 0; i < strs.length; i++) {
                            var pair = strs[i].split("=");
                            // 排除旧的分页参数，防止参数堆积 (同时排除 page/limit 和 pageIndex/pageSize)
                            if (pair[0] !== "page" && pair[0] !== "limit" &&
                                pair[0] !== "pageIndex" && pair[0] !== "pageSize") {
                                if(pair.length > 1){
                                    // 【修正点1】 正确的赋值方式：key 在方括号里，value 在等号右边
                                    params[pair[0]] = pair[1];
                                }
                            }
                        }
                    }

                    // 3. 设置新的分页参数
                    // 【修正点2】 参数名修改为 pageIndex 和 pageSize，以匹配你的后端 Controller
                    params["page"] = obj.curr;
                    params["limit"] = obj.limit;

                    // 4. 重新拼接成 URL 字符串
                    var queryString = "";
                    for (var key in params) {
                        queryString += "&" + key + "=" + params[key];
                    }

                    // 将第一个 '&' 替换为 '?'
                    if (queryString.length > 0) {
                        queryString = "?" + queryString.substring(1);
                    }

                    // 5. 跳转
                    window.location.href = baseUrl + queryString;
                }
            }
        });
    });
</script>