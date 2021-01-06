<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/5
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
<%--    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>--%>
    <style>
        #operation{
            margin-left: -20px;
        }
    </style>
</head>
<body>
<div style="width: 80%;text-align: center;margin-left: 10%">
    <center>
        <table class="table cell-span-tree-table-view" style="text-align: center">
            <caption style="text-align: center"><h3>书籍管理</h3></caption>
            <thead>
            <tr >
                <th>图书编号</th>
                <th>书名</th>
                <th>价格</th>
                <th>类别</th>
                <th>作者</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach  items="${requestScope.book.list}" var="b">
                <tr>
                    <td>${b.b_id}</td>
                    <td>${b.b_name}</td>
                    <td>${b.b_price}</td>
                    <td>${b.f_name}</td>
                    <td>${b.b_author}</td>
                    <td>${b.b_sales}</td>
                    <td>${b.b_stock}</td>
                    <td>
                        <div id="operation" class="btn-group">
                            <button type="button" class="btn btn-default" onclick="update(${b.b_id})">更新</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tr style="text-align: center">
                <td colspan="8">
                    <div class="btn-group btn-group-lg">
                        <button type="button" class="btn btn-default" onclick="add()">添加</button>
                    </div>
                </td>
            </tr>
        </table>
    </center>
</div>


<%@ include file="/WEB-INF/pages/Common/admin_book_page.jsp"%>

<script>
    function update(b_id) {
        window.location="/admin/updatebook?action=update&b_id="+b_id;
    }

    function add(){
        window.location="/admin/updatebook?action=add";
    }
</script>

</body>
</html>
