<%--
  Created by IntelliJ IDEA.
  User: QTY
  Date: 2020/12/26
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>购物车</title>
    <jsp:include page="../Common/head.jsp"/>
    <link rel="stylesheet" href="../../../css/numbox.css">
    <style>
        * {
            font-family: 'Microsoft YaHei', sans-serif;
        }

        .bkimg {
            width: 80px;
            height: 80px;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }

        table td, table th {
            border: 1px solid #cad9ea;
            color: #666;
            /*height: 30px;*/
        }

        table thead th {
            background-color: #CCE8EB;
            /*width: 100px;*/
        }

        table tr:nth-child(odd) {
            vertical-align: center;
        }

        table tr:nth-child(even) {
            background: #F5FAFA;
        }

    </style>
</head>
<body>
<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>
<div class="col-md-10 col-md-offset-1" style="text-align: center;margin-top: 50px">
    <section>
        <center>

            <div id="outer">

            </div>

        </center>
    </section>
</div>
</body>
<script type="text/javascript">

    // 通过异步加载的方式去加载这个部分的分页的数据
    $(function(){
        $("#outer").load("/cart/flushTable");
    });

    function del_cartItem(b_id) {
        let flag= confirm("确认删除该商品吗?");

        if (flag){
            $.post("/cart/delCartItem",{b_id:b_id},function (data) {
                console.log("1111");
                if(data.code == 200){
                    var str = "#tr" + b_id.toString();
                    //str.remove();
                    $("#outer").load("/cart/flushTable");
                }
            })
        }else {
            return flag;
        }

    }

    function changeNum(b_id) {
        let num = $("#input_num").val();

        let flag = confirm("您确定修改数量吗?");
        if (flag){
            $.post("/cart/update",{b_id:b_id,num:num},function (data) {
                alert(data.msg);
            })
        }
    }

    function checkout(){
        //根据name属性的值获取所有的checkbox控件
        //因为name属性的值是允许重复的,所以根据name属性的值得到的肯定是一个数组
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

        if(count==0){//没有选中任何一个
            alert("sorry,请你先选中商品!");
            return false;
        }

        //有选中的商品
        let flag = confirm("确定结算吗?");
        //确定 - flag - true,否则false
        if(flag){
            //处理一下最后一个冒号
            sids = sids.substring(0,sids.length-1);
            //根据冒号进行切割,返回一个数组
            // let arr = sids.split(":");
            //window.location="/mvc/product/delete?sids="+sids;

            $.post("/cart/checkout",{sids:sids},function(data){
                alert(data.msg);
                if(data.code==200){
                    $("#outer").load("/cart/flushTable");
                }
            })
        }

    }


</script>
</html>
