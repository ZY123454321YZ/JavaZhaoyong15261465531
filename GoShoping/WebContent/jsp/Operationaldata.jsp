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
	$.ajax({
		async : false,
		cache : false,
		type : 'post',
		url : "http://localhost:8080/GoShoping/OperationData.do",
		error : function() {
			alert('smx失败 ');
		},
		success : function(data) {
			createShowing(data);
		}
	});
	
})
function createShowing(data) {
	var tableStr = "<table  border='1' id ='table' >"+
	"<tr><td>日期</td><td>在线人数</td><td>在线时长</td><td>登陆时间</td><td>注销时间</td></tr>";
	var dataArray = JSON.parse(data);
    for (var i = 0; i < dataArray.length; i++) 
    {
		tableStr = tableStr + "<tr><td>" + dataArray[i].date + "</td>" + "<td>" +
		dataArray[i].countUser + "</td>"
		+ "<td>" + dataArray[i].countDate + "</td>" + "<td>"
		 +dataArray[i].startDate+"</td>" + 
		"<td>"+dataArray[i].endDate +"</td></tr>";
    }
        tableStr = tableStr + "</table>";
         //将动态生成的table添加的事先隐藏的div中. 
         $("#test").html(tableStr);
     }
    
    function exportData()
    {   
    	var key = document.getElementById("export").value;
    	$.ajax({
    		async : false,
    		cache : false,
    		type : 'post',
    		url : "http://localhost:8080/GoShoping/ExportData.do?",
    		error : function() {
    			alert('smx失败 ');
    		},
    		success : function(data) {
    			alert('smx成功 ');
    			alert(data);
    		}
    	});
	}
</script>
<title>运营数据</title>
</head>
<body>
	<div id="test"></div>
	<div>
	<form action='../ExportData.do' method="post" >      
	 导出数据：<br/>
         导出数据文件：<input type="text" name="file"><br/>
     <input type="submit" value="提交">
     </form>
	</div>
</body>
</html>