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
    <span class="hhadminName">欢迎，${sessionScope.adminName }  <a href="index.jsp">注销</a></span>
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
    <table style="width:1200px">
    <tr><th>通知书编号</th><th>通知书标题</th><th>相关项目</th><th>通知时间</th><th>申请书名字</th><th>通知结果</th></tr>
    	<s:iterator id="zsk" value="#request.arcList" status="st">
    		<tr>
					<td>${zsk.infoId }</td>
					<td>${zsk.infoTitle }</td>
					<td>${zsk.project.projectName }</td>		
					<td>${zsk.infoTime }</td>
					<td>${zsk.forBook }</td>
					<td>${zsk.state }</td>
					<td><a href="InfoAll?arcId=${zsk.infoId}">查看明细</a></td>
					<td><a href="delInfo?arcId=${zsk.infoId}">删除</a></td>
				</tr>
    	</s:iterator>
    	<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="InfoAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="InfoAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="InfoAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="InfoAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
				<td colspan="3"><button class="modBtn addBtn">添加信息</button></td>
			</tr>
    </table>
    </div>
    
    <div id="mingXi">
		<h2>明细</h2>
		<form action="modiInfo" method="post">
		<input value="${requestScope.arc.forBookUrl }" name="arc.forBookUrl" class="hid">
			通知编号：<input type="text" value="${requestScope.arc.infoId }" name="arc.infoId" readOnly="true" style="background: pink"><br><br/>
			通知书标题：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.infoTitle }" name="arc.infoTitle"/><br/><br/>
			通知时间：<input type="text" value="${requestScope.arc.infoTime }" name="arc.infoTime" readOnly="true" style="background: pink"><br><br/>
			申请书名字：<input type="text" value="${requestScope.arc.forBook }" name="arc.forBook" readOnly="true" style="background: pink"><br><br/>
			通知结果：<input type="text" readOnly="true" value="${requestScope.arc.state }" name="arc.state"  style="background: pink"><br><br/>
			<input type="submit" class="modBtn" value="修改">
			</form>
			</div>
	<div class="index2">
		<div class="addInfo">
		<form action="addInfo" method="post" onSubmit="return;" enctype="multipart/form-data">
			<center>
				<h3>添加知识专题</h3>
				通知编号：<input type="text" name="arc.infoId" ><br><br/>
				通知书标题：<input type="text"   name="arc.infoTitle"/><br/><br/>
				<input type="file" value="请上传通知书"  name="InfoFile"><br><br/>
				通知时间：<input type="text"  name="arc.infoTime" ><br><br/>
				申请书名字：<input type="text" name="arc.forBook"  ><br><br/>
				<input type="file" value="请上传申请书" name="ForFile"><br><br/>
				通知结果：<input type="text"  name="arc.state" ><br><br/>
				<input type="submit" value="提        交">&nbsp;&nbsp;
			</center>
			</form>
			<button class="cancel">取 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;消</button>
		</div>
		</div>
	</center>
  </body>
</html>
