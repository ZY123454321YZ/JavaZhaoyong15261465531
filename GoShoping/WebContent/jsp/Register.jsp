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
<a href="login.jsp" target="_blank">登陆</a>
<a href="http://localhost:8080/GoShoping/jsp/Register.jsp" target="_blank">注册</a>
<a href="https://www.baidu.com/" target="_blank">修改密码</a>
<form action="../Register"  method="post" >
<span style="position:relative;font-family: 黑体;font-size: 20pt; ">用户名：</span>
<input type="text" name = "username" style="height: 15px;position: relative;"></input><br>
<span style="position:absolute;left:35px;top:55px;font-family: 黑体;font-size: 20pt; ">密码：</span>
<input type="password" name = "password" style="height: 15px;position: absolute;left:120px;top:60px"></input><br>
<span style="position: relative;">性别:</span><input type="radio" name="sex" value="男" style="position: relative;"></input>男
     <input type="radio" name="sex" value="女" style="position: relative;">女<br>
<span style="position: relative;">文件：</span><input type="file" style="position: relative;"></input><br>
出生日期：<select name="birth" style="position: relative;">
         <option  value="0">--请选择--</option>
         <option  value="1986">1986</option>
         <option  value="1987">1987</option>
         <option  value="1988">1988</option>
         <option  value="1989">1989</option>
         <option  value="1990">1990</option>
         <option  value="1991">1991</option>
         <option  value="1992">1992</option>
         <option  value="1993">1993</option>
         <option  value="1994">1994</option>
         <option  value="1995">1995</option>
         <option  value="1996">1996</option>
         <option  value="1997">1997</option>
        </select>年<br>
  <input type="submit"  value="提交" onclick="validate()">
  <input type="reset"  value="取消"><br>
</form>
</div>
</body>
</html>