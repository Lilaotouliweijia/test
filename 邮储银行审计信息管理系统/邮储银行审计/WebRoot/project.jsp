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
    <tr><th>项目编号</th><th>项目名字</th><th>项目简单描述</th><th>项目审核负责人</th><th>项目状态</th><th>通知结果</th><th>审核状态</th><th colspan="2">操作</th></tr>
    	<s:iterator id="zsk" value="#request.arcList" status="st">
    		<tr>
					<td>${zsk.projectId }</td>
					<td>${zsk.projectName }</td>		
					<td>${zsk.projectContent }</td>
					<td>${zsk.projectAdmin.adminName }</td>
					<td>${zsk.projectState }</td>
					<td>${zsk.projectInfo.state }</td>
					<td>${zsk.ifopr }</td>
					<td><a href="ProjectAll?arcId=${zsk.projectId}">查看明细</a></td>
					<td><a href="ProjectAll?arcId=${zsk.projectId}">删除</a></td>
				</tr>
    	</s:iterator>
    	<tr>
				<td>页面跳转</td>
				<td>
				<!-- 当当前页数大于1时，才会显示 -->
				<s:if test="pager.curPage>1">
					<a href="ProjectAll?pager.curPage=1">首页</a>&nbsp;&nbsp;
					<a href="ProjectAll?pager.curPage=${pager.curPage-1 }">上一页</a>
				</s:if>
				</td>
				<!-- 当当前页数小于总页数时，才会显示 -->
				<td>
				<s:if test="pager.curPage < pager.pageCount">
					<a href="ProjectAll?pager.curPage=${pager.curPage+1}">下一页</a>&nbsp;&nbsp;
					<a href="ProjectAll?pager.curPage=${pager.pageCount }">尾页</a>
				</s:if>
				</td>
				<td>共${pager.rowCount}记录，共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;		
				</td>
				<td colspan="3"><button class="modBtn addBtn">申报项目</button></td>
			</tr>
    </table>
    </div>
  	<div id="mingXi">
		<h2>进一步观察操作</h2>
		<form action="modPro" method="post">
			项目编号：<input type="text" value="${requestScope.arc.projectId }" name="arc.projectId" readOnly="true" style="background: pink"><br><br/>
			项目名字：<input type="text" readOnly="true" style="background: pink" value="${requestScope.arc.projectName }" name="arc.projectName"/><br/><br/>
			项目简单描述：<input type="text" value="${requestScope.arc.projectContent }" name="arc.projectContent" readOnly="true" style="background: pink"><br><br/>
			项目负责人：<input type="text" value="${sessionScope.adminName }" name="arc.projectAdmin.adminName" readOnly="true" style="background: pink"><br><br/>
			审核状态:<input type="text" value="${requestScope.arc.ifopr }" name="arc.ifopr" readOnly="true" style="background: pink" class="proStat"><br><br/>
			通知结果:<input type="text" name="arc.projectInfo.state" value="${requestScope.arc.projectInfo.state }" readOnly="true" style="background: pink" class="infoRes"><br><br/>
			<input type="text" value="${requestScope.arc.shenQingUrl }" name="arc.shenQingUrl" class="hid">
			<input type="submit" class="kaiqiPro" value="开启项目" onclick="return checkInfoRes()">
		</form>
	</div>
	<div class="index2">
		<div class="addMes">
		<form action="addPro" method="post" enctype="multipart/form-data" onSubmit="return ch1();" class="addProd">
			<center>
				<h3>申报项目</h3>
				项目名字：<input type="text" " name="arc.projectName" class="a1"/><br/><br/>
				项目简单描述：<input type="text"  name="arc.projectContent" class="a2"><br><br/>
				项目负责人：<input type="text" value="${sessionScope.adminName }" name="arc.projectAdmin.adminName" readOnly="true" style="background: pink"><br><br/>
				<table>
					<tr><th>应了解事项</th><th>简要介绍</th><th>辅助信息</th><th>实现方式</th><th>上传文件</th></tr>
					<tr>
						<td><input type="text" name="arc.baseEn" placeholder="项目基本情况" class="b1"></td>
						<td><input type="text" name="arc.baseInfo" placeholder="项目整体情况" class="b2"></td>
						<td><input type="text" name="arc.baseFz" placeholder="项目基本辅助信息" class="b3"></td>
						<td><input type="text" name="arc.baseWay" placeholder="基本实现方式" class="b4"></td>
						<td><input type="file" name="proFile1" value="上传excel文件" class="b5"></td>
					</tr>
					<tr>
						<td><input type="text" name="arc.ProEn" placeholder="项目进展情况" class="b6"></td>
						<td><input type="text" name="arc.ProInfo" placeholder="项目进展整体情况" class="b7"></td>
						<td><input type="text" name="arc.ProFz" placeholder="项目进展辅助信息" class="b8"></td>
						<td><input type="text" name="arc.ProWay" placeholder="进展实现方式" class="b9"></td>
						<td><input type="file" name="proFile2" value="上传excel文件" class="b10"></td>
					</tr>
				</table>
				<input type="file" value="上传申报书" name="img" class="a3"><br>
				<input type="submit" value="提        交">&nbsp;&nbsp;
			</center>
			</form>
			<button class="cancel">取 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;消</button>
		</div>
		</div>
		</center>
  </body>
</html>
