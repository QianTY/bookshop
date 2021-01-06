<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>管理员页面</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>

    </head>
    <body>

    <input type="hidden" value="${sessionScope.result}" id="result_hidden">
    <div id="other">

    </div>


    </body>
    <script>
        $(function () {
           $("#other").load("/admin/booklist");
           var result=$("#result_hidden").val();
           if(result==200){
               alert("成功");
           }else if(result==404){
               alert("有重复ID")
           }
        });


    </script>
</html>