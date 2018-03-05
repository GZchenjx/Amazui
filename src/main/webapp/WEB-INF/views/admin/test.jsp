<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>入门</title>
    <script src="/static/js/angular.min.js"></script>
    <style>
        .bgc-red {
            background-color: red;
        }
    </style>
</head>
<body ng-app="s1.app">

<button class="{{currentBtn == 1 ? 'bgc-red':''}}" ng-click="setCurrent(1)">按钮1</button>
<button class="{{currentBtn == 2 ? 'bgc-red':''}}" ng-click="setCurrent(2)">按钮2</button>
<button class="{{currentBtn == 3 ? 'bgc-red':''}}" ng-click="setCurrent(3)">按钮3</button>
<button class="{{currentBtn == 4 ? 'bgc-red':''}}" ng-click="setCurrent(4)">按钮4</button>

<script>
    // 1. 定义一个我们自己的模块，
    // 第一个参数是：模块名，
    // 第二个参数：所依赖的其他的模块的名字的数组
    var app = angular.module('s1.app', []);
    // app.run是Angularjs版本的“入口函数”，我们的Angularjs框架加载完成之后，就会来执行这里的函数。
    // 其中有一点需要注意：$rootScope是Angularjs提供的“数据对象”，
    // 我们操作这个数据对象，就可以把变化同步到DOM上
    // 参数名是写死的，不要变。（Angularjs的回调函数的传参，很多地方是“只认名字，不认顺序”的）
    app.run(function ($rootScope) {
        $rootScope['msg'] = 'hello angular';
        $rootScope['cssClass'] = 'bgc-red';
        $rootScope['currentBtn'] = 1; // 标识当前的按钮
        $rootScope['setCurrent'] = function (current) { // 当按钮被点击之后，调用，设置当前的按钮
            $rootScope['currentBtn'] = current;
        }
    })
</script>
</body>
</html>