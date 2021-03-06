<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function checkSubmit() {
		var username = document.forms[0].userid.value;
		var password = document.forms[0].pwd.value;
		if (username.length <= 0) {
			alert("用户名不能为空!");
			preventSubmit(event);
		} else if (password <= 0) {
			alert("密码不能为空!");
			preventSubmit(event);
		}

	}
	function preventSubmit(event) {
		alert("不能提交表单!");
		var event = event || window.event;
		event.preventDefault(); // 兼容标准浏览器
		window.event.returnValue = false; // 兼容IE6~8
	};
	function createDate() {
		var sel1 = document.getElementById("sel1");
		var sel2 = document.getElementById("sel2");
		var sel3 = document.getElementById("sel3");
		//生成1900年-2100年
		for (var i = 1900; i <= 2100; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			option.innerHTML = i;
			sel1.appendChild(option);
		}
		//生成1月-12月
		for (var i = 01; i <= 12; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			option.innerHTML = i;
			sel2.appendChild(option);
		}
		//生成1日—31日
		for (var i = 01; i <= 31; i++) {
			var option = document.createElement('option');
			option.setAttribute('value', i);
			option.innerHTML = i;
			sel3.appendChild(option);
		}

	}
</script>
<title>服务器监控系统</title>
</head>
<body>
	<div class="header wrapfix">
		<div class="help">
			<a href="login.jsp" target="_blank" title="登陆"> <font size="5"
				color="blue">登陆入口</font>
			</a> | <a href="###" target="_blank" title="修改密码"> <font size="5"
				color="blue">修改密码</font></a> <span class="tel"
				style="font-size: 15pt; font-family: 黑体">
				</span>
		</div>
	</div>
	<div class="clearfix"></div>
	<div>
		<form action="../Register.do" method="post" id="submit">
			<table style="width: 100%; height: 600px" border="0" cellpadding="4"
				cellspacing="8">
				<tr>
					<td width="700" align="right"><font size="5" color="red">用户名:</font></td>
					<td colspan="2"><input name="userid" type="text"
						class="log_input" /></td>
				</tr>
				<tr>
					<td align="right"><font size="5" color="red">密 码:</font></td>
					<td colspan="2"><input name="pwd" type="password"
						class="log_input2" /></td>
				</tr>
				<tr>
					<td align="right"><font size="5" color="red">性别:</font></td>
					<td><font size="5" color="red">男</font> <input
						style="width: 15%; height: 20px" type="radio" name="sex" value="男"
						style="position: relative;" /> <font size="5" color="blue">女</font>
						<input style="width: 15%; height: 20px" type="radio" name="sex"
						value="女" style="position: relative;" /></td>
				</tr>
				<tr>
					<td align="right"><font size="5" color="blue">文件:</font></td>
					<td><input type="file" style="position: relative;"></input></td>
				</tr>
				<tr>
					<td align="right"><font size="5" color="blue">出生日期:</font></td>
					<td onclick="createDate()"><select name="sel1" id="sel1">
							<option value="year">年</option>
					</select> <select name="sel2" id="sel2">
							<option value="month">月</option>
					</select> <select name="sel3" id="sel3">
							<option value="day">日</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">
						<button type="submit" value="Submit" id="submit"
							onclick="return checkSubmit();">
							<font size="5" color="blue">提交</font>
						</button>
					</td>
					<td>
						<button type="reset" value="取消" id="reset"
							onclick="return preventSubmit();">
							<font size="5" color="blue">取消</font>
						</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>