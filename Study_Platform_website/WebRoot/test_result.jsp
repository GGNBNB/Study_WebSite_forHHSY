<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="com.studyplatform.web.utils.*" %>
<%@ page import="com.studyplatform.web.bean.*" %>
<%@ page import="com.studyplatform.web.system.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.*" %>
<%@ page import="com.google.gson.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
        <link rel="icon" href="<%=basePath%>images/system_image/logo_page_icon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="<%=basePath%>images/system_image/logo_page_icon.ico" type="image/x-icon">
        <title>测试结果</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/test1.css" type="text/css"/>
	    <link type="text/css" href="${pageContext.request.contextPath }/css/css1.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/JQ.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/zzsc.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.XYTipsWindow.min.2.8.js"></script>
        <link type="text/css" href="${pageContext.request.contextPath }/css/box_style.css" rel="stylesheet" />
    </head>
  
    <body>
        <div id="Top">
            <br>
            <img src="${pageContext.request.contextPath }/images/logo.png" width="315" height="60" />
            <div id="center">
                <div class="nav">
	                <ul>
				        <li><a href="${pageContext.request.contextPath }/index.jspindex.html">首页</a></li>
				        <li class="cur"><a href="${pageContext.request.contextPath }/zhuanye/zhuanye1.html">专业</a></li>
				        <li><a href="${pageContext.request.contextPath }/资源.html">资源</a></li>
				        <li><a href="${pageContext.request.contextPath }/推荐书籍.html">推荐书籍</a></li>
				        <li><a href="#">移动课堂</a></li>
	                </ul> 
	                <div class="curBg"></div>
	                <div class="cls"></div>
                </div>  
            </div>
        
	        <div id="Top-login">
	            <c:choose>
	                <c:when test="${!empty user.user_name}">
		                <c:if test="${fn:length(user.user_name)>6 }">
		                    <font color=red>${fn:substring(user.user_name, 0, 6)}...,欢迎你
		                        &nbsp; <a href="${pageContext.request.contextPath }/servlet/WrittenOffServlet">退出登录</a>
		                    </font>
		                </c:if>
		                <c:if test="${fn:length(user.user_name)<=6}">
			                <font color=red>${user.user_name},欢迎你 
			                    &nbsp;&nbsp; 
			                    <a href="${pageContext.request.contextPath }/servlet/WrittenOffServlet">退出登录</a>
			                </font>
		                </c:if>
	                </c:when>
	                <c:otherwise>
	                    <a href="${pageContext.request.contextPath }/login.jsp" target="_blank">登录</a>
	                    &nbsp; 
	                    <a href="${pageContext.request.contextPath }/login.jsp#toregister" target="_blank">注册</a>
	                </c:otherwise>
	            </c:choose>
	        </div>
        </div>
        
        <div id="middle">
            <div id="middle-1">
                <div id="mid"><h2>学习平台</h2></div>
                <div class="style_1">
			        <form method="get" id="searchform" action="#"><!--搜索跳转网址 -->
			            <fieldset>
			            <input id="s" name="s" type="text" value="输入要搜索的内容" class="text_input" onblur="if(this.value=='输入要搜索的内容'){this.value='';}" onfocus="if(this.value =='输入要搜索的内容') {this.value=''; }" />
			            <input name="submit" type="submit" value /> </fieldset>
			        </form>
                </div>
            </div>
        </div>

        <div id="tjbody">
            <div id="tjbody_box">
                <% 
                    int user_score = (Integer)request.getAttribute("user_score");
                %>
                
                <p>您的测试成绩是：</p>
                <font color=red><p><%=user_score %>分！</p></font>
                <div id="tjbody_box_box">
                    <form action="daan.html" target="_blank">
                        <input type="submit" value="查看答案" id="tjbox_submit">
                    </form>
                </div>
            </div>
            
            <div id="tjbody_box1">
                <p>根据您的成绩，为您推荐以下课程：</p>
            </div>
            
            <div id="tjbody_box2">
                <div class="biaoti">
                    <h3>推荐学习视频</h3>
                </div>
                <div id="box1">
					<div class="box"><a href="测试.html" target="_blank"><img src="images/box1.png" width="291" height="179"></a><h2><a href="详细课程.html">Java基础教程</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box2.png" width="291" height="179"></a><h2><a href="详细课程.html">网页设计HTML</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box4.png" width="291" height="179"></a><h2><a href="详细课程.html">PS教程零基础到精通</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box4.png" width="291" height="179"></a><h2><a href="详细课程.html">软件工程</a></h2></div>
					<div class="box"><a href="测试.html" target="_blank"><img src="images/box1.png" width="291" height="179"></a><h2><a href="详细课程.html">Java基础教程</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box2.png" width="291" height="179"></a><h2><a href="详细课程.html">网页设计HTML</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box4.png" width="291" height="179"></a><h2><a href="详细课程.html">PS教程零基础到精通</a></h2></div>
					<div class="box"><a href="详细课程.html" target="_blank"><img src="images/box4.png" width="291" height="179"></a><h2><a href="详细课程.html">软件工程</a></h2></div>
					<p>&nbsp;</p>
                </div>
            </div>
        </div>

	    <div id="footer">
		    <p>Copyright © 2017 YRCTI. All Rights Reserved.</p>
		    <p>黄河水利职业技术学院 版权所有 | <a href="#" target="_blank" rel="nofollow">博知课堂服务协议</a> | <a href="#">站点地图</a> | <a href="#" target="_blank">侵权投诉</a> | <a href="#" rel="nofollow" report-tdw="action=Feedback" target="_blank">问题反馈</a> | <a href="#" target="_blank">帮助</a></p>
	    </div>
    </body>
</html>