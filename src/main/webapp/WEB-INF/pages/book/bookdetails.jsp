<%--
  Created by IntelliJ IDEA.
  User: XF
  Date: 2020/12/31
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
</head>
<body>

<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>
<section>
    <center>
        <div class="container-fluid text-center" style="width: 500px;height: 500px">
            <div class="row-fluid">
                <div id="thumbnail" class="col-md-12 left-button">
                    <img style="height: 300px;width: 300px;margin-top: 100px" src="${requestScope.bookDetail.img_path}"
                         class="pdtimg"
                         alt="通用的占位符缩略图">
                    <div id="P_detail">
                        <p>
                            <span>书名：</span>
                            <a class="text-info">${requestScope.bookDetail.b_name}</a>
                        </p>
                        <p>
                            <span>价格：</span>
                            <a class="text-info">${requestScope.bookDetail.b_price}</a>
                        </p>
                        <p>
                            <span>作者：</span>
                            <a class="text-info">${requestScope.bookDetail.b_author}</>
                        </p>
                        <p>
                            <span>库存：</span>
                            <a class="text-info">${requestScope.bookDetail.b_stock}</a>
                        </p>
                        <p>
                            <span>销量：</span>
                            <a class="text-info">${requestScope.bookDetail.b_sales}</a>
                        </p>

                        <div id="P_function">
                            <p>
                                <button class="btn btn-success" onclick="addFavourite(${requestScope.bookDetail.b_id})">加入收藏</button>
                                <button class="btn btn-warning" onclick="addCart(${requestScope.bookDetail.b_id})">加入购物车</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </center>
</section>

<script>
    function addFavourite(b_id) {
        $.post("/favourite/add",{b_id:b_id},function (data) {
            alert(data.msg);
        })
    }

    function addCart(b_id) {
        $.post("/cart/addItem",{b_id:b_id},function (data) {
            alert(data.msg);
        })

    }
</script>

<%--<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>--%>
<%--     <div class="col-md-8">--%>
<%--            <form class="form-horizontal" role="form" action="/mvc/product/update" method="post">--%>
<%--                <input type="hidden" value="${product.id}" name="id">--%>
<%--                <div class="form-group">--%>
<%--                    <label for="firstname" class="col-sm-2 control-label">产品图</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <img id="my_img" src="/mvc/imgs/${product.imgUrl}" style="width: 150px;height: 150px">--%>
<%--                        <input id="myUrl" name="imgUrl" type="hidden" value="${product.imgUrl}">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="firstname" class="col-sm-2 control-label">产品名称</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <input type="text" name="name" value="${product.name}" class="form-control" id="firstname">--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label for="firstname" class="col-sm-2 control-label">产品描述</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <textarea name="remark" class="form-control">${product.remark}</textarea>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label for="lastname" class="col-sm-2 control-label">产品价格</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <input type="text" name="price" value="${product.price}" class="form-control" id="lastname" >--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <label for="lastname" class="col-sm-2 control-label">产品类型</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <form role="form">--%>
<%--                            &lt;%&ndash;                                <div class="form-group">&ndash;%&gt;--%>
<%--                            <select name="typeId" class="form-control">--%>
<%--                                <option value="-1">===请您选择产品类型===</option>--%>
<%--                                <c:forEach items="${types}" var="t">--%>
<%--                                    <option <c:if test="${product.typeId == t.id}">selected</c:if> value="${t.id}">${t.name}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                            &lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </form>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
