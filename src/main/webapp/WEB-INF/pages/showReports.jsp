<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
	<tr><td><a href="addReportPage.do" target="menuFrame">增加报表</a></td></tr>
	<tr>
		<td>报表名</td>
		<td>报表URL</td>
		<td>报表描述</td>
		<td>创建时间</td>
		<td>创建人</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${reports }" var="rep">
		<tr>
			<td>${rep.repName }</td>
			<td>${rep.repUrl }</td>
			<td>${rep.repDesc }</td>
			<td>${rep.createDate }</td>
			<td>${rep.createPerson }</td>
			<td><a href="edit.do?repName=${rep.repName }" target="menuFrame">修改</a>||<a href="delete.do?repName=${rep.repName }" target="menuFrame">删除</a></td>
		</tr>	          
	</c:forEach>
</table>	            
</body>
</html>