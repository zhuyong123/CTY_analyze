<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./include.jsp"%>
<html>
<head>
	 <link rel="stylesheet" type="text/css" href="./css/common.css"/>
     <link rel="stylesheet" type="text/css" href="./css/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>参数配置</title>
</head>
<body>
     <div class="crumb-wrap">
         <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">参数配置</span></div>
     </div>
     <div class="result-wrap">
         <form action="" method="post" id="myform" name="myform">
             <div class="config-items">
                 <div class="config-title">
                     <h1><i class="icon-font">&#xe00a;</i>网站信息设置</h1>
                 </div>
                 <div class="result-content">

				<table width="100%" class="insert-tab">
					<tbody>
					<c:forEach items="${propertyMap}" var="mymap"> 
					      <c:if test="${mymap.key=='snapmatch.inReviewVersion.version'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.inReviewVersion.version：</th>
								<td><input type="text" name="snapmatch.inReviewVersion.version" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if>
					      <c:if test="${mymap.key=='snapmatch.min.version'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.min.version：</th>
								<td><input type="text" name="snapmatch.min.version" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if> 
					      <c:if test="${mymap.key=='snapmatch.max.version'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.max.version：</th>
								<td><input type="text" name="snapmatch.max.version" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if>
					      <c:if test="${mymap.key=='snapmatch.version.msg'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.version.msg：</th>
								<td><input type="text" name="snapmatch.version.msg" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if>
					      <c:if test="${mymap.key=='snapmatch.match.geo.default.distance'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.match.geo.default.distance：</th>
								<td><input type="text" name="snapmatch.match.geo.default.distance" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if> 
					      <c:if test="${mymap.key=='snapmatch.match.user.max.number'}"> 
					          <tr>
								<th width="20%"><i class="require-red">*</i>snapmatch.match.user.max.number：</th>
								<td><input type="text" name="snapmatch.match.user.max.number" value="${mymap.value}"
									size="85" name="keywords" class="common-text"></td>
							  </tr>
					      </c:if> 
					      <!--<tr>
							<th width="25%"><i class="require-red">*</i>${mymap.key}：</th>
							<td><input type="text" id="" value="${mymap.value}"
								size="85" name="keywords" class="common-text"></td>
						  </tr>-->
					</c:forEach> 
						<tr>
							<th></th>
							<td>
								<input type="button" value="提交" onclick="changeFrame()" class="btn btn-primary btn6 mr10"> 
								<input type="button" value="返回" onclick="history.go(-1)" class="btn btn6">
							</td>
						</tr>
					</tbody>
				</table>
              </div>
          </div>
      </form>
  </div>
   <script type="text/javascript">
	    function changeFrame(){
	    	document.getElementById("myform").action="${ctx}/manage.do?method=savePropertes";
	    	alert("保存成功！");
	    	document.getElementById("myform").submit();
	    }
    </script>
</body>
</html>