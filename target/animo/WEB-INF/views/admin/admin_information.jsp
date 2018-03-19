<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/1
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>

<%--用vue.js渲染数，，--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <link rel="stylesheet" href="<%=path %>/static/layui/css/layui.css"  media="all">
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>表单集合演示</legend>
</fieldset>

<form class="layui-form" action="" id="app">
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱：</label>
        <div class="layui-input-block">
            <input type="text" name="email" lay-verify="email" v-model="user.email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码：</label>
        <div class="layui-input-block">
            <input type="text" name="pwd" lay-verify="required" v-model="user.pwd" placeholder="请输入名字" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">QQ：</label>
        <div class="layui-input-block">
            <input type="text" name="qq" lay-verify="required" v-model="user.qq" placeholder="请输入名字" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名字：</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" v-model="user.name" placeholder="请输入名字" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机号：</label>
            <div class="layui-input-inline">
                <input type="tel" name="phone" lay-verify="required|phone" v-model="user.phone" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">微博：</label>
        <div class="layui-input-block">
            <input type="text" name="twitter" lay-verify="required" v-model="user.twitter" placeholder="请输入名字" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">微博：</label>
        <div class="layui-input-block">
            <input type="textarea " name="intro" lay-verify="required" v-model="user.intro" placeholder="请输入名字" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script src="<%=path %>/static/layui/layui.js" charset="utf-8"></script>
<script src="<%=path %>/static/layui/vue.min.js" charset="utf-8"></script>
<script src="<%=path %>/static/layui/axios.min.js" charset="utf-8"></script>

<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //自定义验证规则
        form.verify({
            email: function(value){
                if(value.length < 5){
                    return '邮箱长度布恩那个小于5位';
                } else if(value.length < 0){
                    return '邮箱长度不能为空！！！';
                }
            },
            email: function(value){
                if(value.length < 5){
                    return '密码长度布恩那个小于5位';
                } else if(value.length < 0){
                    return '密码长度不能为空！！！';
                }
            },
            content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: 'aaa'
            });
            return false;
        });

    });


        var vue = new Vue({
        el: "#app",
        data: {
            user:[],
        },
        created() {
            axios.post('/user/getById/${sessionScope.user.id}').then((response) => {
                vue.user = response.data;
               /* console.log(vue.user.name);*/
        });
        },
    })
</script>

</body>
</html>
