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
 
  
   <div id="left">
  		<div class="t1">
  			<div><span class="ls1">下</span>基本信息管理</div>
  			
  		<ul>
  			<li><a href="adminAll">人员管理</a></li>
  			<li><a href="zskAll">知识库管理</a></li>
  		</ul>
  		</div>
  		
  		<div class="t2">
  			<div><span  class="ls2">下</span>项目信息管理</div>
  			
  		<ul>
  			<li><a href="ProjectAll">项目管理</a></li>
  			<li><a href="FangAnAll">方案管理</a></li>
  			<li><a href="InfoAll">通知书管理</a></li>
  			<li><a href="xcAll">现场审计管理</a></li>
  			<li><a href="bgAll">报告管理</a></li>
  		</ul>
  		
  		</div>
  		<div class="t3">
  			<div><span  class="ls3">下</span>会议信息管理</div>
  		<ul>
  			<li><a href="MeetingAll">会议管理</a></li>
  		</ul>
  		</div>
  </div>
  <div id="right">
  <center>
  <div>
    <table width="800px">
    <tr><th>审计员编号</th><th>审计员用户名</th><th>审计员登录密码</th><th>审计员级别</th><th>操作</th></tr>
    	<s:iterator id="adminl" value="#request.adminL" status="st">
    		<tr>
					<td>${adminl.adminId }</td>
					<td>${adminl.adminName }</td>		
					<td>${adminl.adminPass }</td>
					<td>${adminl.adminType }</td>
					<td><a href="adminAll?aid=${adminl.adminId}">查看明细</a></td>
				</tr>
    	</s:iterator>
    	<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="adminAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="adminAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="adminAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="adminAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
			</tr>
    </table>
    </div>
    
    <div id="mingXi">
		<h2>明细</h2>
		<form action="modifyAdmin">
			审计员编号:<input type="text" style="background:pink" value="${requestScope.adm.adminId}" name="admin.adminId" readOnly="true" ><br><br/>
			审计员用户名:<input type="text" style="background:pink" readOnly="true"  value="${requestScope.adm.adminName }" name="admin.adminName"><br/><br/>
			审计员登录密码:<input type="text"  name="admin.adminPass" value="${requestScope.adm.adminPass }"><br><br>
			审计员级别:<input type="text" style="background:pink" readOnly="true" value="${requestScope.adm.adminType }" name="admin.adminType" ><br/><br/>
			负责的项目:
				<s:iterator id="pl" value="#request.proList" status="st">
					${pl.projectName }、
				</s:iterator>	<br/><br/>	
			<input type="text" name="admin.adminPic" value="${ requestScope.adm.adminPic}" style="display: none;">
	    <input type="submit"  value="修改">
	</form>
	</div>
	</center>
	</div>
  </body>
</html>
