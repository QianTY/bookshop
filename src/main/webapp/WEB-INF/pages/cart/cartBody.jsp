<%--
  Created by IntelliJ IDEA.
  User: QTY
  Date: 2021/1/6
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"></jsp:include>
</head>
<body>
<table id="tableText" class="table cell-span-tree-table-view" style="text-align: center">
    <caption style="text-align: center">
        <h3>
            <c:if test="${empty sessionScope.countItem}">
                您的购物车中共有0件商品总价为:￥${sessionScope.total_price}
            </c:if>
            <c:if test="${not empty sessionScope.countItem}">
                您的购物车中共有${sessionScope.countItem}件商品总价为:${sessionScope.total_price}
            </c:if>
        </h3>
    </caption>
    <thead>
    <tr>
        <th></th>
        <th>序号</th>
        <th>图书编号</th>
        <th>书本图片</th>
        <th>书名</th>
        <th>价格</th>
        <th>数量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <c:if test="${not empty sessionScope.countItem}">
            <c:forEach items="${sessionScope.cartItems.list}" varStatus="i" var="item">
                <tr class="" style="background: white" id="tr${item.b_id}">
                    <input type="hidden" value="${item.b_id}" id="del_item"/>
                    <th><input type="checkbox" name="cks" value="${item.b_id}"></th>
                    <th><span>${i.index+1}</span></th>
                    <th><span>${item.b_id}</span></th>
                    <th><img class="bkimg" src="${item.imgs}"/></th>
                    <th>${item.b_name}</th>
                    <th>¥${item.price}</th>
                    <th class="col-md-2">
                            <%--                    ${item.num}--%>
                        <input style="width: 30%" type="number" min="0" onchange="changeNum(${item.b_id})" class="input-num" id="input_num"
                               value="${item.num}"/>
                    </th>
                    <th>
                            <%--                            <button class="btn " style="color: red" id="btn_del" >删除</button>--%>
                        <button class="btn " style="color: red" id="btn_del" onclick="del_cartItem(${item.b_id})">
                            删除
                        </button>
                    </th>

                </tr>
            </c:forEach>

            <td colspan="7" class="text-right">
                    <%--         <jsp:include page="/WEB-INF/pages/Common/page.jsp"></jsp:include>--%>
            </td>
            <td><input type="button" onclick="checkout()" value="结算"></td>
        </c:if>

    </tbody>

    <c:if test="${empty sessionScope.countItem}">
        <td colspan="8" class="text-center">
            <a href="/index">您的购物车中尚且没有商品,请前往添加!</a>
        </td>
    </c:if>

<%--    <td colspan="7" class="text-right">--%>
<%--        <jsp:include page="/WEB-INF/pages/Common/page.jsp"></jsp:include>&ndash;%&gt;--%>
<%--    </td>--%>
<%--    <td><input type="button" class="btn btn-success" onclick="checkout()" value="结算"></td>--%>

</table>
</body>
</html>
