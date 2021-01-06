<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/5
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <jsp:include page="../Common/head.jsp"/>
</head>
<body>

<div class="container" align="center" style="margin-top: 80px">
    <div class="row">
        <h3>订单管理</h3>
    </div>
</div>
<div id="other">

</div>


</body>
<script>
    $(function () {
        $("#other").load("/admin/item");
    })
</script>
</html>
