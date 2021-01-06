<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/5
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../Common/head.jsp"/>
</head>

<body>
<div class="container" align="center" style="margin-top: 200px">
    <div class="row">
        <button class="btn btn-lg btn-primary"  onclick="toAdminorder()">订单管理</button>
        <button class="btn btn-lg btn-primary" onclick="toAdminbook()">图书管理</button>
    </div>
</div>
</body>
<script>
    function toAdminorder() {
        window.location="/admin/adminorder";
    }
    function toAdminbook() {
        window.location="/admin/adminbook";
    }
</script>
</html>
