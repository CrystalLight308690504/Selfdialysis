<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登入</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_login.css">
</head>
<body>
<div id="all">
    <div id="login">
        <div id="navigation">登入账户</div>
        <form id="form" align = "center" action="user_login.action" method="post">
            <input name="name" type="text" maxlength="8" placeholder="账号..." value="${name}"/><br/>
            <input name="password" type="password" maxlength="14" placeholder="密码..." value="${password}"/><br/>
            <input id="button_login" type="submit" value="登入"/>
            <input id="button_register" type="button" value="没有账号?" onclick="window.location ='user_toRegisterUi.action' "/>
            <div id="messages">${messages}</div>
        </form>
    </div>
</div>
</body>
</html>
