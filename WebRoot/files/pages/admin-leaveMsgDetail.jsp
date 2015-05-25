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
	<style>
		.item{
			padding:10px;
		}
		.item span{
			display:inline-block;
			width:180px;
			text-align:right;
		}
		
		.item textarea{
			  overflow-x: scroll
		}
		
			</style>
</head>
<body>
	<iframe src="admin-header.jsp" marginheight="0"
		hidefocus="true" frameborder="0" scrolling="no"
		allowtransparency="yes" seamless tabindex=""
		style="width: 100%; height:181px;;"></iframe>

	
	<div class="content-wrapper">
<div class="user-msg">
					<div class="item">
						<span>姓名：</span>
						<s:property value='%{#request.message.name}'/>
					</div>
					

					
					<div class="item">
						<span>电话：</span>
						<s:property value='%{#request.message.phone}'/>
					</div>
					
					<div class="item">
						<span>email：</span>
						<s:property value='%{#request.message.email}'/>
					</div>
					
					
					
				
					<div class="item">
						<span>留言内容：</span>
						<s:property value='%{#request.message.content}'/>
					</div>
					
				
					
				</div>
	</div>
</body>
</html>