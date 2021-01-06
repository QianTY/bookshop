<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/27
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>我的订单</title>
<%--    <link href="/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="/css/nav.css" rel="stylesheet" type="text/css">--%>
    <%@ include file="/WEB-INF/pages/Common/head.jsp"%>
</head>

<style type="text/css">
    /******************* 导航栏样式 ***********************/
    #my_header .nav_show{
        background-color: #418BE8;
        margin-bottom: 0;
    }
    #my_header a{
        color: #fff;
        font-size:18px;
    }

    /******************* 字体图标 ***********************/
    @font-face {
        font-family: hjx;
        src: url('../fonts/icomoon.svg') format('embedded-opentype'),
        url('../fonts/icomoon.svg') format('svg'),
        url('../fonts/icomoon.ttf') format('truetype'),
        url('../fonts/icomoon.woff') format('woff');
    }
    [class^="icon-"], /*模糊匹配开头为icon的*/
    [class^=" icon-"]{  /*模糊匹配中间为icon的*/
        font-family: hjx;
        font-style: normal;
        font-size: 15px;
    }
    .icon-sel::before{
        content: '\e986';
    }
    .icon-del::before{
        content: '\ea0f';
        font-size: 15px;
    }

    /******************* 表格的样式 ***********************/
    #my_body .show_table{
        margin-left: 0.5%;
        margin-bottom:1px;
        width: 99%;
        border: 1px solid #e0e0e0;

    }
    #my_body .show_table tr:first-child th:first-child {
        border-top-left-radius: 2px;
    }
    #my_body .show_table th{
        text-align: center;
        color: #49656C;
    }
    /******************* 面板尾部样式 ***********************/
    .show_foot{
        height: 55px;
    }
    .show_foot p{
        font-size: 15px;
        line-height: 30px;
        margin:0 5px;
    }
    .show_foot ul{
        margin: 0;
    }
</style>


<body>


<%--头部导航栏--%>
<%@ include file="/WEB-INF/pages/Common/left.jsp"%>

<%--<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>--%>
<%--<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>--%>

<!--面板-->

<section>
    <div id="my_body" class="panel panel-default col-md-10 text-center col-md-offset-1" style="margin-top: 80px">
        <!-- 搜索栏 -->
        <div class="panel-heading">
            <div class="row">
                我的订单
            </div>
        </div>
        <div class="panel-body">
            <form class="form-inline">
                <div class="form-group">
                    <c:if test="${empty order_id}">
                        <input type="text" class="form-control" name="o_id" id="oid" placeholder="请输入订单编号">
                    </c:if>
                    <c:if test="${not empty order_id}">
                        <input type="text" class="form-control" name="o_id" id="oid" value="${order_id}">
                    </c:if>
                </div>
                <button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-search"></i>查询</button>
            </form>
        </div>
        <!-- 订单表 -->
        <table class="table table-striped table-bordered text-center show_table" id="table">
            <tr style="background-color: #CAE8EA;">
                <th>订单编号</th>
                <th>创建日期</th>
                <th>总价</th>
                <th>状态</th>
                <th>发货时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.orders.list}" var="o">
                <tr id="tr${o.o_id}">
                    <input type="hidden" value="${o.o_id}" id="oid_hidden">
                    <td>${o.o_id}</td>
                    <td><fmt:formatDate value="${o.o_time}" pattern='yyyy-MM-dd'/></td>
                    <td>${o.o_price}</td>
                    <td>
                        <c:if test="${o.is_receipt==0}">
                            未发货
                        </c:if>
                        <c:if test="${o.is_receipt==1}">
                            已发货
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${empty o.receipt_time}">
                            ------
                        </c:if>
                        <c:if test="${not empty o.receipt_time}">
                            <fmt:formatDate value="${o.receipt_time}" pattern='yyyy-MM-dd'/>
                        </c:if>
                    </td>
                    <td>
                        <a href="/order/item?o_id=${o.o_id}" class="btn btn-success"><i class="glyphicon glyphicon-th"></i>详情</a>
                        <button type="button" id="del${o.o_id}" onclick="del()" class="btn btn-danger" value="${o.o_id}"><i class="glyphicon glyphicon-remove-circle"></i>删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <input type="hidden" value="${user.u_id}" id="id_hidden">
        <input type="hidden" value="${sessionScope.orders.pageNum}" id="pageNum_hidden">
        <!--尾部栏-->
        <%--        <jsp:include page="/WEB-INF/pages/Common/orderpage.jsp"/>--%>
        <%@ include file="/WEB-INF/pages/Common/orderpage.jsp"%>
</section>
<script src="/plugins/jquery/jquery.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.js"></script>
</body>
<script>

    function load(url, data){
        //alert($(url).attr("href"));
        $.ajaxSetup({cache: false });
        $("#content").load($(url).attr("href")+ " #content ", data, function(result){
            //alert(result);
            //将被加载页的JavaScript加载到本页执行
            $result = $(result);
            $result.find("script").appendTo('#content');
        });

    }

    function searchs() {
        var oid=$('#oid').val();
        var uid = $('#id_hidden').val();
        var num = $("#nub").val();
        console.log(oid);
        window.location="/order/index?pageNum="+num+"&o_id="+oid;
    }

    function inf() {
        var oid = $('#oid_hidden').val();
        <%--var oid=${o.o_id};--%>
        window.location="/order/item?o_id="+oid;
    }
    function del(){
        $.ajax({
            type:"POST",
            url:"/order/del",
            data:{o_id:$('#oid_hidden').val()},
            success:function (data) {
                console.log(data);
                var num=$('#pageNum_hidden').val();
                var oid=$('#oid_hidden').val();
                var str = 'tr'+oid;//获取订单id并拼接成每行id
                var deltr=$("#"+str);//获取每行的id
                deltr.remove();//删除行
                var rows=$("table").find('tr').length;
                alert(rows);
                if(rows==1){
                    num=num-1;
                }
                if(num<0){
                    num=1;
                }
                window.location="/order/index?pageNum="+num;
            }
        });
    }


</script>
</html>
