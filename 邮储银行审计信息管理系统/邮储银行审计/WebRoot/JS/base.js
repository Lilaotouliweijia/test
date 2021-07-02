$(function(){
	//用ajax登录
	$(".logBtn").click(function(){
		var checkName=$(".nameContent").val();
		var checkPass=$(".passContent").val();
		if(checkName==""||checkPass==""){
			alert("用户名或密码出错不能为空！");
			return false;
		}else{
			$.ajax({
				data:{
					'adminName':checkName,
					'adminPass':checkPass
				},
				type:"post",
				dataType:"json",
				url:"login",
				error:function(data){
					alert("连接失败");
				},
				success:function(data){
					if(data.flag==true){
						alert("登录成功");
						window.location.href="adminAll";
					}else{
						alert("用户名或者密码出错！");
					}
				}
			});
		}
	});
	//注册时验证用户名是否被注册
	$(".regN").blur(function(){
		var regN=$(this).val();
		if(regN==""){
			alert("用户名不能为空");
		}else{
			$.ajax({
				data:{
					'adminName':regN,
				},
				type:"post",
				dataType:"json",
				url:"checkRegName",
				error:function(data){
					alert("连接失败");
				},
				success:function(data){
					if(data.flag==true){
						$(".wo").html("用户名已存在，请重填！");
					}else{
						$(".wo").html("恭喜你，用户名可用！");
					}
				}
			});
		}
	});
	$(".sm").click(function(){
		var adminNa=$(".aaa").html();
		if(adminNa=="admin"){
			window.location.href="FangAnAll?arcId=${zsk.fangAnId}";
			$("#modFa").css("display","block");
		}else{
			alert("你不是审核会议小组负责人，无权进行修改！");
		}
	});
	$(".regN").focus(function(){
		$(".wo").html("");
	});
	$(".addBtn").click(function(){
		var adminNa=$(".aaa").html();
		if(adminNa=="admin"){
			alert("你不是项目负责人，无权限！");
		}
		else{
			$(".index2").css("display","block");
		}
	});
	$(".cancel").click(function(){
		$(".index2").css("display","none");
	});
	
	$(".goShenHe").click(function(){
		var faRes=$(".fangAnRes").val();
		if(faRes=="不通过"){
			alert("方案未经过小组审核通过，不能开启项目，请修改方案！");
		}else{
			window.location.href="project.jsp";
		}
	});
	//设置有admin才能编辑的权限
	
	$(".proStat").click(function(){
		var adminNa=$(".aaa").html();
		var s=$(".proStat").val();
		if(adminNa!="admin"){
			alert("您不是审核小组负责人，无权限修改！");
		}else if(s=="已审"){
			alert("审核过的项目不能更改！");
		}else{
			$(".proStat").attr("readOnly",false).css("background","#fff");
			$(".infoRes").attr("readOnly",false).css("background","#fff");
		}
	});
	$(".back").click(function(){
		window.location.href="FangAnAll";
	});
	
	$(".ls1").click(function(){
		var ls1Value=$(".ls1").html();
		if(ls1Value=="上"){
			$(".ls1").html("下");
			$(".t1 ul").css("display","block");
		}else if(ls1Value=="下"){
			$(".t1 ul").css("display","none");
			$(".ls1").html("上");
		}
	});
	
	$(".ls2").click(function(){
		var ls1Value=$(".ls2").html();
		if(ls1Value=="上"){
			$(".ls2").html("下");
			$(".t2 ul").css("display","block");
		}else if(ls1Value=="下"){
			$(".t2 ul").css("display","none");
			$(".ls2").html("上");
		}
	});
	$(".ls3").click(function(){
		var ls1Value=$(".ls3").html();
		if(ls1Value=="上"){
			$(".ls3").html("下");
			$(".t3 ul").css("display","block");
		}else if(ls1Value=="下"){
			$(".t3 ul").css("display","none");
			$(".ls3").html("上");
		}
	});
});
//验证注册表单填写的内容
function checkReg(){
	var woValue=$(".wo").html();
	var abc=$(".regI").val();
	var adminN=$(".regN").val();
	var adminP=$(".regP").val();
	//判重
	if(woValue=="用户名已存在，请重填！"){
		alert("用户名已经被注册，请重填！");
		return false;
		//判空
	}else if(abc==""||adminN==""||adminP==""){
		alert("所有信息必须填！");
		return false;
	}else{
		alert("注册成功！请登录。");
		return true;
	}
}
//验证审核结果
function checkInfoRes(){
	var adminNa=$(".aaa").html();
	if($(".infoRes").val()=="未通过"){
		alert("项目未通过审核，不能开启！");
		return false;
	}else if(adminNa=="admin"){
		alert("请让项目申报者开启！");
		return false;
	}else{
		return true;
	}
}
function ch1(){
	if($(".a1").val()==""||$(".a2").val()==""||$(".a3").val()==""||$(".b1").val()==""||$(".b2").val()==""||$(".b3").val()==""||$(".b4").val()==""||$(".b5").val()==""||$(".b6").val()==""||$(".b7").val()==""||$(".b8").val()==""||$(".b9").val()==""||$(".b10").val()==""){
		alert("所有项必须填！");
		return false;
	}else{
		alert("添加成功！");
		return true;
	}
}
function ch3(){
	if($(".af1").val()==""||$(".af2").val()==""||$(".af3").val()==""||$(".af4").val()==""||$(".af5").val()==""||$(".af6").val()==""||$(".af7").val()==""){
		alert("所有项必须填！");
		return false;
	}else{
		alert("添加成功！");
		return true;
	}
}
function ch4(){
	if($(".sj1").val()==""||$(".sj2").val()==""||$(".sj3").val()==""||$(".sj4").val()==""){
		alert("所有项必须填！");
		return false;
	}else{
		return true;
	}
}
function ch5(){
	if($(".sj5").val()==""||$(".sj6").val()==""||$(".sj7").val()==""||$(".sj8").val()==""){
		alert("所有项必须填！");
		return false;
	}else{
		return true;
	}
}