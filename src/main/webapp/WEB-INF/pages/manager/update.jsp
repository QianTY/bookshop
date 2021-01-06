<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/31
  Time: 9:58 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新产品</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/plugins/layui/css/layui.css">

</head>
<body>
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>拖拽上传</legend>
                </fieldset>

                <div class="layui-upload-drag" id="test10">
                    <i class="layui-icon"></i>
                    <p>点击上传，或将文件拖拽到此处</p>
                    <div class="layui-hide" id="uploadDemoView">
                        <hr>
                        <img src="" alt="上传成功后渲染" style="max-width: 196px">
                    </div>
                </div>
            </div>



            <div class="col-md-8">

                <form class="form-horizontal" role="form" action="/admin/update" method="post">
                    <input type="hidden" value="${requestScope.book.b_id}" name="id">

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书本图</label>
                        <div class="col-sm-10">
                           <img id="my_img" src="${requestScope.book.img_path}" style="width: 150px;height: 150px">
                            <input id="myUrl" name="img_path" type="hidden" value="${requestScope.book.img_path}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">书本id</label>
                        <div class="col-sm-10">
                            <c:if test="${sessionScope.action=='update'}">
                                <input readonly="readonly" type="text" name="b_id" value="${requestScope.book.b_id}" class="form-control">
                            </c:if>
                            <c:if test="${sessionScope.action=='add'}">
                                <input type="text" name="b_id" value="${requestScope.book.b_id}" class="form-control">
                            </c:if>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">书本名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="b_name" value="${requestScope.book.b_name}" class="form-control" id="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">书本价格</label>
                        <div class="col-sm-10">
                            <input type="text" name="b_price" value="${requestScope.book.b_price}" class="form-control" id="price" >

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="author" class="col-sm-2 control-label">书本作者</label>
                        <div class="col-sm-10">
                            <input type="text" name="b_author" value="${requestScope.book.b_author}" class="form-control" id="author" >

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sales" class="col-sm-2 control-label">书本销量</label>
                        <div class="col-sm-10">
                            <input type="text" name="b_sales" value="${requestScope.book.b_sales}" class="form-control" id="sales" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stock" class="col-sm-2 control-label">库存</label>
                        <div class="col-sm-10">
                            <input type="text" name="b_stock" value="${requestScope.book.b_stock}" class="form-control" id="stock" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="kind" class="col-sm-2 control-label">图书类型</label>
                        <div class="col-sm-10">
                            <form role="form">
<%--                                <div class="form-group">--%>
                                    <select name="f_name" class="form-control" id="kind">
                                        <option value="-1">===请您选择产品类型===</option>
                                        <c:forEach items="${requestScope.bookkind}" var="t">
                                            <option <c:if test="${requestScope.book.f_name == t.f_name}">selected</c:if> value="${t.f_name}">${t.f_name}</option>
                                        </c:forEach>
                                    </select>


                                <%--                                </div>--%>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <c:if test="${sessionScope.action=='update'}">
                                                <button type="submit" class="btn btn-warning">更新</button>
                                            </c:if>
                                            <c:if test="${sessionScope.action=='add'}">
                                                <button type="submit" class="btn btn-warning">添加</button>
                                            </c:if>

                                        </div>
                                    </div>
                            </form>
                        </div>
                    </div>

                </form>

            </div>





        </div>

    </div>

    <script src="/plugins/jquery/jquery.min.js"></script>
    <script src="/plugins/bootstrap/js/bootstrap.js"></script>
    <script src="/plugins/layui/layui.js"></script>
    <script>
        layui.use('upload', function() {
            var $ = layui.jquery
                , upload = layui.upload;
            //拖拽上传
            upload.render({
                elem: '#test10'
                ,url: '/admin/upload' //改成您自己的上传接口
                ,done: function(res){
                    layer.msg('上传成功');
                   // layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', "/mvc/imgs/"+res.data);

                    $("#my_img").attr("src","/imgs/"+res.data);

                    $("#myUrl").val(res.data);

                    console.log(res)
                }
            });
        })
    </script>
</body>
</html>
