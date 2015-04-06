<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../styles/admin-header.css">
    <link rel="shortcut icon" type="image/ico" href="../images/favicon.ico">
</head>
<body>
<div class="container-wrapper">
    <header>
        <div class="logo"><img class="logo-img" src="../images/admin-head.jpg"> </div>
         <div class="nav">
            <a class="active item" href="../../adminShortdec" target="_parent"><span>基地介绍</span></a>
            <a class="item" href="../../adminNews" target="_parent"><span>咨询快递</span></a>
            <a class="item" href="../../adminMessage" target="_parent"><span>通知公告</span></a>
            <a class="item" href="#" target="_parent"><span>指导团队</span></a>
            <a class="item" href="../../adminCompetition" target="_parent"><span>参赛经历</span></a>
            <a class="item" href="../../adminAchievement" target="_parent"><span>荣誉成果</span></a>
            <a class="item" href="../../adminUser" target="_parent"><span>成员管理</span></a>
            <a class="item" href="#" target="_parent"><span>下载专区</span></a>
            <a class="item" href="#" target="_parent"><span>网上报名</span></a>
            <a class="item" href="#" target="_parent"><sapn>留言评论</sapn></a>
            <span class="user-operation">
<%--            <s:property value="%{#session.user.username}"/> --%>
            </span>
            </div>
        </div>
    </header>
</div>
</body>
</html>