<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加话题</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topic_add_topic.css" />
</head>
<body>
<jsp:include page="/WEB-INF/jsp/head/head.jsp"/>
<div id="all">
    <form action="topic_saveTopic.action" method="post" onsubmit="return window.confirm('确认添加?')">
        <p>标题:</p>
        <textarea id="title" name="title" required="required" rows="1" autofocus="autofocus" maxlength="50"></textarea><br/>
        <p>内容:</p>
        <textarea id="contents" name="contents" required="required" rows="6"></textarea><br/>
        <input id="btn_add" type="submit" value="添加" />
    </form>
</div>
</body>
</html>
