$(function(){

	setInterval(
		getTime, 1000);
});
function getTime(){
	var time=new Date();
	var year=time.getFullYear();
	var month=time.getMonth();
	var day=time.getDate();
	var hour=time.getHours();
	var minute=time.getMinutes();
	var second=time.getSeconds();
	$(".time").text("当前时间："+year+"年"+(month+1)+"月"+day+"日        "+hour+":"+minute+":"+second);
}