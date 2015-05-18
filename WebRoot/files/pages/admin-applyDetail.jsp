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
						<s:property value='%{#request.form.name}'/>
					</div>
					
					<div class="item">
						<span>性别：</span>
						<s:property value='%{#request.form.sex}'/>
					</div>
					
					<div class="item">
						<span>学号：</span>
						<s:property value='%{#request.form.studentId}'/>
					</div>
					
					<div class="item">
						<span>电话：</span>
						<s:property value='%{#request.form.phone}'/>
					</div>
					
					<div class="item">
						<span>email：</span>
						<s:property value='%{#request.form.email}'/>
					</div>
					
					
					<div class="item">
						<span>学院/专业：</span>
						<s:property value='%{#request.form.department}'/>
					</div>
					
					<div class="item">
						<span>成绩排名：</span>
						<s:property value='%{#request.form.grade}'/>
					</div>
					
					<div class="item">
						<span>所会编程语言：</span>
						<s:property value='%{#request.form.language}'/>
					</div>
					
					<div class="item">
						<span>专长：</span>
						<s:property value='%{#request.form.specialty}'/>
					</div>
					<div class="item">
						<span>开发经验或参赛经历：</span>
						<s:property value='%{#request.form.experience}'/>
					</div>
					
					<div class="item">
						<span>兴趣爱好：</span>
						<s:property value='%{#request.form.hobby}'/>
					</div>
					
					<div class="item">
						<span>个人评价：</span>
						<s:property value='%{#request.form.inroduction}'/>
					</div>
					
				
					
				</div>
	</div>
</body>
</html>