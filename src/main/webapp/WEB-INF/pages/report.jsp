<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./include.jsp"%>
<html>
<head>
	 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	
<title>举报投诉</title>
</head>
<body>
<div class="crumb-wrap">
    <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><a href="#">举报投诉</a></div>
</div>

<div class="result-wrap" >
	 <!--<div class="result-title">
          <a href="insert.html"><i class="icon-font"></i>新增作品</a>
              <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
              <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
	</div>-->
	<div class="result-content">
		 <table class="result-tab" width="100%" >
		 	<thead>
				<tr>
					<th width='5%'>ID</th>
					<th width='5%'>用户ID</th>
					<th>描述</th>
					<th width="12%">创建时间</th>
					<th width='10%'>审核状态</th>
				</tr>
			</thead>
			<tbody id="result">
			</tbody>
		<!--<c:forEach var="feedback" items="${list}" varStatus="stat" >
			<tr>
				<td><c:out value="${feedback.id}"/></td>
				<td><c:out value="${feedback.user_id}"/></td>
				<td><c:out value="${feedback.user_name}"/></td>
				<td><c:out value="${feedback.description}"/></td>
				<td><c:out value="${feedback.create_time}"/></td>
			</tr>
		</c:forEach>-->
		</table>
		<div id="page" align="right" style="width:755px;margin-top:17px;padding-bottom:13px;height:22px;line-height:22px;font-size:12px;color:#969696;"></div>
	</div>
</div>
<script>
	
	var _pageSize = 5;
	var pageNum = 1;
	getAnaLsBydate();
	function getAnaLsBydate(){
		var url="${ctx}/manage.do?method=getAjaxReport";
		$.ajax({
			  type:'post',
			  url: url,
			  dataType: 'json',
			  async:false,
			  //data: {},
			  success: function(data){
			    var rows = 8;
				var i = 0;
				var batch = 0;
				var length = data.length;
	 			var html="";
				$.each(data, function(i){
					// 累计满了一页, 批量增加;
					if (0 != i && 0 == i % rows) {
						batch++;
					}
					html += "<tr batch=\""+batch+"\" id=\"serviceNum_"+batch+"\">";
		 			html += "<td>"+data[i].id+"</td>";
		 			html += "<td>"+data[i].user_id+"</td>";
		 			html += "<td>"+data[i].description+"</td>";
		 			html += "<td>"+data[i].create_time+"</td>";
		 			html += "<td>";
	 				if(data[i].audit_result=='0'){
	 					html += "待审核"
	 				}else{
	 					html += "已审核";
	 				}
		 			html += "</td>"
		 			html += "</tr>";
				});
				$('#result').html(html);
				$("#page").pagination(length, {
					num_edge_entries : 3,
					num_display_entries : 3,
					prev_text : "上一页",
					next_text : "下一页",
					items_per_page : rows,
					callback : trPage
				});
				trPage(0);
			  },
	            error: function() {
	          	 alert('查询失败!');
	            }                                                                 
			}); 
		
	}
	
	/**
	 * 列表翻页事件
	 * 
	 * @param index
	 *            页面下标;
	 */
	function trPage(index) {
		$("tr[id^='serviceNum_']").each(function() {
			$(this).hide();
		});
		$("tr[id^='serviceNum_'][batch='" + index + "']").each(function() {
			$(this).show();
		});
		
		 var obj = parent.document.getElementById("frame1");  //取得父页面IFrame对象,调整页面高度
		 obj.height = document.body.scrollHeight;
		
	}
</script>
</body>
</html>