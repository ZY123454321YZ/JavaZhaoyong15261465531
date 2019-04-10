<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务器监控系统</title>
<style type="text/css">
ul {
	display: inline;
	white-space: nowrap;
}

ul li {
	padding: 10px 20px;
	display: inline-block;
	background-color: hsl(200, 65%, 75%);
	white-space: nowrap;
}
</style>
</head>
<body>
	<div>
		<ul class="fr">
			<li class="fore1 dorpdown" id="ttbar-login"
				clstag="h|keycount|head|topbar_02"><a target="_blank"
				href="../jsp/login.jsp" class="link-login">免费登陆</a>&nbsp;&nbsp;<a
				href="../jsp/regst.jsp" class="link-regist style-red">免费注册</a></li>
			<li class="spacer"></li>
			<li class="fore2" clstag="h|keycount|head|topbar_03">
				<div class="dt">
					<a target="_blank" href="../jsp/controller.jsp">控制平台</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore3 dorpdown" id="ttbar-myjd"
				clstag="h|keycount|head|topbar_04">
				<div class="dt cw-icon">
					<a target="_blank" href="//home.jd.com/">
					管理平台</a>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore4" clstag="h|keycount|head|topbar_05">
				<div class="dt">
					<a target="_blank" href="//vip.jd.com/">租户管理</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore5" clstag="h|keycount|head|topbar_06">
				<div class="dt">
					<a target="_blank" href="//b.jd.com/">公共服务</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore8 dorpdown" id="ttbar-serv"
				clstag="h|keycount|head|topbar_07">
				<div class="dt cw-icon">
				<a target="_blank" href="//b.jd.com/">账户管理</a>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore9 dorpdown" id="ttbar-navs"
				clstag="h|keycount|head|topbar_08">
				<div class="dt cw-icon">
					<a target="_blank" href="//b.jd.com/">日志管理</a>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore10 mobile" id="J_mobile"
				clstag="h|keycount|head|topbar_09">
				<div class="dt mobile_txt">
				<a target="_blank" href="//b.jd.com/">云平台集成</a>
				</div>
				<div class="mobile_static">
					<div class="mobile_static_qrcode"></div>
				</div>
				<div id='J_mobile_pop' class='mod_loading mobile_pop'></div>
			</li>
		</ul>
	</div>
	<div>
		<table border="1" width="100%" height="50">
			<tr>
				<th><a
					href="miaosha.jsp">网络诊断</a></th>
				<th><a href="role.jsp">告警管理</a></th>
				<th><a href="">性能检测</a></th>
				<th><a href="../controller/Operationdata">设备管理</a></th>
			</tr>
		</table>
	</div>
	<div style="background-color: #FF4000; height: 60px">
		<p align="center">
			<a href="jsp/role.jsp" style="">安全防护</a>
		</p>
		<p align="center">
			<a href="help.jsp">帮助中心</a>
		</p>
	</div>
	<div style="background-color: yellow;">
		<table border="1" width="100%" height="400">
			<tr>
				<th><a href="Clothes.jsp">主机监控</a></th>
				<th><a href="role.jsp">网卡监控</a></th>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">日志监控</a></td>
				<td align="center"><a href="role.jsp">硬件监控</a></td>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">应用程序监控</a></td>
				<td align="center"><a href="role.jsp">告警</a></td>
			</tr>
		</table>
	</div>
</body>
</html>