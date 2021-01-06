<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2021/1/4
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
    <style>
        .ShaShiDi{
            width:100px;
            height:150px;
            display:flex;
            align-items:center;
            justify-content:center;
            /*border:1px solid #000000;*/
        }

        .ShaShiDi img{
            width:100%;
            height:auto;
        }

    </style>
</head>
<body>

<div>
    <c:forEach  items="${bookinfo}" var="b">
        <div style="width:400px;height: 220px;margin-top: 40px; margin-left: 250px" id="div${b.b_id}">
<%--            隐藏域--%>
            <input type="hidden" value="div${b.b_id}" id="div_hidden">
            <div class="ShaShiDi" style="float: left">
                <img src="${b.img_path}"/>
            </div>
            <div style="margin-left: 150px">
                <p style="font-size: 30px" >${b.b_name}</p>
                <p style="font-size:25px">${b.f_name}类</p>
                <p style="font-size: 20px">价格:${b.b_price}/元</p>
                <p style="font-size: 15px">${b.b_author} 著</p>
                <p style="font-size: 10px;display: inline-table">已售:${b.b_sales}/件</p>
                <p style="font-size: 3px;display: inline-table">库存:${b.b_stock}/件</p>
                <input type="button" class="btn-sm" value="删除" style="margin-left: 200px" onclick="deleted(${b.b_id})">
            </div>
        </div>
    </c:forEach>
    <P></P>
</div>

</body>
</html>
