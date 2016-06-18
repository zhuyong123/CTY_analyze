<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
        body { font-family:Lucida Sans, Lucida Sans Unicode, Arial, Sans-Serif; font-size:13px; margin:0px auto;}
        #tabs { margin:0; padding:0; list-style:none; overflow:hidden; }
        #tabs li { float:left; display:block; padding:5px; background-color:#bbb; margin-right:5px;}
        #tabs li a { color:#fff; text-decoration:none; }
        #tabs li.current { background-color:#e1e1e1;}
        #tabs li.current a { color:#000; text-decoration:none; }
        #tabs li a.remove { color:#f00; margin-left:10px;}
        #content { background-color:#e1e1e1;}
        #content p { margin: 0; padding:20px 20px 100px 20px;}
        
        #main { width:900px; margin:0px auto; overflow:hidden;background-color:#F6F6F6; margin-top:20px;
             -moz-border-radius:10px;  -webkit-border-radius:10px; padding:30px;}
        #wrapper, #doclist { float:left; margin:0 20px 0 0;}
        #doclist { width:150px; border-right:solid 1px #dcdcdc;}
        #doclist ul { margin:0; list-style:none;}
        #doclist li { margin:10px 0; padding:0;}
        #documents { margin:0; padding:0;}
        
        #wrapper { width:700px; margin-top:20px;}
            
        #header{ background-color:#F6F6F6; width:900px; margin:0px auto; margin-top:20px;
             -moz-border-radius:10px;  -webkit-border-radius:10px; padding:30px; position:relative;}
        #header h2 {font-size:16px; font-weight:normal; margin:0px; padding:0px;}

    </style>
  <script type="text/javascript" src="jquery-1.4.min.js" ></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#documents a").click(function() {
                addTab($(this));
            });

            $('#tabs a.tab').live('click', function() {
                // Get the tab name
                var contentname = $(this).attr("id") + "_content";

                // hide all other tabs
                $("#content p").hide();
                $("#tabs li").removeClass("current");

                // show current tab
                $("#" + contentname).show();
                $(this).parent().addClass("current");
            });

            $('#tabs a.remove').live('click', function() {
                // Get the tab name
                var tabid = $(this).parent().find(".tab").attr("id");

                // remove tab and related content
                var contentname = tabid + "_content";
                $("#" + contentname).remove();
                $(this).parent().remove();

                // if there is no current tab and if there are still tabs left, show the first one
                if ($("#tabs li.current").length == 0 && $("#tabs li").length > 0) {

                    // find the first tab    
                    var firsttab = $("#tabs li:first-child");
                    firsttab.addClass("current");

                    // get its link name and show related content
                    var firsttabid = $(firsttab).find("a.tab").attr("id");
                    $("#" + firsttabid + "_content").show();
                }
            });
        });
        function addTab(link) {
            // If tab already exist in the list, return
            if ($("#" + $(link).attr("rel")).length != 0)
                return;
            
            // hide other tabs
            $("#tabs li").removeClass("current");
            $("#content p").hide();
            
            // add new tab and related content
            $("#tabs").append("<li class='current'><a class='tab' id='" +
                $(link).attr("rel") + "' href='#'>" + $(link).html() + 
                "</a><a href='#' class='remove'>x</a></li>");

            $("#content").append("<p id='" + $(link).attr("rel") + "_content'>" + 
                $(link).attr("title") + "</p>");
            
            // set the newly added tab as current
            $("#" + $(link).attr("rel") + "_content").show();
        }
    </script>
  
</head>
<body class="hold-transition skin-blue sidebar-mini">
<header class="main-header"><!--头部  -->
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4 数量</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages  底部</a></li>
            </ul>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          <li class="dropdown tasks-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Alexander Pierce</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  
  <aside class="main-sidebar"><!--左边菜单  -->
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
<!--登录用户信息       <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div> -->
      
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION 导航</li>
        
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="index.html" target="menuFrame"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
          </ul>
        </li>
         <li class="treeview">
	          <a href="#">
	            <i class="fa fa-files-o"></i>
	            <span class="label label-primary pull-right">4</span>
	          </a>
	          <ul class="treeview-menu">
	            <li><a href="pages/layout/top-nav.html" target="menuFrame"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
	            <li><a href="pages/layout/boxed.html" target="menuFrame"><i class="fa fa-circle-o"></i> Boxed</a></li>
	            <li><a href="pages/layout/fixed.html" target="menuFrame"><i class="fa fa-circle-o"></i> Fixed</a></li>
	          </ul>
	        </li>
        <c:forEach items="${list }" var="l">
	        <li class="treeview">
	          <a href="#">
	            <i class="fa fa-files-o"></i>
	            <span>${l }</span>
	            <span class="label label-primary pull-right">4</span>
	          </a>
	          <ul class="treeview-menu">
	            <li><a href="pages/layout/top-nav.html" target="menuFrame"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
	            <li><a href="pages/layout/boxed.html" target="menuFrame"><i class="fa fa-circle-o"></i> Boxed</a></li>
	            <li><a href="pages/layout/fixed.html" target="menuFrame"><i class="fa fa-circle-o"></i> Fixed</a></li>
	          </ul>
	        </li>
        </c:forEach>
       
    </section>
    <!-- /.sidebar -->
  </aside>
	<div class="content-wrapper">
		  <section class="content" height="800">
		
		  	<iframe id="menuFrame" name="menuFrame" src="http://114.55.141.110:8080/" style="overflow:visible;" scrolling="yes" frameborder="no" height="800" width="100%">
		  		  <div id="wrapper">
				        <ul id="tabs">
				            <!-- Tabs go here -->
				        </ul>
				        <div id="content">
				            <!-- Tab content goes here -->
				        </div>
				
				   </div>
				   <div id="main">
					    <div id="doclist">
					        <h2>Documents</h2>
				
					        <ul id="documents">
					            <li><a href="#" rel="Document1" title="This is the content of Document1">Document1</a></li>
					            <li><a href="#" rel="Document2" title="This is the content of Document2">Document2</a></li>
					            <li><a href="#" rel="Document3" title="This is the content of Document3">Document3</a></li>
					            <li><a href="#" rel="Document4" title="This is the content of Document4">Document4</a></li>
					            <li><a href="#" rel="Document5" title="This is the content of Document5">Document5</a></li>
				
					        </ul>
					    </div>
					    <div id="wrapper">
					        <ul id="tabs">
					            <!-- Tabs go here -->
					        </ul>
					        <div id="content">
					            <!-- Tab content goes here -->
					        </div>
				
					    </div>
				  	</div>
		  
		  	</iframe>
		  </section>
	</div>
 <div class="overlay">
  <i class="fa fa-refresh fa-spin"></i>
</div>
<%--   <%@ include file="biaoge.jsp" %> --%>
<!-- ./wrapper -->

<!-- jQuery 2.2.0 -->
<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
</body>
</html>
