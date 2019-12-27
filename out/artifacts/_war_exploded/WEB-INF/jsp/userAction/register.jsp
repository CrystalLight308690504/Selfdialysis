<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_register.css">
    <script rel="script" src="${pageContext.request.contextPath}/script/jquery-3.4.1.js" ></script>
    <title>用户注册</title>
</head>
<body>
<div id="all">
    <div id="register">
        <div id="navigation">注册账户</div>
        <form id="form" action="user_register.action" method="post">
            <input id="name" name="name" type="text" maxlength="11" placeholder="账号..." value="${name}" /><span id="name_message"></span><br/>
            <input id="password" name="password" type="password" maxlength="14" placeholder="密码..." value="${password}" /><span id="password_message"></span><br/>
            <input id="passwordAgain" name="passwordAgain" type="password" maxlength="14" placeholder="请再输入一次密码..." value="${password}" /><span
                id="password_message_again"></span><br/>
            <div id="gender">
                <input name="gender" type="radio" value="男" checked="true">男
                <input name="gender" type="radio" value="女">女
            </div>
            <input id="button_register" type="submit" value="确认注册" disabled = "true" onclick="window.confirm('确认注册?')"/>
            <div id="messages">${messages}</div>
        </form>
    </div>
</div>
</body>
<script rel="script" src="${pageContext.request.contextPath}/script/user_register.js" ></script>
</html>
