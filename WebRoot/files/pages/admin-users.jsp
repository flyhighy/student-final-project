<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
    <link rel="stylesheet" href="files/styles/news.css" />
<script src="http://g.tbcdn.cn/kissy/k/1.4.0/seed-min.js" charset="utf-8" data-config="{combine:true}"></script>
<script>
	KISSY.use("core",function(S){
		var body=S.one("body");
		var flag = true;
		var checkAll = true;
		
		body.delegate("click",".checkedmore",function(){
			if(flag){
				body.one(".checkedmore").attr("value","退出操作");
				body.one(".delmore").css("display","block");
				body.one(".head-choose").css("display","inline-block");
				body.all(".choose").css("display","inline-block");
				flag=false;
			}else{
				body.one(".checkedmore").attr("value","批量操作");
				body.one(".delmore").css("display","");
				body.one(".head-choose").css("display","");
				body.all(".choose").css("display","");
				flag=true;
			}
		});
		
		body.delegate("click",".check-all",function(){
			if(checkAll){
				body.all(".choose-box").prop("checked",true);
				checkAll = false;
			}else{
				body.all(".choose-box").prop("checked",false);
				checkAll = true;
			}
		});
		
		body.delegate("click",".del-many",function(){
			document.getElementById("delMany").submit();
		});
	})
</script>

<style>
	.user-item{
		display:inline-block;
		width:100px;
		text-align:center;
	}
	
	.user-name{
		display:inline-block;
		width:50px;
		text-align:center;
	}
	
	.errorMessage{
		color:red;
		font-size:14px;
	}
</style>
</head>
<body>
<iframe src="files/pages/admin-header.jsp" marginheight="0" hidefocus="true" frameborder="0" scrolling="no" allowtransparency="yes" seamless  tabindex="" style="width: 100%; height:181px;;"></iframe>
	<div class="other">
			<input type="text" placeholder="输入关键字">
			<input class="search" type="button" value="搜索">
			<input type="button" value="添加成员" onclick="window.location='addUser'">
			<input type="button" class="checkedmore" value="批量操作">
		</div>
	<div class="content-wrapper">
	    <div class="news-list">
	    	<div class="delmore">
	    	<input class="check-all" type="checkbox"><span>全选</span>
	    	<a href="javascript:void(0)" class="del-many">全部删除</a>
	    	</div>
	    	<s:fielderror fieldName="error" />
	    	<form id="delMany" action="delManyUser" method="post">
	    	<div class="head">
	    		<span class="head-choose">选择</span>
	    		<span class="user-name">姓名</span>
	    		<span class="user-item">用户名</span>
	    		<span class="user-item">密码</span>
	    		<span class="user-item">加入时间</span>
	    		<span class="user-item">成员类型 </span>
<%-- 	    		<span class="head-author">录入人员</span> --%>
	    		<span class="head-op">操作</span>
	    	</div>
	    	<s:iterator value="#request.list" id="ut">
	    	<p class="news-item">
	    		<span  class="choose"><input name="checkOption" class="choose-box" type="checkbox" value="<s:property value='#ut.id'/>"></span>
	    		<a class="user-name" href="userDetail?user.id=<s:property value="#ut.id"/>"><s:property value="#ut.name"/></a> 
	    		<span class="user-username user-item"><s:property value="#ut.username"/></span>
	    		<span class="user-password user-item"><s:property value="#ut.password"/></span>
	    		<span class="user-time user-item"><s:date name='%{#ut.time}' format='yyyy-MM-dd'/></span>
	    		<span class="user-type user-item"><s:property value="%{#ut.type==0?'超级管理员':(#ut.type==1?'管理员':'普通成员')}"/></span>
	    		<span class="operator"><s:a href="editUser?user.id=%{#ut.id}">编辑</s:a>
	    		|
	    		<s:a href="delUser?user.id=%{#ut.id}">删除</s:a></span>
	    		
	    	<%-- 	<span class="author"><s:property value="#ut.author"/></span> --%>
	    	</p>
	    	</s:iterator>
	</form>
	    </div>
	  
	</div>
</body>
</html>