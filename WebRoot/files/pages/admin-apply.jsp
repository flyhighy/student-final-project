<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>管理员页面</title>
<link rel="stylesheet" href="../styles/news.css" />
<script src="http://g.tbcdn.cn/kissy/k/1.4.0/seed-min.js"
	charset="utf-8" data-config="{combine:true}"></script>
<script src="../js/admin-apply.js" charset="utf-8"></script>
</head>
<body>
	<iframe src="admin-header.jsp" marginheight="0"
		hidefocus="true" frameborder="0" scrolling="no"
		allowtransparency="yes" seamless tabindex=""
		style="width: 100%; height:181px;;"></iframe>

	
	<div class="other">
			<input type="button" value="添加资讯"
				onclick="window.location='createNews'"> 
			<input type="button"
				class="checkedmore" value="批量操作">
	</div>
	<div class="content-wrapper">
		<div class="news-list">
			<div class="delmore">
				<input class="check-all" type="checkbox"><span>全选</span> <a
					href="javascript:void(0)" class="del-many">全部删除</a>
			</div>
			<form id="delMany" action="delMany" method="post">
				<div class="head">
					<span class="head-choose">选择</span> <span class="head-title">申请人</span>
				<%--  <span class="head-author">学院</span> --%>
					<span class="head-num">申请时间</span> <span class="head-op">操作</span>
				</div>
				<div class="J_apply">
				</div>
			</form>
			<div class="pages">
				<a href="#">< Prev</a>
				<a  href="#">1</a>
				<a href="#">Next ></a>
			</div>
		</div>

	</div>
</body>
</html>