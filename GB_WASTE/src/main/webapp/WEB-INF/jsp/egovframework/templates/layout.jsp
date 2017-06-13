<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="" />
	<meta name="author" content="" />

	<link rel="icon" href="/assets/images/favicon.ico">

	<title>대형폐기물 처리</title>

	<link rel="stylesheet" href="/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
	<link rel="stylesheet" href="/assets/css/font-icons/entypo/css/entypo.css">
	<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic">
	<link rel="stylesheet" href="/assets/css/bootstrap.css">
	<link rel="stylesheet" href="/assets/css/neon-core.css">
	<link rel="stylesheet" href="/assets/css/neon-theme.css">
	<link rel="stylesheet" href="/assets/css/neon-forms.css">
	<link rel="stylesheet" href="/assets/css/custom.css">

	<script src="/assets/js/jquery-1.11.3.min.js"></script>

	<!--[if lt IE 9]><script src="/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


</head>
<body class="page-body" data-url="http://neon.dev">

<div class="page-container horizontal-menu with-sidebar">

	<header class="navbar navbar-fixed-top"><!-- set fixed position by adding class "navbar-fixed-top" -->
		<div class="navbar-inner">
			<!-- Header -->
			<tiles:insertAttribute name="header" />
		</div>
	</header>
	
	<div class="sidebar-menu">
		<div class="sidebar-menu-inner">
			<!-- Left -->
			<tiles:insertAttribute name="left" />		
		</div>
	</div>
		
	<div class="main-content">
		<!-- Content -->
		<tiles:insertAttribute name="content" />
		<!-- Footer -->
		<tiles:insertAttribute name="footer" />
	</div>
</div>

<!-- Imported styles on this page -->
<link rel="stylesheet" href="/assets/js/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="/assets/js/rickshaw/rickshaw.min.css">

<!-- Bottom scripts (common) -->
<script src="/assets/js/gsap/TweenMax.min.js"></script>
<script src="/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script src="/assets/js/joinable.js"></script>
<script src="/assets/js/resizeable.js"></script>
<script src="/assets/js/neon-api.js"></script>
<script src="/assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/assets/js/jvectormap/jquery-jvectormap-europe-merc-en.js"></script>
<script src="/assets/js/jquery.sparkline.min.js"></script>
<script src="/assets/js/rickshaw/vendor/d3.v3.js"></script>
<script src="/assets/js/rickshaw/rickshaw.min.js"></script>
<script src="/assets/js/raphael-min.js"></script>
<script src="/assets/js/morris.min.js"></script>
<script src="/assets/js/toastr.js"></script>


<!-- JavaScripts initializations and stuff -->
<script src="/assets/js/neon-custom.js"></script>


<!-- Demo Settings -->
<script src="/assets/js/neon-demo.js"></script>

</body>
</html>
