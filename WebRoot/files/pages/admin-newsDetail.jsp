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
        	overflow:hidden;
        	font-size:14px;
        }
        
       
        
        .title{
        	display:inline-block;
        	width:100%;
        	text-align:center;
        	font-size:18px;
        	color:blue;
        	padding-bottom:10px;
        }
        .news-msg{
        text-align:center;
        }
        
        .item{
        	padding-left:10px;
        }
     
    </style>
    <script>
	    KindEditor.ready(function(K) {
	   	 editor1 = K.create('textarea[name="news.content"]', {
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
		<div class="mynews">
			<span class="title"><s:property value="%{#request.news.title}"/></span>
			<br>
			<div class="news-msg">
				<span class="item">
					<span>作者:</span>
					<s:property value="%{#request.news.author}"/>
				</span>
				<span class="item">
					<span>来源:</span>
					<s:property value="%{#request.news.source}"/>
				</span>
				<span class="item">
					<span>时间:</span>
					<s:date name="%{#request.news.time}" format='yyyy-MM-dd'/>
				</span>
			</div>
			<div><s:property value="%{#request.news.content}" escape="false"/></div>
		</div>
	</div>
</div>
</body>
</html>