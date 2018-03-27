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
function help() {
	window.location.href = "../Help.do?"+Math.random();
}
</script>
<title>帮助中心</title>
</head>
<body>
<div>
<p  class="pp">帮助中心</p>
<button class="kefu"  onclick="help();">点击人工客服</button>
</div>
</body>
</html>