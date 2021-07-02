<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>阳光审计</title>
    <link rel="stylesheet" type="text/css" href="CSS/base.css"/>
	<script type="text/javascript" src="JS/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="JS/base.js"></script>
  </head>
  <body>
    <s:div id="login">
    	<s:div class="header"></s:div>
    	<s:div class="content">
    		<s:div class="logo">阳&nbsp;光&nbsp;审&nbsp;计</s:div>
    		<s:div class="login">
    			<s:div class="title">阳光审计系统</s:div>
    			<s:form action="reg" method="post" enctype="multipart/form-data" >
    			<s:div class="admin"><s:div class="anPic"></s:div><s:textfield name="admin.adminName"  class="regN"></s:textfield><s:div class="wo"></s:div></s:div>
    			<s:div class="admin"><s:div class="apPic"></s:div><s:textfield name="admin.adminPass"  class="regP"></s:textfield></s:div>
    			<s:div class="admin"><s:div class="anJB" >员工级别</s:div>
    			<s:select class="regT" list="#{'普通员工':'普通员工','项目审计员':'项目审计员','会议组长':'会议组长'}" listKey="key" listValue="value" name="admin.adminType"
		 value="admin.adminType"></s:select></s:div>
    			<s:div class="admin"><div class="apIco">上传头像</s:div>
    			<s:file  name="img" class="regI"></s:file>
    			<s:submit value="注    册" onclick="return checkReg()" class="wo"></s:submit>
    			<a href="index.jsp" class="regA">登录</a>
    				</s:form>
    		</s:div>
    	</s:div>
    </s:div>
  </body>
</html>
