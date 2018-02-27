<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate() 
{
	var username = document.forms[0].username.value;
	var password = document.forms[0].password.value;
	if (username.length<=0) 
	{
		alert("用户名不能为空!");
	}
	else if 
	(password <=0) 
	{
		alert("密码不能为空!");
	}
}
</script>
<title>现金贷</title>
</head>
<body>
<body>
<div align="left" >
<form action="../login.do" method="post">
 <span style="position:relative;font-family: 黑体;font-size: 20pt; ">用户名：</span>
<input type="text" name = "userid" style="height: 15px;position: relative;"></input><br>
<span style="position:absolute;left:35px;top:55px;font-family: 黑体;font-size: 20pt; ">密码：</span>
<input type="password" name = "pwd" style="height: 15px;position: absolute;left:120px;top:60px"></input>
<br><br>
<input type="submit"  value="提交" onclick="validate()">
</form>
</div>
</body>
</html>