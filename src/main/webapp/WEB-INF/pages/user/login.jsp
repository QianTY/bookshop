<%--
  Created by IntelliJ IDEA.
  User: xf
  Date: 2020/12/24
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/pages/Common/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="/css/nav.css">
    <link rel="stylesheet" type="text/css" href="/css/CarouselMap.css">
</head>
<body>
<div>
    <jsp:include page="/WEB-INF/pages/Common/left.jsp"/>
</div>
<div id="allswapImg" style="margin-top: -20px;width: 1400px">
    <div class="swapImg"><img src="imgs/1.jpg" /></div>
    <div class="swapImg"><img src="imgs/2.jpg" /></div>
    <div class="swapImg"><img src="imgs/3.jpg" /></div>
</div>
<div class="btn1 btn1Left" ><</div>
<div class="btn1 btn1Right">></div>
<div id="tabs">
    <div class="tab bg">1</div>
    <div class="tab">2</div>
    <div class="tab">3</div>
</div>

<%--    登录表单 - begin--%>
<div class="container" style="width: 550px;height: 500px;margin-top: 100px;margin-left: 900px">
    <div class="row" >
        <form class="form-horizontal" role="form">
                <p style="margin-left: 260px;font-size: 25px;font-weight: bolder">用户登录入口</p>
                <div class="form-group has-feedback" style="margin-left: 110px;margin-top: 30px">
                    <label for="email" class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" id="email" placeholder="请输入邮箱/账号">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        <label id="email_label" style="display: none" class="text-danger">邮箱/账号不存在</label>
                    </div>
                </div>

                <div class="form-group has-feedback" style="margin-left: 110px;margin-top: 30px">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" placeholder="请输入密码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <label id="password_label" style="display: none" class="text-danger">密码不存在</label>
                    </div>
                </div>

                <div class="form-group has-feedback" style="margin-left: 110px;margin-top: 30px" >
                    <label for="code" class="col-sm-2 control-label" >验证码</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="code" placeholder="请输入验证码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <label id="code_label" style="display: none" class="text-danger">验证码错误</label>
                    </div>

                    <div class="col-sm-2">
                        <button type="button" onclick="sendMsg()" class="btn btn-success">发送验证码</button>
                    </div>
                </div>

                <div class="form-group" style="margin-left: 110px;margin-top: 30px">
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
                        <%--                            一定要设置成普通按钮 登录--%>
                        <button type="button" onclick="login()" class="btn btn-default" style="margin-left: 90px;margin-top: 30px">登录</button>
                            <%--                            一定要设置成普通按钮 取消--%>
                            <button type="button" onclick="chancel()" class="btn btn-default" style="margin-left: 100px;margin-top: 30px">取消</button>
                    </div>

                </div>


        </form>
    </div>
</div>
<%--    登录表单end--%>
<script>

    $(function(){
        //等DOM元素全部加载完毕之后,会执行此处的代码...
        //从本地存储中根据key将email获取出来
        let email = localStorage.getItem("email");
        let password=localStorage.getItem("password");

        //放入到input标签中
        let email_input = document.getElementById("email");
        let password_input=document.getElementById("password");
        password_input.value=password;
        email_input.value = email;

        /// <reference path="_references.js" />

        var i = 0;//全局变量
//定义一个变量用来获取轮播的过程
        var time;
        $(function ()
        {
            //1.页面加载后,找到Class等于swapImg的第一个对象，让它显示，它的兄弟元素隐藏
            $(".swapImg").eq(0).show().siblings().hide();
            showTime();
            //当鼠标放到下标上显示该图片，鼠标移走继续轮播
            $(".tab").hover(
                function ()
                {
                    //获取到当前鼠标所在的下标的索引
                    i = $(this).index();
                    show();
                    //鼠标放上去之后，怎么停止呢？获取到变量的过程，清除轮播，把变量传进去
                    clearInterval(time);
                }, function ()
                {
                    showTime();
                });

            //要求四，当我点击左右切换
            $(".btnLeft").click(function ()
            {
                //1.点击之前要停止轮播
                clearInterval(time);
                //点了之后，-1
                if (i == 0)
                {
                    i =6;
                }
                i--;
                show();
                showTime();
            });
            $(".btnRight").click(function () {
                //1.点击之前要停止轮播
                clearInterval(time);
                //点了之后，-1
                if (i == 2) {
                    i = -1;
                }
                i++;
                show();
                showTime();
            });


        });

        function show() {
            //$("#allswapImg").hover(function ()
            //{
            //  $(".btn").show();
            //}, function ()
            //{
            //  $(".btn").hide();
            //});
            //fadeIn(300)淡入，fadeout(300)淡出，过滤时间0.3s
            $(".swapImg").eq(i).fadeIn(300).siblings().fadeOut();
            $(".tab").eq(i).addClass("bg").siblings().removeClass("bg");
        }

        function showTime()
        {
            time = setInterval(function () {
                i++;
                if (i == 3) {
                    //只有6张图片，所以i不能超过6，如果i等于6时，我们就让它等于第一张
                    i = 0;
                }
                show();
            }, 3000);
        }



    })


 function chancel() {
        let email=document.getElementById("email").value="";
        let password=document.getElementById("password").value="";
        let code=document.getElementById("code").value="";

 }
    function logins(){
        //获取记住密码的控件
        let ck = document.getElementById("rem");
        //判断是否记住我
        if(ck.checked){
            //将邮箱中的输入的数据进行保存
            //h5 - 本地存储
            let email = document.getElementById("email").value;
            let password=document.getElementById("password").value;
            localStorage.setItem("email",email);
            localStorage.setItem("password",password);
        }else{
            //清除保存邮箱
            localStorage.removeItem("email");
            localStorage.removeItem("password");
        }
    }

    //发送验证码的功能
    function sendMsg(){
        //获取邮箱值
        //jquery的写法 - js的框架
        let email = $("#email").val();
        let password=$("#password").val();
        //进行一个非空判断...
        if(email.length == 0 || password.length==0){
            alert("sorry,email must be not null");
        }else{
            //发送邮箱到后台...
            //window.location="/user/send?email="+value;

            //ajax方式进行发送...
            $.get("/user/send","email="+email+"&password="+password,function(result){
                //此处的result是后台返回给页面的数据 - json数据
                console.log(result);
                if(result.code == 404){
                    alert("邮箱未注册");
                }else if(result.code==200) {
                    alert("验证码已经发送到您的邮箱!请你查收!");
                }else if(result.code==505){
                    alert("密码错误");
                }
            });
        }
    }

    //登录按钮的功能
    function login(){

        logins();

        let email = $("#email").val();
        let code = $("#code").val();
        let password=$("#password").val();

        document.getElementById("email_label").style.display="none";
        document.getElementById("password_label").style.display="none";
        document.getElementById("code_label").style.display="none";

        //json数据
        $.post("/user/logincl",{email:email,password:password,code:code},function(result){
            if(result.code==404){
                document.getElementById("email_label").style.display="";
                console.log(result);
            }else if(result.code == 500){
                document.getElementById("code_label").style.display="";
                alert("验证码错误")
            }else if(result.code==200){
                //登录成功... 跳转到首页...
                // alert("登录成功")
                window.location="/index"
            }
        });
    }
</script>
</body>
</html>