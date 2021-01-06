<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/5
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 80%;text-align: center;margin-left: 10%">
    <center>
        <table class="table cell-span-tree-table-view" style="text-align: center">
            <thead>
            <tr >
                <th>订单编号</th>
                <th>创建日期</th>
                <th>总价</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.order.list}" var="o">
                <tr>
                    <input type="hidden" value="${o.o_id}" id="oid_hidden">
                    <td>${o.o_id}</td>
                    <td><fmt:formatDate value="${o.o_time}" pattern='yyyy-MM-dd'/></td>
                    <td>${o.o_price}</td>
                    <td>
                        <c:if test="${o.is_receipt==0}">
                            未发货
                        </c:if>
                    </td>

                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-success" onclick="fahuo(${o.o_id})">发货</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </center>
</div>
<%@ include file="/WEB-INF/pages/Common/admin_order_page.jsp"%>
<input type="hidden" value="${sessionScope.admin_order_pageNum}" id="pageNum_hidden">
<script>
    function fahuo(o_id) {
        var pageNum=$("#pageNum_hidden").val();
        //alert(o_id);
        $.post("/admin/fahuo",{o_id:o_id},function (result) {
            console.log(result);
            $("#other").load("/admin/item",{pageNum:pageNum});
        })
    }
</script>
</body>
</html>
