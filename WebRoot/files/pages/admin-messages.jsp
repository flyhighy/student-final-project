<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
    <link rel="stylesheet" href="files/styles/news.css" />
</head>
<body>
<iframe src="files/pages/admin-header.jsp" marginheight="0" hidefocus="true" frameborder="0" scrolling="no" allowtransparency="yes" seamless  tabindex="" style="width: 100%; height:181px;;"></iframe>
	<div class="other">
			<input type="text" placeholder="输入关键字">
			<input class="search" type="button" value="搜索">
			<input type="button" value="发布通知" onclick="window.location='createMessage'">
		</div>
	<div class="content-wrapper">
	    <div class="news-list">
	    	<div class="head">
	    		<span class="head-choose">选择</span>
	    		<span class="head-title">通知标题</span>
	    		<span class="head-time">时间</span>
	    		<span class="head-author">发布者</span>
	    		<span class="head-op">操作</span>
	    	</div>
	    	<p class="news-item">
	    		<span  class="choose"><input type="checkbox"></span>
	    		<a class="news-title" href="#">西工大足球机器人取得新高</a> 
	    		<span class="operator"><a href="#">编辑</a>|<a href="#">删除</a></span>
	    		<span class="time">2015-3-26</span>
	    		<span class="author">rose</span>
	    	</p>
	    	<p class="news-item">
	    		<span  class="choose"><input type="checkbox"></span>
	    		<a class="news-title" href="#">西工大足球机器人取得新高</a> 
	    		<span class="operator"><a href="#">编辑</a>|<a href="#">删除</a></span>
	    		<span class="time">2015-3-26</span>
	    		<span class="author">rose</span>
	    	</p>

	    </div>
	</div>
</body>
</html>