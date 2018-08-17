<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../jquery/jquery-2.1.0.min.js"></script>
<script>
	function doCompare() {
		var path = "../YZMServlet.do?" + Math.random();
		$("#pic").attr('src', path);
	}
</script>
<title>京东网上商城</title>
</head>
<body>
	<div class="header wrapfix">
		<div class="help">
			<a href="index.jsp" target="_blank" title="首页"> <font size="5"
				color="green">首页 </font>
			</a> <font size="5" color="green">|</font> <a href="###" target="_blank"
				title="帮助中心"> <font size="5" color="green">帮助中心</font>
			</a> <span class="tel" style="font-size: 15pt; font-family: 黑体"> <font
				size="5" color="green">
				客服QQ:834162364</font>
			</span>
		</div>
	</div>
	<div class="clearfix"></div>
	<!-- 清除浮动 -->
	<!-- wrap -->
	<div class="wrap">
		<!-- Login -->
		<div class="Login">
			<div class="Login_L"></div>
			<div class="Login_R">
				<div class="login_zc">
					<form name='form1' method="post" action='../controller/login'>
						<table width="100%" border="0" cellpadding="2" cellspacing="2">
							<tr>
								<td width="50" align="right"><font size="5" color="green">用户名:</font>
								</td>
								<td height="24" colspan="2"><input name="userid"
									type="text" class="log_input" /></td>
							</tr>
							<tr>
								<td align="right">
								<font size="5" color="green">密 码：</font></td>
								<td height="24" colspan="2"><input name="pwd"
									type="password" class="log_input2" /></td>
							</tr>
							<tr>
								<td align="right"><font size="5" color="green">验证码：</font></td>
								<td height="24" colspan="2"><input type="text" name="yzm">
									<img id="pic" src="../YZMServlet.do"> <a id="AjaxBtn"
									onclick="doCompare();">
									<font size="5" color="green">换一张</font></a></td>
							</tr>
							<tr>
								<td height="45">&nbsp;</td>
								<td width="106" height="45" valign="middle">
								<input
									type="submit" style="width: 100%;height: 30pt"    value="登陆" onclick="validate()" />
									</td>
								<td width="74" height="48" valign="middle"><a
									href="regst.jsp" class="Blue">
									<font size="5" color="green">免费注册</font></a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
</body>
</html>