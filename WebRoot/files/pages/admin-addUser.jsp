<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
    <link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<link rel="stylesheet" href="files/styles/index.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
    <style>
        .content-wrapper{
            width: 1000px;
            margin: auto;
            font-family:"Microsoft YaHei",simsun;
            border:1px solid #ccc;
            border-radius:3px;
        }
        
        .content{
       	 padding:20px;
        }
        	
        .news{
        	width:717px;
        }
        
        #title{
        	width:100%;
        }
        .save,.cancel{
        	margin-top:10px;
        	margin-left:10px;
        	float:right;
        }
        
        .edit{
        	width:717px;
        }
        b{
        	font-size:14px;
        }
        
        .source{
        	margin-bottom:5px;
        }
        
        .msg{
        	color:blue;
        	font-size:14px;
        }
        
     
    </style>
    <script>
	    KindEditor.ready(function(K) {
	   	 editor1 = K.create('textarea[name="user.shortdec"]', {
	   		cssPath : 'kindeditor/plugins/code/prettify.css',
	   		uploadJson : 'kindeditor/jsp/upload_json.jsp',
	   		fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
	   		allowFileManager : true,
	   		afterBlur:function(){this.sync();},
	   		afterCreate : function() {
	   		}
	   	});
	   	prettyPrint();
	   });
    </script>
</head>
<body>
<iframe src="files/pages/admin-header.jsp" marginheight="0" hidefocus="true" frameborder="0" scrolling="no" allowtransparency="yes" seamless  tabindex="" style="width: 100%; height:181px;;"></iframe>
<div class="content-wrapper">
	<div class="content clearfix">
		<form class="news" action="saveUser" method="post">
			<b>姓名</b>
			<br>
			<input type="text" name="user.name">
			<br>
			<b>用户名</b>
			<br>
			<input type="text" name="user.username">
			<br>
			<b>密码</b>
			<br>
			<input type="text" name="user.password">
			<br>
			<b>成员类型</b>
			<br>
			<select name="user.type" style="width:80px;">
				<option value="2">普通成员
				</option>
				<option value="1">管理员
				</option>
				<option value="0">超级管理员
				</option>
	
			
			</select>
			<br>
			<b>加入时间</b>
			<br>
			<input type="date" name="user.time" >
			<span class="msg">默认为当前时间</span>
			<br>
			<b>成员简介</b>
			<textarea name="user.shortdec" cols="100" rows="8" style="width:717px;height:500px;visibility:hidden;"></textarea>
		    <input class="cancel" type="button" value="取消" onclick="window.history.go(-1)">
			<input class="save" type="submit" value="保存">
		</form>
	</div>
</div>
</body>
</html>