<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
        .save,.cancel{
        	margin-top:10px;
        	margin-left:10px;
        	float:right;
        }
        
        .edit{
        	width:717px;
        }
    </style>
    <script>
	    KindEditor.ready(function(K) {
	   	 editor1 = K.create('textarea[name="content1"]', {
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
		<form class="edit" action="" method="post">
			<textarea name="content1" cols="100" rows="8" style="width:717px;height:500px;visibility:hidden;"></textarea>
		    <input class="cancel" type="button" value="取消">
			<input class="save" type="submit" value="保存">
	</form>
	</div>
</div>
</body>
</html>