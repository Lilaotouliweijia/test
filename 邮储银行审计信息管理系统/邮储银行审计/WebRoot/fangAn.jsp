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
    <table width="800px">
    <tr><th>方案编号</th><th>单位名称</th><th>相关项目</th><th>审计依据</th><th>审计内容</th><th>结果</th><th colspan="2">操作</th></tr>
    	<s:iterator id="zsk" value="#request.arcList" status="st">
    		<tr>
					<td>${zsk.fangAnId }</td>
					<td>${zsk.danWeiName }</td>		
					<td>${zsk.projectId.projectName }</td>
					<td>${zsk.shenJiYiJu }</td>
					<td>${zsk.fangAnContent }</td>
					<td>${zsk.res }</td>
					<td><a href="FangAnAll?arcId=${zsk.fangAnId}">查看明细</a></td>
					<td><button class="sm">修改</button></td>
					<td><a href="FangAnAll?arcId=${zsk.fangAnId}">删除</a></td>
				</tr>
    	</s:iterator>
    	<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="FangAnAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="FangAnAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="FangAnAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="FangAnAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
			</tr>
    </table>
    </div>
  	<div id="mingXi">
		<h2>明细</h2>
			方案编号：<input type="text" value="${requestScope.arc.fangAnId }" name="arc.infoId" readOnly="true" style="background: pink"><br><br/>
			单位名称：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.danWeiName }" name="arc.infoTitle"/><br/><br/>
			相关项目：<input type="text" value="${requestScope.arc.projectId.projectName }" name="arc.infoTime" readOnly="true" style="background: pink"><br><br/>
			审计依据：<input type="text" value="${requestScope.arc.shenJiYiJu }" name="arc.forBook" readOnly="true" style="background: pink"><br><br/>
			审计内容：<input type="text" value="${requestScope.arc.fangAnContent }" name="arc.state"  style="background: pink" readOnly="true"><br><br/>
			方案结果:<input type="text" value="${requestScope.arc.res }" name="arc.state"  style="background: pink" readOnly="true" class="fangAnRes"><br><br/>
			<button class="goShenHe">开启现场审核</button>
	</div>
	<div id="modFa">
		<h2>修改</h2>
		<form action="modifyFangAn">
			方案编号：<input type="text" value="${requestScope.arc.fangAnId }" name="arc.infoId" readOnly="true" style="background: pink"><br><br/>
			单位名称：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.danWeiName }" name="arc.infoTitle"/><br/><br/>
			相关项目：<input type="text" value="${requestScope.arc.projectId.projectName }" name="arc.infoTime" readOnly="true" style="background: pink"><br><br/>
			审计依据：<input type="text" value="${requestScope.arc.shenJiYiJu }" name="arc.forBook" readOnly="true" style="background: pink"><br><br/>
			审计内容：<input type="text" value="${requestScope.arc.fangAnContent }" name="arc.state"  style="background: pink" readOnly="true"><br><br/>
			方案结果:<input type="text" value="${requestScope.arc.res }" name="arc.state"  style="background: pink" readOnly="true" class="fangAnRes"><br><br/>
			<button class="goShenHe">修改</button>
		</form>
	</div>
	</center>
  </body>
</html>
