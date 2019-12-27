<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>所有日记</title>
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/topic_all_topic.css">
</head>
<s:debug/>
<jsp:include page="/WEB-INF/jsp/head/head.jsp"/>
<div id="all">
    <div id="topics">
        <table>
            <tr align="center">
                <th>标题
                <th/>
                <th>时间</th>
                <th>作者</th>
            </tr>
            <%--添加数据--%>
            <s:iterator value="topics">
                <tr id="topic" tr align="center">
                    <td><a href="topic_toLookTopic.action?id=${id}">${title}</a></td>
                    <td></td>
                    <td>${writingDate}</td>
                    <td>${writer.name}</td>
                </tr>
            </s:iterator>
            <tr>
                <td  style="text-align: center"><a id="firstPage" href="topic_toAllTopicUi.action?pageIndex=${0}">首页</a></td>
                <td  style="text-align: center"><a id="lastPage" href="topic_toAllTopicUi.action?pageIndex=${pageIndex-1}">上一页</a></td>
                <td  style="text-align: center"><a id="nextPage" href="topic_toAllTopicUi.action?pageIndex=${pageIndex+1}">下一页</a></td>
                <td  style="text-align: center"><a id="finalPage" href="topic_toAllTopicUi.action?pageIndex=${maxPage-1}">尾页</a></td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center">
                <s:iterator begin="1" end="maxPage" status="L">
                    <a href="topic_toAllTopicUi.action?pageIndex=${L.index}">${L.index + 1}</a>
                </s:iterator>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">第${pageIndex+1}页</td>
                <td colspan="2" style="text-align: center"><a href="topic_toAddTopicUi.action">添加日记</a></td>
            </tr>
            <tfoot>
            <td colspan="4" style="text-align: center"><a href="topic_toMyTopicUi.action?pageIndex=0">查看我的日记</a></td>
            </tfoot>
        </table>
    </div>
</div>
</body>
<script>
    // 首页 上一页按钮
    if(${pageIndex == 0}){// 如果是第一页
        $("#firstPage").hide();
        $("#lastPage").hide();
    }else {// 如果是最后一页
        $("#firstPage").show();
        $("#lastPage").show();
    }

    // 尾页 下一页按钮
    if(${pageIndex+1 >= maxPage }){
        $("#finalPage").hide();
        $("#nextPage").hide();
    }else {
        $("#finalPage").show();
        $("#nextPage").show();
    }
</script>
</html>
