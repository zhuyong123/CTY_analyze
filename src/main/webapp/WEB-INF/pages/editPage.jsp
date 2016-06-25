<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
  <title>增加报表</title>
  
</head>
<body>
	<form action="editReport.do" method="post">
		报表名：<input type="text" name="repName" value="${rep.repName }" readonly><br>
		报表URL：<input type="text" name="repUrl" value="${rep.repUrl }"><br>
		报表描述：<input type="text" name="repDesc" value="${rep.repDesc }"><br>
		<input type="submit" value="提交"> <input type="reset">
	</form>
</body>
</html>
