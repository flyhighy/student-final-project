<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>管理员页面</title>
<link rel="stylesheet" href="files/styles/news.css" />
<script src="http://g.tbcdn.cn/kissy/k/1.4.0/seed-min.js"
	charset="utf-8" data-config="{combine:true}"></script>
<script src="files/js/news.js" charset="utf-8"></script>
</head>
<body>
	<iframe src="files/pages/admin-header.jsp" marginheight="0"
		hidefocus="true" frameborder="0" scrolling="no"
		allowtransparency="yes" seamless tabindex=""
		style="width: 100%; height:181px;;"></iframe>

	<div class="other">
			<input type="text" class="J_searchOption search" name="searchOption" placeholder="输入关键字"> <input
				class="search J_search" type="button" value="搜索">
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
					<span class="head-choose">选择</span> <span class="head-title">资讯标题</span>
				<%-- <span class="head-time">时间</span> --%>
				 <span class="head-author">作者</span>
					<span class="head-num">浏览次数</span> <span class="head-op">操作</span>
				</div>
				<div class="J_news">
					<s:fielderror fieldName="error" />
					<%-- <s:iterator value="#request.list" id="ut">
						<p class="news-item">
							<span class="choose"><input name="checkOption"
								class="choose-box" type="checkbox"
								value="<s:property value='#ut.id'/>"></span> <a
								class="news-title"
								href="newsDetail?news.id=<s:property value="#ut.id"/>"><s:property
									value="#ut.title" /></a> <span class="operator"><s:a
									href="editNews?news.id=%{#ut.id}">编辑</s:a>|<s:a
									href="delNews?news.id=%{#ut.id}">删除</s:a></span> <span class="time"><s:date
									name='%{#ut.time}' format='yyyy-MM-dd' /></span> <span class="author"><s:property
									value="#ut.author" /></span> <span class="click-num"><s:property
									value="#ut.number" /></span>
						</p>
					</s:iterator> --%>
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