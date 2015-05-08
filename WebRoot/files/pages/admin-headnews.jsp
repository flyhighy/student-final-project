<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>管理员页面</title>
<link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
<link rel="stylesheet" href="files/styles/news.css" />
</head>
<body>
	<iframe src="files/pages/admin-header.jsp" marginheight="0"
		hidefocus="true" frameborder="0" scrolling="no"
		allowtransparency="yes" seamless tabindex=""
		style="width: 100%; height:181px;;"></iframe>

	<div class="other">
			<input type="button" value="添加头条"
				onclick="window.location='createHeadnews'"> 
	</div>

	<div class="content-wrapper">
		<div class="news-list">
			<form id="delMany" action="delMany" method="post">
				<div class="head">
					<span class="head-choose">选择</span> <span class="head-title">资讯标题</span>
				<%-- <span class="head-time">时间</span> --%>
				 <span class="head-author">作者</span>
					<span class="head-num">浏览次数</span> <span class="head-op">操作</span>
				</div>
				<div class="J_news">
						<s:iterator value="#request.list" id="ut">
						<p class="news-item">
							<span class="choose"><input name="checkOption"
								class="choose-box" type="checkbox"
								value="<s:property value='#ut.id'/>"></span> <a
								class="news-title"
								href="newsDetail?news.id=<s:property value="#ut.id"/>"><s:property
									value="#ut.title" /></a> <span class="operator"><s:a
									href="editHeadnews?headnews.id=%{#ut.id}">编辑</s:a>|<s:a
									href="delHeadnews?headnews.id=%{#ut.id}">删除</s:a></span> <span class="time"><s:date
									name='%{#ut.time}' format='yyyy-MM-dd' /></span> <span class="author"><s:property
									value="#ut.author" /></span> <span class="click-num"><s:property
									value="#ut.number" /></span>
						</p>
					</s:iterator>
				</div>
			</form>
		</div>

	</div>
</body>
</html>