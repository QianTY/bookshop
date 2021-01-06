<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>商品添加页面</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
        <style>
            #prtadddal{
                /* text-align: center;  */
                border-radius: 20px;
                width: 300px;
                height: 350px;
                margin: auto;
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
            }
            #btnadd{
                text-align: center; 
            }
        </style>
    </head>
    <body>
        <form>
            <div id="prtadddal">
                <div>
                    <p>图书名字：<input type="text" name="b_name" value=""></p>
                    <p>图书价格：<input type="text" name="b_price" value=""></p>
                    <p>图书分类：<select>
                                <option value="jsj">计算机</option>
                                <option value="dz">电子</option>
                                <option value="jx">机械</option>
                                <option value="hx">化学</option>
                            </select></p>
                    <p>图书作者：<input type="text" name="b_author" value=""></p>
                    <p>图书库存：<input type="text" name="b_stock" value=""></p>
                    <p>图书路径：<input type="text" name="img_path" value=""></p>
                </div>
                <div id="btnadd" class="btn-group-lg" >
                    <button type="button" class="btn btn-default">添加</button>
                </div>
            </div>
        </form>



    </body>
</html>