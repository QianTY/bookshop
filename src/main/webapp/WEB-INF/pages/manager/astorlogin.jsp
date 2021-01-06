<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>管理员登录</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <jsp:include page="../Common/head.jsp"/>
        <style>
            #adlogin{
                
                border-radius: 25px;
                border: 1px solid gray;
                margin: 100px;
                padding: 50px; 
                width: auto;
                height: auto;    
            }
        </style>
    </head>
    <body>

        <div id="adlogin" class="container">
            <div class="row" id="login_div">
                <form class="form-horizontal" role="form">
                    <fieldset>
                        <legend>管理员登录入口</legend>
                        <div class="form-group has-feedback">
                            <label for="id" class="col-sm-2 control-label">管理员账户：</label>
                            <div class="col-sm-8">
                                <input type="email" class="form-control" id="id" placeholder="请输入管理员账户">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="password" class="col-sm-2 control-label">管理员密码：</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control" id="password" placeholder="请输入管理员密码">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" id="rem">请记住我
                                    </label>
                                </div>
                            </div>
                        </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" onclick="login()" class="btn btn-default">登录</button>
                                </div>
                            </div>

                    </fieldset>
                </form>
            </div>
        </div>


    <script>
        $(function(){
            //等DOM元素全部加载完毕之后,会执行此处的代码...
            //从本地存储中根据key将email获取出来
            var id = localStorage.getItem("id");
            var password = localStorage.getItem("password");
            //放入到input标签中
            var id_input = document.getElementById("id");
            var password_input = document.getElementById("password");
            id_input.value = id;
            password_input.value=password;
        })

        function login() {
            //获取账号密码
            var id=$("#id").val();
            var password=$("#password").val();

            //记住我
            var ck=document.getElementById("rem");
            if(ck.checked){
                //alert(email);
                localStorage.setItem("id",id);
                localStorage.setItem("password",password);
            }else {
                localStorage.removeItem("email");
                localStorage.removeItem("password");
            }

            // 发送登录请求
            $.post("/admin/login",{id:id,password:password},function(result){
                console.log(result);
                if(result.code==404){
                    alert("管理员不存在");
                }else if(result.code==200){
                    console.log("登陆成功");
                    window.location="/admin/administrator";
                }
            });
        }
    </script>

    </body>
</html>