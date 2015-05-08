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
        	
        .mynews{
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
        
        #newscontent{
        	display:none;
        }
        
     
    </style>
    <script>
	    KindEditor.ready(function(K) {
	   	 editor1 = K.create('textarea[name="headnews.content"]', {
	   		cssPath : 'kindeditor/plugins/code/prettify.css',
	   		uploadJson : 'kindeditor/jsp/upload_json.jsp',
	   		fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
	   		allowFileManager : true,
	   		afterBlur:function(){this.sync();},
	   		afterCreate : function() {
	   		}
	   	});
	   	 
	     editor2 = K.create('textarea[name="headnews.image"]', {
			   	items : [ 'undo', 'redo', '|', 'image'],
		   		cssPath : 'kindeditor/plugins/code/prettify.css',
		   		uploadJson : 'kindeditor/jsp/upload_json.jsp',
		   		fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
		   		allowFileManager : true,
		   		afterBlur:function(){this.sync();},
		   		afterCreate : function() {
		   		}
		   });
	   	prettyPrint();
	   	var content=document.getElementById("newscontent");
	   	var newsimage=document.getElementById("newsimage");
	   	editor1.html(content.value);
	   	editor2.html(newsimage.value);
	   	content.parentNode.removeChild(content);
	   	newsimage.parentNode.removeChild(newsimage);
	   });
    </script>
</head>
<body>
<iframe src="files/pages/admin-header.jsp" marginheight="0" hidefocus="true" frameborder="0" scrolling="no" allowtransparency="yes" seamless  tabindex="" style="width: 100%; height:181px;;"></iframe>
<div class="content-wrapper">
	<div class="content clearfix">
		<form class="mynews" action="updateHeadnews" method="post">
			<s:hidden value="%{#request.headnews.id}" name="headnews.id"/>
			<s:textfield id="newscontent"  value="%{#request.headnews.content}" />
			<s:textfield id="newsimage"  value="%{#request.headnews.image}" />
			<b>标题</b>
			<br>
			<s:textfield type="text" name="headnews.title" id="title" value="%{#request.headnews.title}"/>
			<br>
			<b>作者</b>
			<br>
			<s:textfield type="text" name="headnews.author" value="%{#request.headnews.author}"/>
			<br>
			<b>来源</b>
			<br> 	
			<s:textfield type="text" name="headnews.source" value="%{#request.headnews.source}"/>
			<br>
			<b>头条图片</b>
			<br>
			<textarea name="headnews.image"  style="width:100px;height:250px;visibility:hidden;"></textarea>
			<br>
			<b>正文</b>
			<br>
			<textarea name="headnews.content" cols="100" rows="8" style="width:717px;height:500px;visibility:hidden;"></textarea>
		    <input class="cancel" type="button" value="取消" onclick="window.history.go(-1)">
			<input class="save" type="submit" value="保存">
		</form>
	</div>
</div>
</body>
</html>