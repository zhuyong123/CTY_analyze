<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>增加报表</title>

</head>
<body>
	<form action="addReport.do" method="post">
		报表名：<input type="text" name="repName"><br>
		报表URL：<input type="text" name="repUrl"><br>
		报表描述：<input type="text" name="repDesc"><br>
		创建人：<input type="text" name="createPerson"><br>
		<input type="submit" value="提交" onclick="add()"> <input type="reset">
	</form>
</body>
</html>
