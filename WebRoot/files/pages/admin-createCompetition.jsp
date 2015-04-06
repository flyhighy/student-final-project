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
        
     
    </style>
    <script>
	    KindEditor.ready(function(K) {
	   	 editor1 = K.create('textarea[name="competition.content"]', {
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
		<form class="news" action="saveCompetition" method="post">
			<b>标题</b>
			<br>
			<input type="text" name="competition.name" id="title">
			<br>
			<b>发布者</b>
			<br>
			<s:textfield type="text" name="competition.author" value="%{#session.user.name}"/>
			<br>
			<b>参赛时间</b>
			<br>
			<input type="date" name="competition.time" >
			<br>
			<b>正文</b>
			<textarea name="competition.content" cols="100" rows="8" style="width:717px;height:500px;visibility:hidden;"></textarea>
		    <input class="cancel" type="button" value="取消" onclick="window.history.go(-1)">
			<input class="save" type="submit" value="保存">
		</form>
	</div>
</div>
</body>
</html>