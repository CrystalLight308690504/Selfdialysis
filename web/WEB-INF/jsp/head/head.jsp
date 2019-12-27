<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css">
    <script rel="script" src="${pageContext.request.contextPath}/script/jquery-3.4.1.js" ></script>
</head>
<body>
<!--导航栏-->
<div id="head_all">
    <div id="nav">
        <!--welcome-->
        <div id="welcome"><a id="user" href="user_toEditorUi.action" title="修改信息">${sessionScope.user.name}</a> 欢迎!</div>
        <a id="un_login" href="user_unLogin.action">退出</a>
        <div id="packList">
            <div id="leftb"></div>
            <ul>
                <li><a href="user_login.action">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/subhtml/zero_skating.html">零度轮舞</a></li>
                <li><a href="topic_toMyTopicUi.action">日记</a></li>
            </ul>
            <div id="rightb"></div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/script/head.js"></script>
</body>
</html>
