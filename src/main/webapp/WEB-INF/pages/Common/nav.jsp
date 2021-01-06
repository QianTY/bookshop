<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/25
  Time: 9:28 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../../css/nav.css">
    </head>
    <body>
        <header>
            <a href="#" class="logo">图书商城</a>
            <ul>
                <li><a href="#">登录</a></li>
                <li><a href="#">注册</a></li>
                <li><a href="#">首页</a></li>
                <li><a href="#">我的收藏</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </header>
        <script type="text/javascript">
            window.addEventListener("scroll",function(){
                var header = document.querySelector("header");
                header.classList.toggle("sticky",window.scrollY > 0);
            })
        </script>
    </body>
</html>


<%--    布局 - login - begin--%>
<%--<div class="container-fluid">--%>
<%--    <div class="row">--%>
<%--        <nav class="navbar navbar-inverse" role="navigation">--%>
<%--            <div class="container-fluid">--%>
<%--                <div class="navbar-header">--%>
<%--                    <a class="navbar-brand" >图书商城</a>--%>
<%--                </div>--%>
<%--                <div class="collapse navbar-collapse" id="example-navbar-collapse">--%>
<%--                    <ul class="nav navbar-nav navbar-right">--%>

<%--                        <li class="active"><a href="#">登录</a></li>--%>
<%--                        <li><a href="#">首页</a></li>--%>
<%--                        <li><a href="#">注册</a></li>--%>

<%--                        <c:if test="${user!=null}">--%>
<%--                            <li><a href="#">${user.username}</a></li>--%>
<%--                            <li><a href="#">安全退出</a></li>--%>
<%--                            <li><a href="#">我的收藏</a></li>--%>
<%--                        </c:if>--%>

<%--                    </ul>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </nav>--%>
<%--    </div>--%>
<%--</div>--%>

