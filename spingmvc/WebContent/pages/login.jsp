<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script >
function doCompare(){
	var path = "../CheckTest.do?"+Math.random();
	$("#pic").attr('src',path);
 /* $.ajax({
    async : false,
    cache : false,
    type : 'get',
    contentType: "image/jpeg",
    url : "http://localhost:8080/GoShoping/CheckTest.do",
    error : function() {
        alert('smx失败 ');
    },
    success : function(data) {
         $("#content-wrapper").html(data); 
        alert(data); 
         $('#pic').innerHTML=data; 
        $('#test').html(data); 
         $('#AjaxBtn').html(data.msg); 
    } 
}); 
        */
	     }
</script>
<title>借贷宝</title>
</head>
<body>
	<div class="header wrapfix">
		<div class="help">
			<a href="###" target="_blank" title="首页">首页</a> | <a href="###"
				target="_blank" title="帮助中心">帮助中心</a> <span class="tel"
				style="font-size: 15pt; font-family: 黑体">客服QQ:15261465531</span>
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
					<form name='form1' method="post" action='../Login.do'>
						<table width="100%" border="0" cellpadding="2" cellspacing="2">
							<tr>
								<td width="50" align="right">用户名：</td>
								<td height="24" colspan="2"><input name="userid"
									type="text" class="log_input" /></td>
							</tr>
							<tr>
								<td align="right">密 码：</td>
								<td height="24" colspan="2"><input name="pwd"
									type="password" class="log_input2" /></td>
							</tr>
							<tr>
								<td align="right">验证码：</td>
								<td height="24" colspan="2"><input type="text" name = "yzm" >
								<img id="pic" src="../CheckTest.do"> 
								<a  id="AjaxBtn" onclick="doCompare();">换一张</a>
								</td>
							</tr>
							<tr>
								<td height="45">&nbsp;</td>
								<td width="106" height="45" valign="middle"><input
									type="submit" value="登陆" onclick="validate()" /></td>
								<td width="74" height="48" valign="middle"><a
									href="pages/regst.jsp" class="Blue">免费注册</a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
</body>
</html>