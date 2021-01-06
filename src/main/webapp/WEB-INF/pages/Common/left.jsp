<%--
  Created by IntelliJ IDEA.
  User: QTY
  Date: 2020/12/26
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="topheader">
    <a href="/index" class="logo">图书商城</a>
    <ul>
     <c:if test="${user==null}">
        <li><a href="/user/login">登录</a></li>
     </c:if>
        <li><a href="/index">首页</a></li>
       <c:if test="${user!=null}">
           <li><a>亲爱的${user.u_name}</a></li>
        <li><a href="/favourite/fav">我的收藏</a></li>
        <li><a href="/order/index">我的订单</a></li>
        <li><a href="/cart/index" target="_blank">购物车</a></li>
        <li><a href="/user/login">退出</a></li>
       </c:if>
    </ul>
</header>


