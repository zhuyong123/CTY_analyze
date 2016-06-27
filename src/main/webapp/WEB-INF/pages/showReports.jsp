<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>showReports</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  		window.parent.shows();
  	});
  </script>
</head>
<body>
	<!-- /.box -->
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">Reports</h3>
		</div>
		<div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
        </div>
		<!-- /.box-header -->
		<div class="box-body">
			<table id="example2" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>报表名</th>
						<th>报表URL</th>
						<th>报表描述</th>
						<th>创建时间</th>
						<th>创建人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reports }" var="rep">
						<tr>
							<td>${rep.repName }</td>
							<td>${rep.repUrl }</td>
							<td>${rep.repDesc }</td>
							<td>${rep.createDate }</td>
							<td>${rep.createPerson }</td>
							<td><div class="tools">
									<a href="ReportController.do?method=editPage&repName=${rep.repName }"><i
										class="fa fa-edit"></i> </a> 
									<a	href="ReportController.do?method=deleteReport&repName=${rep.repName }"><i
										class="fa fa-trash-o"></i></a>
								</div></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
			
			<!-- /.box-body -->
			<div class="box-footer clearfix no-border">
				<a href="ReportController.do?method=addReportPage">
					<button type="button" class="btn btn-default pull-right">
						<i class="fa fa-plus"></i> Add item
					</button>
				</a>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</body>
</html>