<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
    <style>
        .content-wrapper{
            width: 1000px;
            margin: auto;
        }
     .edit{
         white-space: nowrap;
     }
     .content{
         width: 700px;
         padding: 20px;
         font-size: 14px;
         line-height: 24px;
         word-wrap: break-word;
         word-break: break-all;
         overflow:hidden;

     }

        .short-dec{
            border: #ccc solid 1px;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<iframe src="files/pages/admin-header.jsp" marginheight="0" hidefocus="true" frameborder="0" scrolling="no" allowtransparency="yes" seamless  tabindex="" style="width: 100%; height:181px;;"></iframe>
<div class="content-wrapper">
    <div class="short-dec">
        <div class="content">
        <s:property value="%{#request.shortdec.shortdec}" escape="false"/>
        <a class="edit" href="editShortdec">编辑>></a>
        </div>
    </div>
</div>
</body>
</html>