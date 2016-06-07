<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./include.jsp"%>
<html>
<head>
	 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	
<title>意见反馈</title>
</head>
<body>
<div class="crumb-wrap">
    <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><a href="#">意见反馈</a></div>
</div>
<div class="search-wrap">
    <div class="search-content">
        <form action="#" method="post">
            <table class="search-tab">
                <tr>
                    <th width="70">用户名称:</th>
                    <td><input class="common-text" name="keywords" value="" id="userName" type="text"></td>
                    <th width="70">描述:</th>
                    <td><input class="common-text" name="keywords" value="" id="descId" type="text"></td>
                    
                    <td><input class="btn btn-primary btn2" name="sub" value="查询" type="button" onclick="getAnaLsBydate(1,1)"></td>
                </tr>
            </table>
        </form>
    </div>
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
					<th width='10%'>用户名称</th>
					<th>描述</th>
					<th width="12%">创建时间</th>
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
	
	var pageSize = 10;
	var pageNum = 1;
	getAnaLsBydate(pageNum,1);
	function getAnaLsBydate(pageIndex,status){
		pageNum = pageIndex;
		var url="${ctx}/manage.do?method=getAjaxFeedback";
		$.ajax({
			  type:'post',
			  url: url,
			  dataType: 'json',
			  async:false,
			  data: {"pageSize":pageSize,"pageNum":pageNum,"userName":$('#userName').val(),"description":$('#descId').val()},
			  success: function(data){
				var length = data.totalSize;
				var ls = data.result;
	 			var html="";
				$.each(ls, function(i){
					html += "<tr>";
		 			html += "<td>"+ls[i].id+"</td>";
		 			html += "<td>"+ls[i].user_id+"</td>";
		 			html += "<td>"+ls[i].user_name+"</td>";
		 			html += "<td>"+ls[i].description+"</td>";
		 			html += "<td>"+ls[i].create_time+"</td>";
		 			html += "</tr>";
				});
				$('#result').html(html);
				if(($("#page").html().length == '' && length>pageSize) || status==1){
					$("#page").pagination(length, {
						num_edge_entries : 3,
						num_display_entries : 3,
						prev_text : "上一页",
						next_text : "下一页",
						items_per_page : pageSize,
						callback : PageCallback
					});
				}
			  },
	            error: function() {
	          	 alert('查询失败!');
	            }                                                                 
			}); 
		
	}
	
             
       //翻页调用 
   	function PageCallback(index) {
   		getAnaLsBydate(index+1,0);
   		
   		//取得父页面IFrame对象,调整页面高度
   		var obj = parent.document.getElementById("frame1"); 
   		obj.height = document.body.scrollHeight;
   		
   	}
       
    
</script>
</body>
</html>