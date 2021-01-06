<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2021/1/4
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="/css/CarouselMap.css">

</head>
<body>

<jsp:include page="/WEB-INF/pages/Common/left.jsp"/>

<div class="container" style="margin-top: 70px">
   <div class="row" >
       <div style="font-size: 30px;">
           <div style="float: left">
           <p>我的收藏</p>
           </div>
           <div style="margin-left: 800px;float: right">
           <input type="button" class="btn-lg" value="管理" name="manage" onclick="manager()"></input>
           </div>
       </div>

       <%--    在隐藏域中放入到session作用域中的用户--%>
       <input type="hidden" value="${user.u_name}" id="user_hidden">

       <%--    主动去加载数据--%>
       <div id="outer">

       </div>


   </div>
</div>

<script>
    // 通过异步加载的方式去加载这个部分的分页的数据
    $(function(){
        $("#outer").load("/favourite/out");
    })

 function deleted(b_id) {
             $("#outer").load("/favourite/out",{b_id:b_id},function () {
                 let flag = confirm("确定删除吗?");
                    var id=$('#div_hidden').val();
                    var divid="div"+id;
                    var div_id=$("#"+divid);
                    div_id.remove()
             });
 }
    function manager(){
        $("#outer").load("/favourite/delmore1");
    }



</script>
</body>
</html>
