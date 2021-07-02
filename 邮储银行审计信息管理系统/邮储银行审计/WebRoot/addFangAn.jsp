<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>填写项目方案</title>
<link rel="stylesheet" type="text/css" href="CSS/base.css"/>
	<script type="text/javascript" src="JS/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="JS/base.js"></script>
	<script type="text/javascript" src="JS/Time.js"></script>
</head>
<body>
<div id="hh">
  <span class="hhLog">阳光审计</span>
  	<div class=time></div>
    <img src="${sessionScope.pic }">
    <span class="hhadminName">欢迎，<div class="aaa">${sessionScope.adminName }</div>  <a href="index.jsp">注销</a></span>
  </div>
	<center>
	<h1>提交审计方案</h1>
	<form action="addFaa" method="post" enctype="multipart/form-data">
	单位名称:<input type="text" name="arc.danWeiName" class="af1"><br><br>
	相关项目:<input type="text"  class="af2" value="${sessionScope.Proarc.projectName }"><br><br>
	审计依据：<input type="text" name="arc.shenJiYiJu" class="af3"><br><br>
	开始时间：<input type="text" name="arc.startTime" class="af4"><br><br>
	结束时间：<input type="text" name="arc.endTime" class="af5"><br><br>
	审计内容：<input type="text" name="arc.fangAnContent" class="af6"><br><br>
	审计清单：<input type="file" name="img" class="af7"><br><br>
	<input type="submit" onclick="return ch3();" value="提交">
	</form><button class="back">返回方案页</button>
	</center>
</body>
</html>