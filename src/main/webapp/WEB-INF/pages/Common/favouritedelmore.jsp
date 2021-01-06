<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2021/1/5
  Time: 10:05
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
        <div style="width:400px;height:220px;margin-top: 40px; margin-left: 250px" id="div${b.b_id}">
                <%--            隐藏域--%>
            <input type="hidden" value="div${b.b_id}" id="div_hidden">


            <input style="margin-left: 200px" type="checkbox" name="cks" value="${b.b_id}" id="${b.b_id}">


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
            </div>
        </div>
    </c:forEach>

    <c:if test="${ not empty bookinfo}">
    <input type="button" id="dosubmit" value="删除" class="btn-sm" style="margin-left: 1100px" onclick="del_more()">
    </c:if>

    <P></P>
</div>
<script>
    function del_more(){
        //根据name属性的值获取所有的checkbox控件
        //因为name属性的值是允许重复的,所以根据name属性的值得到的肯定是一个数组
        // alert("你无了");
        let cks = document.getElementsByName("cks");
        //定义一个计数器的变量
        let count = 0;

        //定义一个变量,用来保存所有选中的商品的id
        let sids="";

        //当没有任何一个ck被选中,点击的事件
        for(let i=0;i<cks.length;i++){
            if(cks[i].checked){
                count++;


                sids+=cks[i].value+":";
            }
        }
// alert(sids);
        if(count==0){//没有选中任何一个
            alert("sorry,请你先选中商品!");
            return;
        }

        //有选中的商品
        let flag = confirm("确定删除吗?");
        //确定 - flag - true,否则false
        if(flag){
            //处理一下最后一个冒号
            sids = sids.substring(0,sids.length-1);
            //根据冒号进行切割,返回一个数组
            // let arr = sids.split(":");
            //window.location="/mvc/product/delete?sids="+sids;

            $.post("/favourite/delmore2",{sids:sids},function(data){
                $("#outer").load("/favourite/delmore1");

            })
        }

    }
</script>
</body>
</html>
