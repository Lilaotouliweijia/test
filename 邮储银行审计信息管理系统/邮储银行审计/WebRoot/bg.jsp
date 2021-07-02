<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>审计主页</title>
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
  <div id="nav">
  	<ul>
  		<li><a href="adminAll">人员管理</a></li>
  		<li><a href="ProjectAll">项目管理</a></li>
  		<li><a href="FangAnAll">方案管理</a></li>
  		<li><a href="zskAll">知识库管理</a></li>
  		<li><a href="InfoAll">通知书管理</a></li>
  		<li><a href="xcAll">现场审计管理</a></li>
  		<li><a href="MeetingAll">会议管理</a></li>
  		<li><a href="bgAll">报告管理</a></li>
  	</ul>
  </div>
		<center>
		<div>
		<table width="1200px">
		<tr><th>审计报告</th><th>审计意见</th><th>审计内容</th>
		<th>审计归档</th><th>查看明细</th><th width="50px">删除</th></tr>
			<s:iterator id="arcItem" value="#request.arcList" status="st">
				<tr>
					<td>${arcItem.reportId }</td>
					<td>${arcItem.suggest }</td>
					<td>${arcItem.content }</td>
					<td>${arcItem.guiDang }</td>]
					<td><a href="bgAll?arcId=${arcItem.reportId }">查看明细</a></td>
					<td><a href="delbg?arcId=${arcItem.reportId }">删除</a></td>
				</tr>
			</s:iterator>
			<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="bgAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="bgAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="bgAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="bgAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
				<td colspan="3"><button class="modBtn addBtn">现场审计</button></td>
			</tr>
		</table>	
		</div>
		<div id="mingXi">
		<h2>明细</h2>
		<form action="modifybg" method="post" )>
			审计报告：<input type="text" class="sj1" value="${requestScope.arc.reportId }" name="arc.reportId" readOnly="true" style="background: pink"><br><br/>
			查看明细：<input type="text" class="sj2" value="${requestScope.arc.suggest }" name="arc.suggest"/><br/><br/>
			审计内容：<input  class="sj3" value="${requestScope.arc.content }" name="arc.content"><br/><br/>
			审计归档：<input type="text" class="sj4" value="${requestScope.arc.guiDang }" name="arc.guiDang" /><br/><br/>
			<input type="submit" value="修改" onclick="return ch4();">
			</form>
		</div>
	</center>
	</div>
	<div class="index2">
		<div class="addMes">
		<form action="addbg" method="post" enctype="multipart/form-data">
			<center>
				<h3>添加报告信息</h3>
			报告建议：<input type="text" class="sj5"  name="arc.suggest"/><br/><br/>
			审计内容：<input  class="sj6"  name="arc.content"><br/><br/>
			审计归档：<input type="text" class="sj7" name="arc.guiDang" /><br/><br/>
			审计意见书:<input type="file" name="img"><br/><br/>
			台账报表:<input type="file" name="img1"><br/><br/>
				<input type="submit" value="提        交" onclick="return ch5();">
			</center>
			</form>
			<button class="cancel">取 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;消</button>
		</div>
	</div>
</body>
</html>