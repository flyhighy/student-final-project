<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>基地信息发布系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.right-button01 ,.right-button02{
	cursor:pointer;
}

.errorMessage{
	color:red;
	font-size:14px;
}
-->
</style>
<link href="files/styles/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="files/images/top02.gif"><img src="files/images/top03.png" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="files/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="files/images/line01.gif" width="5" height="292" /></td>
      </tr>
     <form method="post" action="loginTo">
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr><td></td><td width="69%"><s:fielderror fieldName="login" /></td></tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：<br /></td>
        <td width="69%" ><input  name="user.username" type="text" size="22" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input  name="user.password" type="password" size="22" /></td>
      </tr>
    
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button01" value="登陆">
          <input name="Submit232" type="reset" class="right-button02" value="重 置" /></td>
      </tr>
    </table></td>
    </form>
  </tr>
</table>
</body>
</html>