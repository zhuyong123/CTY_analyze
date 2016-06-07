<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./include.jsp"%>
<html>
<head>
	 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	
<title>小区收费标准</title>
</head>
<body>
	<div class="result-content">
		 <table class="result-tab" width="100%" id="tab1" >
		 	<thead>
				<tr>
					<th width="5px"></th>
					<th colSpan='2'>项目名称</th>
					<th>收费标准</th>
				</tr>
			</thead>
			<tbody id="result">
		<c:forEach var="chargesStandard" items="${list}" varStatus="stat" >
			<tr>
				<td><c:out value="${chargesStandard.communityDesc}"/></td>
				<td><c:out value="${chargesStandard.oneLevelName}"/></td>
				<td><c:out value="${chargesStandard.twoLevelName}"/></td>
				<td><c:out value="${chargesStandard.costs}"/></td>
			</tr>
		</c:forEach>
			</tbody>
		</table>
</div>
<script>
	MergeCellsVertical(1);
	MergeCellsVertical(0);
	
	function MergeCellsVertical(cellIndex) //相同数据上下合并 
	{
		var tbl =document.getElementById("tab1");
		if (tbl.rows.length < 2)
			return;
		var i, j;
		var last = tbl.rows[0].cells[cellIndex].innerHTML;
		var lastIndex = 0;
		for (i = 1; i < tbl.rows.length; i++) {
			if (tbl.rows[i].cells[cellIndex].innerHTML != last) // 发现新的值 
			{
				if (i > lastIndex + 1) {
					for (j = lastIndex + 1; j < i; j++) {
						tbl.rows[j].cells[cellIndex].remove();
					}
					tbl.rows[lastIndex].cells[cellIndex].rowSpan = i
							- lastIndex;
				}
				//alert(tbl.rows[i].cells[cellIndex].innerHTML);
				last = tbl.rows[i].cells[cellIndex].innerHTML;
				lastIndex = i;
			}
		}
		// 最后一行要特别处理 
		if (lastIndex != tbl.rows.length - 1) {
			for (j = lastIndex + 1; j < tbl.rows.length; j++) {
				tbl.rows[j].cells[cellIndex].remove();
			}
			tbl.rows[lastIndex].cells[cellIndex].rowSpan = tbl.rows.length
					- lastIndex + 1;
		}
	}
</script>
</body>
</html>