<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看日记</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topic_look.css"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/head/head.jsp"/>
<div id="all">
    <div id="background">
        <div id="title">${title}</div>
        <textarea id="content" disabled='disabled'>${contents}</textarea>
    </div>
</div>
</body>
</html>
