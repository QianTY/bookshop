<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/28
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
<%--    <link href="/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="/css/nav.css" rel="stylesheet" type="text/css">--%>
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
</head>
<body>
<%--<script src="/plugins/jquery/jquery.min.js"></script>--%>
<%--<script src="/plugins/bootstrap/js/bootstrap.js"></script>--%>

<%--    顶部导航栏--%>
<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel-heading">
    <h3>订单详情</h3>
    <button onclick="ret()" class="btn btn-success"><i class="glyphicon glyphicon-menu-left">返回我的订单</i></button>
</div>

<p></p>
<div class="container-fluid">
    <div class="row">
<%--        <c:forEach items="${product.list}" var="p">--%>
        <c:forEach items="${item}" var="item">
            <div class="col-xs-12 col-md-3">
                <div class="thumbnail">
                    <img src="${item.imgs}"
                         style="width: 50%;"
                         alt="通用的占位符缩略图">
                    <div class="caption">
                        <h3>${item.b_name}</h3>
                        <p class="text-primary">价格:${item.price}</p>
                        <p class="text-primary">数量:${item.count}</p>
                        <p class="text-danger">总价:${item.total_price}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
<%--            <div class="col-xs-12 col-md-3">--%>
<%--                <div class="thumbnail">--%>
<%--                    <img src="/imgs/8001.jpg"--%>
<%--                         style="width: 50%;"--%>
<%--                         alt="通用的占位符缩略图">--%>
<%--                    <div class="caption">--%>
<%--                        <h3>图书名</h3>--%>
<%--                        <p class="text-primary">价格:100</p>--%>
<%--                        <p class="text-primary">数量:100</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--        </c:forEach>--%>
    </div>
</div>
</body>
</html>
