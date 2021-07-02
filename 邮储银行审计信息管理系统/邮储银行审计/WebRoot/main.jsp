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
    <table width="800px">
    <tr><th>知识编号</th><th>知识内容</th><th>知识专题</th><th>出版时间</th><th>作者</th></tr>
    	<s:iterator id="zsk" value="#request.arcList" status="st">
    		<tr>
					<td>${zsk.zhiShiId }</td>
					<td>${zsk.shiShiTitle }</td>		
					<td>${zsk.publishTime }</td>
					<td>${zsk.author }</td>
					<td><a href="zskAll?arcId=${zsk.zhiShiId}">查看明细</a></td>
					<td><a href="delzsk?arcId=${zsk.zhiShiId}">删除</a></td>
				</tr>
    	</s:iterator>
    	<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="zskAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="zskAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="zskAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="zskAll?pager.curPage=${pager.pageCount }">尾页</a>
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
			知识编号：<input type="text" value="${requestScope.arc.zhiShiId }" name="cv.custViewId" readOnly="true" style="background: pink"><br><br/>
			知识专题：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.shiShiTitle }" name="proName"/><br/><br/>
			专题内容：<textarea rows="10" cols="50" style="background: pink" readOnly="true" name="cusName">
				${requestScope.arc.zhishiContent }
			</textarea><br><br>
			出版时间：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.publishTime }" name="userName" /><br/><br/>
			专题作者：<input name="funds" readOnly="true" style="background: pink" value="${requestScope.arc.author }"/><br/><br/>
	</div>
	<div class="index2">
		<div class="addMes">
		<form action="addarc" method="post" onSubmit="return;">
			<center>
				<h3>添加知识专题</h3>
				专题:<input type="text" name="arc.shiShiTitle"/><br><br>
				内容:<input type="text" name="arc.zhishiContent"/><br><br>
				作者：<input type="text" name="arc.author"/><br><br>
				<input type="submit" value="提        交">&nbsp;&nbsp;
			</center>
			</form>
			<button class="cancel">取 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;消</button>
		</div>
		</div>
		</center>
  </body>
</html>
