
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css" rel="stylesheet" type="text/css">

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .login_div
        {
            width: 100%;
            height: 100%;
            position: absolute;
        }
    </style>
</head>



<body>
<div class="login_div" style="background-image: linear-gradient( 135deg, #65FDF0 10%, #1D6FA3 100%);">
    <div class="login layui-anim layui-anim-up">
        <div class="message" style="background-color: #41b8f0">管理登录</div>
        <div id="darkbannerwrap"></div>
        <form action="/dologin.html" method="post">
            <input required name="username" type="text"  placeholder="用户名">

            <input required name="password" type="password" id="password" placeholder="密码"/>
            <input value="登录" style="width:100%; background-color: #41b8f0" type="submit">
        </form>
    </div>

</div>
</body>
</html>

