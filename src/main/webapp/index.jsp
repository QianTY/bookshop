<%--
  Created by IntelliJ IDEA.
  User: QTY
  Date: 2020/12/25
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
<html>
<head>
    <title>首页</title>
    <jsp:include page="WEB-INF/pages/Common/head.jsp"/>
</head>
<body>

<jsp:include page="WEB-INF/pages/Common/left.jsp"/>

<section class="tsection">

    <jsp:include page="WEB-INF/pages/Common/left-better.jsp"/>

    <jsp:include page="WEB-INF/pages/Common/search.jsp"/>

    <div class="container-fluid col-md-10 col-md-offset-1">
        <div class="row">
            <c:forEach items="${requestScope.books.list}" var="item">
                <div class="col-xs-12 col-md-2" >

                    <div class="thumbnail" >
                        <div onclick='showDetail(${item.b_id})'>
                            <img class="img-thumbnail" style="width: 95%;height: 225px" src="${item.img_path}"
                                 alt="通用的占位符缩略图">
                            <div class="caption">
                                <h4 class="text-info"
                                    style="overflow: hidden;/*超出部分隐藏*/white-space: nowrap;/*不换行*/text-overflow:ellipsis;/*超出部分省略号显示*/">${item.b_name}</h4>
                                <p class="text-success">价格:${item.b_price}</p>
                            </div>
                        </div>

                        <div style="text-align: right" class="text-danger">

                            <c:if test="${empty sessionScope.myFavourite}">
                                <span onclick="collect(${item.b_id},this)"
                                      class="glyphicon glyphicon-heart-empty"></span>
                            </c:if>

                                <%--                            如果不为空 - 有用户登录--%>
                            <c:if test="${!empty sessionScope.myFavourite}">
                                <%--                                判断当前登录的用户的所有的收藏的商品 - 2,3,4,5--%>
                                <c:set var="flag" value="true"></c:set>

                                <c:forEach items="${sessionScope.myFavourite}" var="c">
                                    <c:if test="${c.b_id == item.b_id}">
                                        <span onclick="collect(${item.b_id},this)"
                                              class="glyphicon glyphicon-heart"></span>
                                        <c:set var="flag" value="false"></c:set>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${flag}">
                                    <span onclick="collect(${item.b_id},this)"
                                          class="glyphicon glyphicon-heart-empty" style="z-index: 888888"></span>
                                </c:if>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <input type="hidden" id="user_hidden" value="${sessionScope.user}">
        </div>
    </div>

    <jsp:include page="WEB-INF/pages/Common/page.jsp"/>

    </div>

    </section>
</section>

<script type="text/javascript">
    window.addEventListener("scroll",function(){
        var header = document.querySelector("header.topheader");
        header.classList.toggle("sticky",window.scrollY > 0);
    })
    window.addEventListener("scroll",function(){
        var section = document.querySelector("section.tsection");
        section.classList.toggle("stisection",window.scrollY > 0);
    })
</script>

<script>
    function showDetail(b_id) {
        console.log(b_id);
        window.location = "/book/details?b_id=" + b_id;
    };


    function seach() {
        let name = document.getElementById("name_input").value;
        console.log(name);
        window.location = "/book/search?b_name=" + name;
    };


    //收藏的功能
    function collect(b_id, obj) {
        //判断是否为登录之后的操作
        let user = $("#user_hidden").val();

        if (user == "" || user == null) {
            window.location = "/user/login";
        } else {
            //将当前收藏的产品的id发送到后台...  ajax - 不刷新...
            $.post("/favourite/index", {b_id: b_id}, function (data) {

                if (obj.className == "glyphicon glyphicon-heart") {
                    obj.className = "glyphicon glyphicon-heart-empty";
                } else {
                    obj.className = "glyphicon glyphicon-heart";
                }
                alert(data.msg);

            })
        }
    }

</script>

</body>
</html>
