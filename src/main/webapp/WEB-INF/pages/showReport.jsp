<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>增加报表</title>
  
</head>
<body>
	<div class="show" style="border:1px solid black;whith=800px;height=800px">
		<a href="edit.do?repName=${rep.repName }">修改报表</a>
		<a href="delete.do?repName=${rep.repName }">删除报表</a>
 		<jsp:include page="${rep.repUrl }"></jsp:include> 
	</div>
</body>
</html>
