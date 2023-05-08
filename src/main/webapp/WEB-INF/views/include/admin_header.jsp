<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mobilia 관리자</title>
<link rel="stylesheet" type="text/css" href="./css/admin/admin.css" />
<script src="./js/jquery.js"></script>
<script src="./js/admin/admin.js"></script>
</head>
<body>
	<header>
	<div id="top">
		<div id="logo">mobilia</div>
		<div id="logout"><a href="admin_logout">Logout</a></div>
	</div>
	<div id="cate">
		<ul>
			<li id="cate_li"><a href="#" id="cate_a">회원 관리</a></li>
			<li id="cate_li"><a href="#" id="cate_a">상품 관리</a></li>
			<li id="cate_li"><a href="#" id="cate_a">게시글 관리</a></li>
			<li id="cate_li"><a href="#" id="cate_a">후기 관리</a></li>
			<li id="cate_li"><a href="#" id="cate_a">문의 관리</a></li>
		</ul>
		<input type="hidden" value="${state}"/>
	</div>
	</header>