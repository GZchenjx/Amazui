<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/31
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate icon" type="/assets/image/png" href="/static/i/favicon.png">
    <link href="/static/css/amazeui.min.css" rel="stylesheet"/>
    <style>
        .header {
            text-align: center;
        }

        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }

        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>Web ide</h1>
        <p>Integrated Development Environment<br/>代码编辑，代码生成，界面设计，调试，编译</p>
    </div>
    <hr/>
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>登录</h3>
        <hr>
        <div class="am-btn-group">
            <a href="#" class="am-btn am-btn-secondary am-btn-sm"><i class="am-icon-github am-icon-sm"></i> Github</a>
            <a href="#" class="am-btn am-btn-success am-btn-sm"><i class="am-icon-google-plus-square am-icon-sm"></i>
                Google+</a>
            <a href="#" class="am-btn am-btn-primary am-btn-sm"><i class="am-icon-stack-overflow am-icon-sm"></i>
                stackOverflow</a>
        </div>
        <br>
        <br>

        <form id="loginForm" class="am-form">
            <label for="email">邮箱:</label>
            <input type="text" name="email" id="email" value="">
            <br>
            <label for="pwd">密码:</label>
            <input type="password" name="pwd" id="pwd" value="">
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <br/>
            <div class="am-cf">
                <input type="button" onclick="login();" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
                <input type="button" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
            </div>
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>
<script src="/static/js/user/jquery.min.js"></script>
<script src="/static/js/user/jquery-latest.js"></script>
<script>

    function showError(msg,obj){
        $('.error-msg').text(msg).addClass('show');
        obj.parent('.from').addClass('error');
        obj.focus(function(){
            obj.parent('.from').removeClass('error');
            $('.error-msg').removeClass('show');
        });

    }
    function login() {
        $.post('/user/login',
            $("#loginForm").serialize(),
            function (data) {
                if (data.result === "success") {
                    window.location.href = "/user/admin_home";
                } else {
                    showError("账号或密码错误", $("#phone"));
                }
            },
            'json'
        );
    }
</script>

</html>
