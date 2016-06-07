<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./include.jsp"%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>SnapMatch后台管理</title>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}">首页</a></li>
                <!-- <li><a href="#" target="_blank">网站首页</a></li> -->
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <!-- <li><a href="#">修改密码</a></li> -->
                <li><a href="${ctx}/login.do?method=logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="#" onclick="changeFrame('${ctx}/manage.do?method=getFeedback')"><i class="icon-font">&#xe008;</i>意见反馈</a></li>
                        <li><a href="#" onclick="changeFrame('${ctx}/manage.do?method=getReport')"><i class="icon-font">&#xe005;</i>投诉举报</a></li>
                        <li><a href="#" onclick="changeFrame('${ctx}/manage.do?method=getPropertes')"><i class="icon-font">&#xe006;</i>参数配置</a></li>
                        <li><a href="#" onclick="changeFrame('${ctx}/manage.do?method=getUsers')"><i class="icon-font">&#xe003;</i>用户管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>报表分析</a>
                    <ul class="sub-menu">
                        <li><a href="#"><i class="icon-font">&#xe017;</i>活跃分析</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap" height="100%">

         <iframe scrolling="no" name="frame1" frameborder="0" src="${ctx}/manage.do?method=getFeedback" 
         	width="100%" id="frame1" onload="this.height=this.contentWindow.document.documentElement.scrollHeight">
         </iframe>
         
    </div>
    <!--/main-->
    <script type="text/javascript">
	    function changeFrame(url){
	    	document.getElementById("frame1").src=url;
	    }
	    
	    function iFrameHeight() {    
	    	var ifm= document.getElementById("frame1");    
	    	var subWeb = document.frames ? document.frames["frame1"].document : ifm.contentDocument;    
	    	if(ifm != null && subWeb != null) { 
	    	   ifm.height = subWeb.body.scrollHeight; 
	    	}    
    	} 
    </script>

</body>
</html>