<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/goshopping.css" /> 
<script type="text/javascript" src="../jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script>
$(function(){
    //这里就是放页面加载的时候执行的函数。
	$.ajax({
		async : false,
		cache : false,
		type : 'post',
		url : "http://localhost:8080/GoShoping/QueryUser.do",
		error : function() {
			alert('smx失败 ');
		},
		success : function(data) {
			alert('smx成功');
			createShowing(data);
		}
	});
})
	function createShowing(data) {
		//获取后台传过来的jsonData,并进行解析  
		alert("------->进入当前的数据展现");
		var table = '';
		var dataArray = JSON.parse(data);
		//此处需要让其动态的生成一个table并填充数据  
		var tableStr = "<table class = 'demo' width='100%' border='1' cellpadding='2' cellspacing='2'>";
		tableStr = tableStr
				+ "<thead><td>ID</td><td>姓名</td><td>性别</td></thead>";
		var len = dataArray.length;
		if (len >= 10) {
			len = 10;
		}
		for (var i = 0; i < len; i++) {
			tableStr = tableStr + "<tr><td>" + dataArray[i].id + "</td>"
					+ "<td>" + dataArray[i].name + "</td>" + "<td>"
					+ dataArray[i].sex + "</td></tr>";
		}
		tableStr = tableStr + "</table>";
		//将动态生成的table添加的事先隐藏的div中.  
		$("#dataTable").html(tableStr);
	}
</script>
<title>管理界面</title>
</head>
<body >
<div id = "dataTable"></div>
</body>
</html>