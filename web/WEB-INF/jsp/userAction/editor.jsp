<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_editor.css">
    <script rel="script" src="${pageContext.request.contextPath}/script/jquery-3.4.1.js" ></script>
    <title>编辑信息</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/head/head.jsp"/>
<div id="all">
    <div id="editor">
        <div id="navigation">编辑信息</div>
        <form id="form" action="user_editor.action" method="post">
            <input id="oldPassword" name="oldPassword" type="password" maxlength="14" placeholder="原密码..."  /><span id="old_password_message"></span><br/>
            <input id="password" name="password" type="password" maxlength="14" placeholder="密码..."  /><span id="password_message"></span><br/>
            <input id="passwordAgain" name="passwordAgain" type="password" maxlength="14" placeholder="请再输入一次密码..." /><span
                id="password_message_again"></span><br/>
            <div id="gender">
                <input name="gender" type="radio" value="男" checked="true">男
                <input name="gender" type="radio" value="女">女
            </div>
            <input id="button_editor" type="submit" value="确认修改" disabled = "true" onclick="window.confirm('确认修改?')"/>
            <div id="messages">${messages}</div>
        </form>
    </div>
</div>
</body>
<script rel="script" src="${pageContext.request.contextPath}/script/user_editor.js" ></script>
</html>
