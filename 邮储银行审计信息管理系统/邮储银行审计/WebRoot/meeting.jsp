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
		<tr><th>会议编号</th><th>会议时间</th><th>会议负责人</th>
		<th>会议地点</th><th>查看明细</th><th width="50px">删除</th></tr>
			<s:iterator id="meetingItem" value="#request.arcList" status="st">
				<tr>
					<td>${meetingItem.meetingId }</td>
					<td>${meetingItem.meetingTime }</td>
					<td>${meetingItem.meetingAdminId }</td>
					<td>${meetingItem.meetingAdress }</td>]
					<td><a href="MeetingAll?arcId=${meetingItem.meetingId }">查看明细</a></td>
					<td><a href="delMeeting?arcId=${meetingItem.meetingId }">删除</a></td>
				</tr>
			</s:iterator>
			<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="MeetingAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="MeetingAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="xcAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="xcAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
				<td colspan="3"><button class="modBtn addBtn">添加会议</button></td>
			</tr>
		</table>	
		</div>
		<div id="mingXi">
		<h2>明细</h2>
		<form action="modifyMeeting" method="post" )>
			会议编号：<input type="text" class="sj1" value="${requestScope.arc.meetingId }" name="arc.meetingId" readOnly="true" style="background: pink"><br><br/>
			会议时间：<input type="text" class="sj2" value="${requestScope.arc.meetingTime }" name="arc.meetingTime"/><br/><br/>
			会议负责人：<input  class="sj3" value="${requestScope.arc.meetingAdminId.adminName }" name="adminName"><br/><br/>
			会议地点：<input type="text" class="sj4" value="${requestScope.arc.meetingAdress }" name="arc.meetingAdress" /><br/><br/>
			<input type="submit" value="修改" onclick="return ch4();">
			</form>
		</div>
	</center>
	</div>
	<div class="index2">
		<div class="addMes">
		<form action="addMeeting" method="post">
			<center>
				<h3>添加会议信息</h3>
				会议时间：<input type="text" class="sj5"  name="arc.meetingTime"/><br/><br/>
			会议负责人：<input  class="sj6"  name="adminName"><br/><br/>
			会议地点：<input type="text" class="sj7" name="arc.meetingAdress" /><br/><br/>
				<input type="submit" value="提        交" onclick="return ch5();">&nbsp;&nbsp;
			</center>
			</form>
			<button class="cancel">取 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;消</button>
		</div>
	</div>
</body>
</html>