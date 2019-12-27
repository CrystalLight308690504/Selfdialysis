<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.js"></script>
    <meta charset="utf-8">
    <title>轮滑日记</title>
  </head>
  <body>

<jsp:include page="/WEB-INF/jsp/head/head.jsp"/>
<!--导航栏-->
<div id="all">
    <!--焦点-->
    <div id="banner">
        <!--上一张图片-->
        <img id="banner_image_last" src="${pageContext.request.contextPath}/images/background/banner_last.png" width="64"/>
        <!--下一张图片-->
        <img id="banner_image_next" src="${pageContext.request.contextPath}/images/background/banner_next.png" width="64"/>
    </div>

    <div>
        <!-- 自己介绍-->
        <div id="introduce_self">
            <div>
                <div id="myself"><img src="${pageContext.request.contextPath}/images/background/psb.jpg" height="200" alt=" it is me!"/></div>
                <!--介绍内容-->
                <div id="information"></div>
            </div>
        </div>
    </div>


    <!--刷街介绍-->
    <div id="travel">
        <div id="travel_box">
            <table height="310px" cellspacing="0">
                <tr>
                    <td colspan="2"><a href="subhtml/sdj.html"><img src="${pageContext.request.contextPath}/images/travelPicture/shengdan.png" width="400"
                                                                    alt="圣诞刷街" title="点击查看"/></a></td>
                    <td></td>
                    <td colspan="2"><a href="subhtml/jlpark.html"><img src="${pageContext.request.contextPath}/images/travelPicture/julong.png"
                                                                       width="400"
                                                                       alt="刷街聚龙公园" title="点击查看"/></a></td>
                    <td></td>
                </tr>
                <tr>
                    <td width="400"></td>
                    <td colspan="2" width="150"></td>
                    <td></td>
                    <td width="300"></td>
                </tr>
                <tr>
                    <td colspan="2"><a href="${pageContext.request.contextPath}/subhtml/lakes.html"><img src="${pageContext.request.contextPath}/images/travelPicture/xihua.png" width="400"
                                                                      height="300" alt="刷街西湖" title="点击查看"/></a>
                    </td>
                    <td></td>
                    <td colspan="2"><a href="${pageContext.request.contextPath}/subhtml/lakes.html"><img src="${pageContext.request.contextPath}/images/travelPicture/yexihu.png" width="400"
                                                                      alt=" 夜刷西湖" title="点击查看"/></a></td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div id="foot">
    <h1 align="center" style="color: #F8A00E;">刷街视频</h1>
    <a href="https://v.youku.com/v_show/id_XNDM3Mjg2NDAyNA==.html" target="_blank">->玉湖公园<-</a>
    <a href="https://v.youku.com/v_show/id_XNDM3Mjg2MzMzMg==.html"  target="_blank">->秋收广场<-</a>
    <a href="https://v.youku.com/v_show/id_XNDM3Mjg2MzcxMg==.html"  target="_blank">->鹅湖公园<-</a>
</div>
</div>
<style>
    #foot a{
        color: #F8A00E;
        margin: 20px;
    }
    #foot{
        text-align: center;
    }
</style>
    <script src="${pageContext.request.contextPath}/script/index.js"></script>
    <script src="${pageContext.request.contextPath}/script/center.js"></script>
  </body>
</html>
